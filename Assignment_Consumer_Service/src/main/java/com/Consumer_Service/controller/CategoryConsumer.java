package com.Consumer_Service.controller;

import com.Consumer_Service.model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
@FeignClient("shopManagement-service/category")
public interface CategoryConsumer {

    @GetMapping("/check")
    String check();


    @RequestMapping(value = "/get-categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Category> getCategories();

    @RequestMapping(value = "/add-category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    Category addCategory(@RequestBody Category category);


    @RequestMapping(value = "/update-category-by-id/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    String updateCategoryById(@PathVariable("id") int category_id, @RequestBody Map<String, Object> map);


    @RequestMapping(value = "/delete-category-by-id/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    String deleteCategoryById(@PathVariable("id") int category_id);

}