package com.cultuzz.de;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestDAOService {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected SessionFactory mySessionFactory;
	
	 @Transactional(readOnly=true)
	    public List<TokenData> findAll() {
	        return jdbcTemplate.query("select * from cultagent4.tokenData", 
	                new UserRowMapper());
	    }
	 
	 @Transactional(readOnly=true)
	    public List<TokenData> findAllData() {
		 Criteria criteria = mySessionFactory.getCurrentSession().createCriteria(com.cultuzz.de.DistributorHasCltzProduct.class);
		 List<TokenData> list = criteria.list();
		 return list;
	 }

}
