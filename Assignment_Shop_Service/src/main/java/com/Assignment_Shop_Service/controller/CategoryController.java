package com.Assignment_Shop_Service.controller;


import com.Assignment_Shop_Service.Entity.Category;
import com.Assignment_Shop_Service.ExceptionHandling.CategoryException;
import com.Assignment_Shop_Service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory(){
        return service.getAllMovie();
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) throws CategoryException {
        return service.saveCategory(category);
    }

    @PatchMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category) throws CategoryException {
        return service.updateCategory(category);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") int Id) throws CategoryException {
        return service.deleteCategory(Id);
    }

}
