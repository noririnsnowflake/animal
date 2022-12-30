package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.EditForm;
import com.example.demo.model.IndexForm;


public interface IndexDao{

	List<IndexForm> getAll();

	List<IndexForm> getUpdate(EditForm editForm);
}

