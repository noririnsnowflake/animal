package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.DetailForm;

@Controller
public class EditController {

	@PostMapping("/edit")
	public String edit(DetailForm detailForm,Model model) {
		model.addAttribute("editForm", detailForm);
	  return "edit";
	}
}
