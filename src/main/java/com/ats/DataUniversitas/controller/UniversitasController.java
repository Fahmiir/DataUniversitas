package com.ats.DataUniversitas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.DataUniversitas.model.JenisModel;
import com.ats.DataUniversitas.model.UniversitasModel;
import com.ats.DataUniversitas.service.UniversitasService;

@Controller
public class UniversitasController {
	
	@Autowired
	UniversitasService us;
	
	
	@RequestMapping(value="/")
	public String menuHome(Model model) {
		List<JenisModel> jm = new ArrayList<>();
		List<UniversitasModel> um = new ArrayList<>();
		jm = us.read();
	    um = us.readUniversitas();
		model.addAttribute("ListJenisModel",jm);
		model.addAttribute("ListUniversitasModel",um);
		return "home";
	}
	
	@RequestMapping(value="/save")
	public String menuSave(HttpServletRequest request) {
		String NamaUniversitas = request.getParameter("NamaUniversitas");
		String JenisUniversitas = request.getParameter("JenisUniversitas");
		UniversitasModel um = new UniversitasModel();
		um.setNamaUniversitas(NamaUniversitas);
		um.setJenisUniversitas(JenisUniversitas);
		us.create(um);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit")
	public String menuEdit(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String NamaUniversitas = request.getParameter("NamaUniversitas");
		String JenisUniversitas = request.getParameter("editJenisUniversitas");
		UniversitasModel um = new UniversitasModel();
		um.setId(id);
		um.setNamaUniversitas(NamaUniversitas);
		um.setJenisUniversitas(JenisUniversitas);
		us.edit(um);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", produces="text/plain")
	@ResponseBody
	public String deleteData(@RequestBody Integer id) {
		us.delete(id);
		return "redirect:/";
	}
}
