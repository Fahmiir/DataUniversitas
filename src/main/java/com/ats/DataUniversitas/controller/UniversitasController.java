package com.ats.DataUniversitas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.DataUniversitas.model.JenisModel;
import com.ats.DataUniversitas.model.UniversitasModel;
import com.ats.DataUniversitas.service.UniversitasService;

@Controller
public class UniversitasController {

	@Autowired
	UniversitasService us;

	@RequestMapping(value = "/", produces = "text/plain")
	public String menuHome(Model model, @RequestBody(required = false) String selectedJenisUniversitas) {
		List<JenisModel> jm = new ArrayList<>();
		List<UniversitasModel> um = new ArrayList<>();
		System.out.println("controller 2 " + selectedJenisUniversitas);
		jm = us.read();
		um = us.readUniversitas(selectedJenisUniversitas);
		System.out.println("Panjang um adalah " + um.size());
		model.addAttribute("ListJenisModel", jm);
		model.addAttribute("ListUniversitasModel", um);
		return "home";
	}

	
	  @RequestMapping(value="/search") 
	  public String menuSearch(@RequestBody(required=false) String selectedJenisUniversitas) {
	  System.out.println("search "+selectedJenisUniversitas); 
	  return "redirect:/"; 
	}
	 

	@RequestMapping(value = "/save")
	public String menuSave(HttpServletRequest request) {
		String NamaUniversitas = request.getParameter("NamaUniversitas");
		String JenisUniversitas = request.getParameter("JenisUniversitas");
		UniversitasModel um = new UniversitasModel();
		um.setNamaUniversitas(NamaUniversitas);
		um.setJenisUniversitas(JenisUniversitas);
		us.create(um);
		return "redirect:/";
	}

	@RequestMapping(value = "/edit")
	public String menuEdit(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String NamaUniversitas = request.getParameter("NamaUniversitas");
		String JenisUniversitas = request.getParameter("editJenisUniversitas");
		String LabelUniversitas = request.getParameter("labelJenisUniversitas");
		System.out.println("Label Universitas " + LabelUniversitas);
		UniversitasModel um = new UniversitasModel();
		um.setId(id);
		um.setNamaUniversitas(NamaUniversitas);
		um.setJenisUniversitas(JenisUniversitas);
		us.edit(um);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", produces = "text/plain")
	@ResponseBody
	public String deleteData(@RequestBody Integer id) {
		us.delete(id);
		return "redirect:/";
	}
}
