package miu.group3.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;import miu.group3.api.documents.Product;



@Service

public class BatchJob {
	
	@Autowired
	private ProductService productService;
	
	@Scheduled(cron =" 0 0/1 * 1/1 * ? ")
	public void deleteProduct() {
		System.out.println("in this fun");
		productService.remover("5e960dcda6568242c0ad53cb");
		
		
	}

}
