package miu.group3.api.services;

import java.util.List;

import miu.group3.api.documents.Product;

public interface ProductService {
	
	List<Product> listarTodos();
	
	Product listarPorId(String id);
	
	Product cadastrar(Product cliente);
	
	Product atualizar(Product cliente);
	
	void remover(String id);

}
