package com.ats.DataUniversitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.ats.DataUniversitas.model.JenisModel;
import com.ats.DataUniversitas.model.UniversitasModel;

@Repository
public interface JenisRepository extends JpaRepository<JenisModel,Integer>{


}
