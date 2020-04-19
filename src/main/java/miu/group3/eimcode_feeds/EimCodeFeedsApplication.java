package miu.group3.eimcode_feeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EimCodeFeedsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EimCodeFeedsApplication.class, args);
	}
}
