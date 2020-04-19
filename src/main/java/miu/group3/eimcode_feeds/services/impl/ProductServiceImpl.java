package miu.group3.eimcode_feeds.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miu.group3.eimcode_feeds.documents.Product;
import miu.group3.eimcode_feeds.repositories.ProductRepository;
import miu.group3.eimcode_feeds.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository clienteRespository;

	@Override
	public List<Product> listarTodos() {
		return this.clienteRespository.findAll();
	}


	@Override
	public Product save(Product cliente) {
		return this.clienteRespository.save(cliente);
	}

	@Override
	public Product atualizar(Product cliente) {
		return this.clienteRespository.save(cliente);
	}

	@Override
	public void removerMany() {
		this.clienteRespository.deleteAll();;
	}

}
