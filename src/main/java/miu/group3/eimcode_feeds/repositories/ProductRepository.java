package miu.group3.eimcode_feeds.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import miu.group3.eimcode_feeds.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	
	//List<Product> product = 

}
