package com.example.demo.daoImpl;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.RegistDao;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public class RegistDaoImpl implements RegistDao{

	//private final JdbcTemplate jdbcTemplate;

	/*@Autowired
	public RegistDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
}


