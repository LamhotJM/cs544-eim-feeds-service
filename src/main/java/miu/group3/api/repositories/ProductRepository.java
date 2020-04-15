package miu.group3.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import miu.group3.api.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	
	//List<Product> product = 

}
