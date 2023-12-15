package com.example.AeropuertoSV.controller;

import java.time.LocalDate;
import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AeropuertoSV.entity.Avion;
import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Internacional;
import com.example.AeropuertoSV.entity.Nacional;
import com.example.AeropuertoSV.service.AvionService;
import com.example.AeropuertoSV.service.CiudadService;
import com.example.AeropuertoSV.service.InternacionalService;
import com.example.AeropuertoSV.service.NacionalService;
import com.example.AeropuertoSV.service.TasaInternacionalService;
import com.example.AeropuertoSV.service.TasaNacionalService;
import com.example.AeropuertoSV.service.VueloService;

@Controller
@RequestMapping("/registroVuelo") // archivo html que se va a mapear
public class RegistroVueloController {

	@Autowired
	private CiudadService ciudadServi;
	@Autowired
	private AvionService avionServi;
	@Autowired
	private NacionalService nacionalServi;
	@Autowired
	private InternacionalService internacionalServi;
	@Autowired
	private VueloService vuelo;
	@Autowired
	private TasaNacionalService tnS;
	@Autowired
	private TasaInternacionalService tiS;

	private Validaciones validar = new Validaciones();

	RegistroVueloForm form = new RegistroVueloForm();
	FormPrecio fprecio = new FormPrecio();

	@GetMapping
	public String abrirRegistroVuelo(Model modelo) {

		modelo.addAttribute("formBean", form);
		modelo.addAttribute("nVuelo", form);
		modelo.addAttribute("fecha", form);
		modelo.addAttribute("hora", form);
		modelo.addAttribute("origen", form);
		modelo.addAttribute("destino", form);
		modelo.addAttribute("avionAsignado", form);
		modelo.addAttribute("precio", form);

		return "registroVuelo";
	}

	@ModelAttribute("ciudadOrigen")
	public List<Ciudad> origen() {
		return ciudadServi.getAll();
	}

	@ModelAttribute("ciudadDetino")
	public List<Ciudad> destino() {
		return ciudadServi.getAll();
	}

	@ModelAttribute("aviones")
	public List<Avion> avion() {
		return avionServi.getAll();
	}

	@ModelAttribute("existe")
	public String existe() {
		return form.getExiste();
	}

	@ModelAttribute("tipoVuelo")
	public String tipo() {
		return form.getTipoVuelo();
	}

	@ModelAttribute("moneda")
	public String moneda() {
		form.setMoneda("AR$");
		return form.getMoneda();
	}

	@ModelAttribute("mismaCiudad")
	public String mismaCiudad() {
		return form.getMismaCiudad();
	}

	@ModelAttribute("avionInhabilitado")
	public String avionInhabilitado() {
		return form.getAvionInhabilitado();
	}

	@ModelAttribute("fechag")
	public LocalDate fecha() {
		return form.getFecha();
	}

	@ModelAttribute("numeroInvalido")
	public String numeroInvalido() {
		return form.getNumeroInvalido();
	}

	@PostMapping
	public String registrar(@ModelAttribute("formBean") RegistroVueloForm registro, ModelMap modelo,
			@RequestParam String action) {
		String redirecionar = null;
		String mensaje = "";
		String nvuelo = registro.getnVuelo();
		LocalDate f = registro.getFecha();

		if (action.equals("verificar")) {
			if (validar.vacio(nvuelo)) {
				form.setExiste("No puede estar vacio este campo.");
				modelo.replace("existe", form.getExiste());
			} else {
				// verifica si el numero de vuelo esta disponible
				if (vuelo.consultarVuelo(registro.getnVuelo()) != null) {
					// Vuelo ya existe
					mensaje = "El numero de vuelo ya existe.";
					modelo.replace("existe", mensaje);
					modelo.replace("fechag", f);
					// return "redirect:/registroVuelo";

				} else {
					// vuelo No existe
					mensaje = "El numero de Vuelo se encuentra disponible.";
					modelo.replace("existe", mensaje);

				}
			}

		}

		if (action.equals("guardar")) {
			// verifica si el numero de vuelo esta disponible
			if (validar.vacio(nvuelo)) {
				form.setExiste("No puede estar vacio este campo.");
				modelo.replace("existe", form.getExiste());
			} else {
				if (vuelo.consultarVuelo(registro.getnVuelo()) != null) {

					// vuelo ya existe
					mensaje = "El numero de vuelo ya existe.";
					modelo.replace("existe", mensaje);
					modelo.replace("fechag", f);

				} else {

					if (validar.OrigenDestinoVacio(registro) == false) {
						// vuelo no existe
						// comprobar si origen y destino no sean los mismos
						if (registro.getOrigen() != registro.getDestino()) {

							// origen y destino son distintos
							if (validar.avionVacio(registro) == false) {
								// verifica que el avion no tenga un vuelo asignado a la fecha del nuevo vuelo
								if (avionServi.avionTieneVueloEnFecha(registro.getAvionAsignado(),
										registro.getFecha())) {

									// el avion ya tiene un vuelo asignado en esa fecha
									mensaje = "el avion ya tiene un vuelo para ese dia";
									modelo.replace("avionInhabilitado", mensaje);

								} else {
									// el avion esta disponible ese dia

									// verifica que el precio es un numero
									if (Validaciones.esNumero(registro.getPrecio())) {
										// es numero
										registro.setPrecioVuelo(Double.parseDouble(registro.getPrecio()));
										cargar(registro);
										modelo.clear();
										redirecionar = "redirect:/registroVuelo";

									} else {
										// no es numero
										mensaje = "ingrese un precio valido";
										modelo.replace("numeroInvalido", mensaje);

									}
								}
							}

						} else {
							// origen y destino son los mismos
							mensaje = "La ciudad origen y destino no pueden ser el mismo";
							modelo.replace("mismaCiudad", mensaje);

						}
					}

				}
			}

		}

		if (action.equals("volver")) {
			modelo.clear();
			redirecionar = "redirect:/";
		}

		if (action.equals("vueloTipo")) {
			modelo.replace("tipoVuelo", vuelo(registro));
			modelo.replace("moneda", moneda(registro));
		}

		return redirecionar;
	}

	public void cargar(RegistroVueloForm rvf) {
		int origen = rvf.getOrigen().intValue();
		int destino = rvf.getDestino().intValue();
		Ciudad cOrigen = ciudadServi.consultarCiudad(rvf.getOrigen());
		Ciudad cDestino = ciudadServi.consultarCiudad(rvf.getDestino());

		if (cOrigen.getPais().equals(cDestino.getPais())) {
			Double precio = 0.0;
			Nacional nacional = new Nacional();
			nacional.setnVuelo(rvf.getnVuelo());
			nacional.setFecha(rvf.getFecha());
			nacional.setHora(rvf.getHora());
			nacional.setOrigen(cOrigen);
			nacional.setDestino(cDestino);
			nacional.setAvionAsignado(avionServi.consultarAvion(rvf.getAvionAsignado()));
			nacional.setPrecio(rvf.getPrecioVuelo());
			nacional.setEstado("Normal");
			nacional.setTasa(tnS.consultarTasa(1));

			nacionalServi.cargarNacional(nacional);

		} else {
			Internacional internacional = new Internacional();
			internacional.setnVuelo(rvf.getnVuelo());
			internacional.setFecha(rvf.getFecha());
			internacional.setHora(rvf.getHora());
			internacional.setOrigen(cOrigen);
			internacional.setDestino(cDestino);
			internacional.setAvionAsignado(avionServi.consultarAvion(rvf.getAvionAsignado()));
			internacional.setEstado("Normal");
			internacional.setPrecio(rvf.getPrecioVuelo());
			internacional.setTasa(tiS.consultarTasa(1));

			internacionalServi.cargarInternacional(internacional);

		}
	}

	public String vuelo(RegistroVueloForm rvf) {

		String tipo = null;
		if ((rvf.getOrigen() == null) || (rvf.getDestino() == null)) {
			throw new IllegalArgumentException("La ciudad de origen o Ciudad de destino no puede ser nulos");
		} else {
			Ciudad cOrigen = ciudadServi.consultarCiudad(rvf.getOrigen());
			Ciudad cDestino = ciudadServi.consultarCiudad(rvf.getDestino());
			if (cOrigen.getPais().equals(cDestino.getPais())) {
				tipo = "Vuelo Nacional";
			} else {
				tipo = "Vuelo Internacional";
			}

		}

		return tipo;
	}

	public String moneda(RegistroVueloForm rvf) {
		Ciudad cOrigen = ciudadServi.consultarCiudad(rvf.getOrigen());
		Ciudad cDestino = ciudadServi.consultarCiudad(rvf.getDestino());
		String moneda = null;

		if (cOrigen.getPais().equals(cDestino.getPais())) {
			moneda = "AR$";
		} else {
			moneda = "U$S";
		}

		return moneda;
	}

}
