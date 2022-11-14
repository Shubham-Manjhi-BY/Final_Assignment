package com.Assignment_Shop_Service.service;


import com.Assignment_Shop_Service.Entity.Category;
import com.Assignment_Shop_Service.Entity.Product;
import com.Assignment_Shop_Service.ExceptionHandling.ProductException;
import com.Assignment_Shop_Service.Repository.CatergoryRepository;
import com.Assignment_Shop_Service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private CatergoryRepository catergoryRepository;

    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public Product addProduct(Product product) throws ProductException {
        if(product.getProduct_name()==null) throw new ProductException("Name must not be null!").setDefaultException(HttpStatus.NOT_ACCEPTABLE);
        if(product.getProduct_description()==null) throw new ProductException("Description must not be null!").setDefaultException(HttpStatus.NOT_ACCEPTABLE);
        if(product.getProduct_price()==null) throw new ProductException("Price must not be null!").setDefaultException(HttpStatus.NOT_ACCEPTABLE);
        return repository.save(product);
    }

    public Product updateProduct(Product product) throws ProductException {
        try{

            repository.findById(product.getProduct_id());
            return repository.save(product);
        }
        // Add Error
        catch (Exception e){
            throw new ProductException("Wrong Id!").setDefaultException(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public String deleteProduct(int Id) throws ProductException {
        try{
            repository.findById(Id);
            repository.deleteById(Id);
            return "Pass";
        }
        catch (Exception e){
            throw new ProductException("Wrong Id!").setDefaultException(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public Product assignCategoryToProduct(int pID, int cID) throws ProductException {
        try{
            Category category = catergoryRepository.findById(cID).get();
            Product product = repository.findById(pID).get();
            product.addCategory(category);
            repository.save(product);
            return repository.findById(pID).get();
        }
        catch (Exception e){
            throw new ProductException("Wrong Id!").setDefaultException(HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
