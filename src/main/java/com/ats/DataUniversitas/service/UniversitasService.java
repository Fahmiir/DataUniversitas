package com.ats.DataUniversitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ats.DataUniversitas.model.JenisModel;
import com.ats.DataUniversitas.model.UniversitasModel;
import com.ats.DataUniversitas.repository.JenisRepository;
import com.ats.DataUniversitas.repository.UniversitasRepository;

@Service
@Transactional
public class UniversitasService {
	
      @Autowired
      JenisRepository jr;

      @Autowired
      UniversitasRepository ur;
      
      public List<JenisModel> read(){
    	  return jr.findAll();
      }
      
      public List<UniversitasModel> readUniversitas() {
    	  return ur.findAll();
      }
      
      public void create(UniversitasModel um) {
    	  ur.save(um);
      }
      
      public void edit(UniversitasModel um) {
    	  ur.save(um);
      }
      
      public void delete(int id) {
    	  ur.deleteById(id);
      }
}
