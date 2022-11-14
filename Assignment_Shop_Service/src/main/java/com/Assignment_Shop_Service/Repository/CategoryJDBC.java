package com.Assignment_Shop_Service.Repository;

import com.Assignment_Shop_Service.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CategoryJDBC {
    @Autowired
    JdbcTemplate jdbcTemplate ;
    public Category getCategoryByType(String type){
        String query = "SELECT * FROM Category WHERE TYPE = ?";
        return  jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(Category.class),new Object[]{type});
    }
}