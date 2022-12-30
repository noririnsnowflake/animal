package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.DetailForm;
import com.example.demo.model.EditForm;
import com.example.demo.model.RegistForm;
import com.example.demo.service.DetailService;

@Controller
public class DetailController {
	@Autowired
	private DetailService detailService;

	//一覧画面から各動物のリンクをクリックし詳細画面を表示
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int recordId, Model model,DetailForm detailForm) {
		List<DetailForm> listmono = detailService.getRecord(recordId);
	    DetailForm detail = listmono.get(0);
	    detail.setId(String.valueOf(recordId));
	    model.addAttribute("detailForm",detail);

	    	return "detail";
	    }

	//登録画面で動物の情報を入力し詳細画面に表示する
	@PostMapping("/detail")
	public String detail(RegistForm registForm,Model model) {
		//registFormのpicture1に値をセットする
		String img = "cheetah";
		registForm.setPicture1(img);
		//入力値をDBに登録する
		int returnId = detailService.inRecord(registForm);
		String updateID = String.valueOf(returnId);
		registForm.setId(updateID);
		//登録画面で入力した値をdetailFormに格納して画面で表示させる
		model.addAttribute("detailForm", registForm);

			return "detail";
	}

	//編集画面から「戻る」ボタンを押下し詳細画面に戻る（編集画面での入力値の変更はしない）
	@PostMapping("/redetail")
	public String edit(EditForm editForm,Model model) {
		model.addAttribute("detailForm", editForm);

			return "detail";
	}
}
