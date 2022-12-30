package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.EditForm;
import com.example.demo.model.IndexForm;
import com.example.demo.service.IndexService;

@Controller
public class HelloController {
	@Autowired
	private IndexService indexService;

	@RequestMapping("/index")
	public String index(Model model,IndexForm indexForm) {

		List<IndexForm> list = indexService.getAll();
		model.addAttribute("indexList",list);

		return "index";
	}

	//編集画面で「完了」処理をした場合、編集した内容をUPDATEし一覧画面を表示する
	@RequestMapping("/reindex")
	public String index(Model model,EditForm editForm,IndexForm indexForm) {

		//List<IndexForm> updateList = indexService.getUpdate(editForm);
		indexService.getUpdate(editForm);
		List<IndexForm> list = indexService.getAll();
		model.addAttribute("indexList",list);
		return "index";
	}
}
