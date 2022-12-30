package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IndexDao;
import com.example.demo.model.EditForm;
import com.example.demo.model.IndexForm;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public class IndexDaoImpl implements IndexDao{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public IndexDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<IndexForm> getAll() {
	String sql = "SELECT unique_key,name,features,habitat,picture1 FROM animal.zoo";
	//SQL取得
	List<Map<String, Object>>resultList = jdbcTemplate.queryForList(sql);
	List<IndexForm> list = new ArrayList<IndexForm>();
	for(Map<String,Object> result : resultList) {
		IndexForm index = new IndexForm();
		//unique_keyはint型なのでsetID(String型)に合わせるためint→Stringに型変換する
		index.setId(String.valueOf((int)result.get("unique_key")));
		index.setAnimal((String)result.get("name"));
		index.setFeatures((String)result.get("features"));
		index.setHabitat((String)result.get("habitat"));
		index.setPicture1((String)result.get("picture1"));
		list.add(index);
	}
	return list;
	}

	@Override
	public List<IndexForm> getUpdate(EditForm editForm) {

	String id = editForm.getId();
	int updateID = Integer.parseInt(id);
	String animal = editForm.getAnimal();
	String features = editForm.getFeatures();
	String habitat = editForm.getHabitat();
	//SQL更新
	String sql = "UPDATE animal.zoo set name = " + "\"" + animal + "\"" + ",features = " + "\"" + features + "\"" + ",habitat = " + "\"" + habitat + "\"" + "" + " where unique_key = " + updateID;
	//SQL取得
	jdbcTemplate.update(sql);


		return null;
	}
}

