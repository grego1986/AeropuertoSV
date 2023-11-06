package com.example.AeropuertoSV.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AsientoAvionId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
    private Avion avion;
    private String numeroAsiento;
    
	public AsientoAvionId() {
		super();
	}

	public AsientoAvionId(Avion avion, String numeroAsiento) {
		super();
		this.avion = avion;
		this.numeroAsiento = numeroAsiento;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public String getNumeroAsiento() {
		return numeroAsiento;
	}

	public void setNumeroAsiento(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avion, numeroAsiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsientoAvionId other = (AsientoAvionId) obj;
		return Objects.equals(avion, other.avion) && Objects.equals(numeroAsiento, other.numeroAsiento);
	}

	@Override
	public String toString() {
		return numeroAsiento;
	}
    
    

}
