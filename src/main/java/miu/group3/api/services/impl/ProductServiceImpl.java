package miu.group3.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miu.group3.api.documents.Product;
import miu.group3.api.repositories.ProductRepository;
import miu.group3.api.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository clienteRespository;

	@Override
	public List<Product> listarTodos() {
		return this.clienteRespository.findAll();
	}

	@Override
	public Product listarPorId(String id) {
		return this.clienteRespository.findOne(id);
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
	public void remover(String id) {
		this.clienteRespository.delete(id);
	}
	
	@Override
	public void removerMany() {
		this.clienteRespository.deleteAll();;
	}

}
