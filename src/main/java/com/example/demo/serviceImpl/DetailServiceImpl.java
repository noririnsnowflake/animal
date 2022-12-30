package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DetailDao;
import com.example.demo.model.DetailForm;
import com.example.demo.model.RegistForm;
import com.example.demo.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService{

	private final DetailDao dao;

	@Autowired
	public DetailServiceImpl(DetailDao dao) {
		this.dao = dao;
	}

	@Override
	public List<DetailForm> getRecord(int recordId) {

		return dao.getRecord(recordId);
	}

	@Override
	public int inRecord(RegistForm registForm) {

		return dao.inRecord(registForm);
	}

}
