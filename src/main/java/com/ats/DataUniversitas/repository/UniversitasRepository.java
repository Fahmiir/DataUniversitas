package com.ats.DataUniversitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.ats.DataUniversitas.model.UniversitasModel;


public interface UniversitasRepository extends JpaRepository<UniversitasModel,Integer>{
	@Modifying
	@Query(value="select * from tabel_universitas  where jenis_universitas =?1", nativeQuery = true)
	List<UniversitasModel> searchByJenis(String jenisUniversitas);
}
