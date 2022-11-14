package com.Assignment_Shop_Service.controller;

import com.Assignment_Shop_Service.Entity.Product;
import com.Assignment_Shop_Service.ExceptionHandling.ProductException;
import com.Assignment_Shop_Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/getAllProduct")
    private List<Product> getAllProduct(){
        return service.getAllProduct();
    }

    @PostMapping("/addProduct")
    private Product addProduct(@RequestBody Product product) throws ProductException {
        return service.addProduct(product);
    }

    @PatchMapping("/updateProduct")
    private Product updateProduct(@RequestBody Product product) throws ProductException {
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteCategory(@PathVariable("id") int Id) throws ProductException {
        return service.deleteProduct(Id);
    }

    // Assigning
    @GetMapping("/{pid}-with-{cid}")
    public Product assignProduct(@PathVariable("pid") int pId, @PathVariable("cid") int cId) throws ProductException {
        return service.assignCategoryToProduct(pId,cId);
    }
}
