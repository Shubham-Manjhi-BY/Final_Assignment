package com.Shop_Managment_Service;

import com.Shop_Managment_Service.model.Category;
import com.Shop_Managment_Service.repository.CategoryRepository;
import com.Shop_Managment_Service.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AssignmentShopManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentShopManagementServiceApplication.class, args);
	}

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;


	public AssignmentShopManagementServiceApplication(CategoryRepository userRepository, ProductRepository productRepository) {
		this.categoryRepository = userRepository;
		this.productRepository = productRepository;
	}

	//@Override
	public void run(String... args) throws Exception {
		categoryRepository.save(new Category("Electronics", "Electronic items"));
		categoryRepository.save(new Category("Clothing", "Clothes"));
		categoryRepository.save(new Category("Household", "Household items"));

		categoryRepository.findAll().forEach(System.out::println);


		System.out.println("----------------------------------------------------------------------------------");


	}

}
