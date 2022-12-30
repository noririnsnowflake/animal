package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DetailForm;
import com.example.demo.model.RegistForm;

public interface DetailService {

	int inRecord(RegistForm registForm);

	List<DetailForm> getRecord(int recordId);

}
