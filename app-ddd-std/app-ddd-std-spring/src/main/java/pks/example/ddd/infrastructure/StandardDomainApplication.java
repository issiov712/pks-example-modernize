package pks.example.ddd.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;

@SpringBootApplication
// @Configuration
@ComponentScan(basePackages = {"pks.example.ddd.infrastructure"})
public class StandardDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandardDomainApplication.class, args);
	}

}
