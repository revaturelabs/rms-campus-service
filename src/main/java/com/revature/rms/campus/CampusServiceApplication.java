package com.revature.rms.campus;

import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.repositories.CampusMongoRepository;
import com.revature.rms.campus.services.CampusService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
@OpenAPIDefinition(info =
	@Info(title = "Campus API", version = "1.0", description = "Documentation Campus API v1.0")
)
public class CampusServiceApplication implements CommandLineRunner {

	@Autowired
	private CampusService campusService;

	public static void main(String[] args) {
		SpringApplication.run(CampusServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.revature.rms.campus.controllers"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Campus API").description("Documentation Campus API v1.0").build());
	}

	@Override
	public void run(String... args) throws Exception {
		Campus campus1 = new Campus("University of South Florida", "USF", new Address(), 1, 2, 3, new ArrayList<Building>(), new ArrayList<Integer>(), new ResourceMetadata());
		campusService.save(campus1);
	}
}
