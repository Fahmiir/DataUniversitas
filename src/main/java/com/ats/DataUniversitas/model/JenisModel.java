package com.ats.DataUniversitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TabelJenis")
public class JenisModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Jenis")
	private String Jenis;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getJenis() {
		return Jenis;
	}

	public void setJenis(String jenis) {
		Jenis = jenis;
	}

	
}
