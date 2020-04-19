package miu.group3.eimcode_feeds.services;

import java.util.List;

import miu.group3.eimcode_feeds.documents.Product;

public interface ProductService {
	
	List<Product> listarTodos();
	
	Product save(Product cliente);
	
	Product atualizar(Product cliente);

	void removerMany();

}
