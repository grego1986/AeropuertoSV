package com.example.AeropuertoSV.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dni;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "domicilio")
	private String domicilio;
	@Column(name = "mail")
	private String mail;
	@Column(name = "nacimiento")
	private String fNacimiento;
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Pasaporte pasaporte;
	@OneToMany(mappedBy = "cliente")
	private List<Pasaje> pasaje;
	
	
	public Cliente() {
		super();
	}
	
	public Cliente(long dni, String nombre, String apellido, String domicilio, String mail, String fNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.mail = mail;
		this.fNacimiento = fNacimiento;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	
	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

	public List<Pasaje> getPasaje() {
		return pasaje;
	}

	public void setPasaje(List<Pasaje> pasaje) {
		this.pasaje = pasaje;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", mail=" + mail + ", fNacimiento=" + fNacimiento + "]";
	}
	
	
}
