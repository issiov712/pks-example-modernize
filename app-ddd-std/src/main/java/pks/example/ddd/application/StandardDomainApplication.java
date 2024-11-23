package pks.example.ddd.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class StandardDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandardDomainApplication.class, args);
	}

}
