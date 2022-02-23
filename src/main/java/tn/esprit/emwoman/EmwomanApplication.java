package tn.esprit.emwoman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmwomanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmwomanApplication.class, args);
	}

}
