package miu.group3.eimcode_feeds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service

public class BatchJob {
	
	@Autowired
	private ProductService productService;
	
	@Scheduled(cron =" 0 0/1 * 1/1 * ? ")
	public void deleteProduct() {
		System.out.println("------Batch worker run in background to delete old product---");
		productService.removerMany();
	}

}
