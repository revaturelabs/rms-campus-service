package com.revature.rms.campus;

import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.services.RoomService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@Info(title = "Room API", version = "1.0", description = "Documentation Room API v1.0")
)
public class RoomServiceApplication implements CommandLineRunner {

    @Autowired
    private RoomService roomService;

    public static void main(String[] args) {
        SpringApplication.run(RoomService.class, args);
    }

    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.revature.rms.campus.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Room API").description("Documentation Room API v1.0").build());
    }

    @Override
    public void run(String... args) throws Exception{

        RoomStatus status1 = new RoomStatus(true, true, "12-13-20", 1, "");
        RoomStatus status2 = new RoomStatus(true,  false, "01-31-20", 2, "Boards were cleaned, chairs were scattered");
        RoomStatus status3 = new RoomStatus(false, true, "02-23-20", 1, "Boards were not cleans, chaired were ordered.");
        RoomStatus status4 = new RoomStatus(false, false, "01-21-20", 3, "The room was in disarray. Boards were not cleaned and chairs unordered.");
        RoomStatus status5 = new RoomStatus(true, false, "02-12-20", 2, "Boards were cleaned, chairs were not ordered");
        RoomStatus status6 = new RoomStatus(true, true, "03-01-20", 4, "No Comment");

        roomService.saveStatus(status1);
        roomService.saveStatus(status2);
        roomService.saveStatus(status3);
        roomService.saveStatus(status4);
        roomService.saveStatus(status5);
        roomService.saveStatus(status6);

        ArrayList<RoomStatus> room1Status = new ArrayList<>();
        ArrayList<RoomStatus> room2Status = new ArrayList<>();

        room1Status.add(status1);
        room1Status.add(status2);
        room1Status.add(status3);
        room2Status.add(status4);
        room2Status.add(status5);
        room2Status.add(status6);

        Room room1 = new Room("2304", 35, true, new ArrayList<RoomStatus>(), "1", new ArrayList<String>(), new ResourceMetadata());
        roomService.save(room1);
    }
}
