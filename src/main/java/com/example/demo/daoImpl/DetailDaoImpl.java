package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.DetailDao;
import com.example.demo.model.DetailForm;
import com.example.demo.model.RegistForm;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public class DetailDaoImpl implements DetailDao{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public DetailDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<DetailForm> getRecord(int recordId) {
		String sql = "SELECT name,features,habitat,picture1 FROM animal.zoo where unique_key =" + recordId;
		//SQL取得
		List<Map<String, Object>>resultList = jdbcTemplate.queryForList(sql);
		List<DetailForm> list = new ArrayList<DetailForm>();
		for(Map<String,Object> result : resultList) {
			DetailForm detail = new DetailForm();
			detail.setAnimal((String)result.get("name"));
			detail.setFeatures((String)result.get("features"));
			detail.setHabitat((String)result.get("habitat"));
			detail.setPicture1((String)result.get("picture1"));
			list.add(detail);
		}
		return list;
	}

	@Override
	public int inRecord(RegistForm registForm) {
		//登録画面での入力値が格納されているregistFormの値をDBに登録する
		String animal = registForm.getAnimal();
		String features = registForm.getFeatures();
		String habitat = registForm.getHabitat();
		String picture = registForm.getPicture1();

		//入力値をレコードに登録する
		String sql = "insert into zoo(unique_key,name,features,habitat,picture1) select max(unique_key)+1,"
						+"\"" + animal + "\",\""+ features + "\",\"" + habitat+ "\",\"" + picture+ "\"" + " " + "from zoo";

		int enterList = jdbcTemplate.update(sql);


		//更新されたデータの行のunique_keyを取得する
		String sql1 = "SELECT max(unique_key) as id from zoo";
		List<Map<String, Object>> getUniquekey = jdbcTemplate.queryForList(sql1);

		int i = getUniquekey.size();
		int returnId = 0;
		while(i == 1){
			Map<String,Object> result = getUniquekey.get(0);
			returnId = ((int)result.get("id"));
			break;
		}

		return returnId;
	}
}

