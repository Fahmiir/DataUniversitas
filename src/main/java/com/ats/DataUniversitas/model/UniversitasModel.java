package com.ats.DataUniversitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TabelUniversitas")
public class UniversitasModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="NamaUniversitas")
	private String NamaUniversitas;
	
	@Column(name="JenisUniversitas")
	private String JenisUniversitas;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNamaUniversitas() {
		return NamaUniversitas;
	}

	public void setNamaUniversitas(String namaUniversitas) {
		NamaUniversitas = namaUniversitas;
	}

	public String getJenisUniversitas() {
		return JenisUniversitas;
	}

	public void setJenisUniversitas(String jenisUniversitas) {
		JenisUniversitas = jenisUniversitas;
	}
	
	

}
