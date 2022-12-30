package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EditForm;
import com.example.demo.model.IndexForm;

public interface IndexService {

	List<IndexForm> getAll();

	List<IndexForm> getUpdate(EditForm editForm);
}
