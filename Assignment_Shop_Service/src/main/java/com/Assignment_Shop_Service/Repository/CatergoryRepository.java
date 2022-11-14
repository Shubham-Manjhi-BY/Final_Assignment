package com.Assignment_Shop_Service.Repository;


import com.Assignment_Shop_Service.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatergoryRepository extends JpaRepository<Category,Integer> {

}