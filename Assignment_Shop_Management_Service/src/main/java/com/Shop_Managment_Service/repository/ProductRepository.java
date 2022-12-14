package com.Shop_Managment_Service.repository;

import com.Shop_Managment_Service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //--------------------UPDATE QUERIES (BY ANY FIELD) ------------------------//

    @Modifying
    @Query("UPDATE Product p SET p.description = :description " +
            "WHERE p.id = :id")
    void updateProductDescriptionById(@Param("id") int id,
                                      @Param("description") String description);

    @Modifying
    @Query("UPDATE Product p SET p.price = :price " +
            "WHERE p.id = :id")
    void updateProductPriceById(@Param("id") int id,
                                @Param("price") double price);

    @Modifying
    @Query("UPDATE Product p SET p.name = :name " +
            "WHERE p.id = :id")
    void updateProductNameById(@Param("id") int id,
                               @Param("name") String name);




    //--------------------SELECT QUERIES (BY ANY FIELD) ------------------------//
    @Modifying
    @Query("SELECT p " +
            "FROM Product p " +
            "WHERE p.name = :name")
    List<Product> getProductsByName(@Param("name") String name);

    @Modifying
    @Query("SELECT p " +
            "FROM Product p " +
            "WHERE p.price = :price")
    List<Product> getProductsByPrice(@Param("price") double price);

    @Modifying
    @Query("SELECT p " +
            "FROM Product p " +
            "WHERE p.description = :description")
    List<Product> getProductsByDescription(@Param("description") String description);

}
