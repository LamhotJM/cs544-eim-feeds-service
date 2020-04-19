package miu.group3.eimcode_feeds.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miu.group3.eimcode_feeds.documents.Product;
import miu.group3.eimcode_feeds.responses.Response;
import miu.group3.eimcode_feeds.services.ProductService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<Response<List<Product>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<Product>>(this.productService.listarTodos()));
	}
	
	@PostMapping
	public ResponseEntity<Response<Product>> cadastrar(@Valid @RequestBody Product cliente, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Product>(erros));
		}
		
		return ResponseEntity.ok(new Response<Product>(this.productService.save(cliente)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Product>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Product cliente, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Product>(erros));
		}
		
		cliente.setId(id);
		return ResponseEntity.ok(new Response<Product>(this.productService.atualizar(cliente)));
	}
//	@Scheduled(fixedDelay = 10)
//	@DeleteMapping(path = "/{id}")
//	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
//		this.productService.remover(id);
//		return ResponseEntity.ok(new Response<Integer>(1));
//	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	

}
