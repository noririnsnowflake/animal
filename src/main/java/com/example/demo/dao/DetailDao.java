package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.DetailForm;
import com.example.demo.model.RegistForm;


public interface DetailDao{

	int inRecord(RegistForm registForm);

	List<DetailForm> getRecord(int recordId);
}

