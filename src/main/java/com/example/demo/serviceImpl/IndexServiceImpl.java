package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IndexDao;
import com.example.demo.model.EditForm;
import com.example.demo.model.IndexForm;
import com.example.demo.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService{

	private final IndexDao dao;

	@Autowired
	public IndexServiceImpl(IndexDao dao) {
		this.dao = dao;
	}

	@Override
	public List<IndexForm> getAll(){

		return dao.getAll();
	}

	@Override
	public List<IndexForm> getUpdate(EditForm editForm) {

		return dao.getUpdate(editForm);
	}

}
