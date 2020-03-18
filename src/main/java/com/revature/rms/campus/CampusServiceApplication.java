package com.revature.rms.campus;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.repositories.CampusMongoRepository;
import com.revature.rms.campus.services.BuildingService;
import com.revature.rms.campus.services.CampusService;
import com.revature.rms.campus.services.RoomService;
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

	@Autowired
	private RoomService roomService;

	@Autowired
	private BuildingService buildingService;

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

		Room room1 = new Room("107", 24, true, room1Status, "1", new ArrayList<String>(), new ResourceMetadata());
		Room room2 = new Room("300", 30, true, room2Status, "2", new ArrayList<String>(), new ResourceMetadata());

		Room room3 = new Room("320", 28, true, new ArrayList<RoomStatus>(), "3", new ArrayList<String>(), new ResourceMetadata());
		Room room4 = new Room("328", 45, true, new ArrayList<RoomStatus>(), "4", new ArrayList<String>(), new ResourceMetadata());
		Room room5 = new Room("200A", 26, true, new ArrayList<RoomStatus>(), "5", new ArrayList<String>(), new ResourceMetadata());
		Room room6 = new Room("200B", 26, true, new ArrayList<RoomStatus>(), "6", new ArrayList<String>(), new ResourceMetadata());
		Room room7 = new Room("1300", 30, true, new ArrayList<RoomStatus>(), "7", new ArrayList<String>(), new ResourceMetadata());
		Room room8 = new Room("1304", 26, true, new ArrayList<RoomStatus>(), "8", new ArrayList<String>(), new ResourceMetadata());
		Room room9 = new Room("1400", 26, true, new ArrayList<RoomStatus>(), "9", new ArrayList<String>(), new ResourceMetadata());
		Room room10 = new Room("1402", 30, true, new ArrayList<RoomStatus>(), "10", new ArrayList<String>(), new ResourceMetadata());
		Room room11 = new Room("2301A", 15, true, new ArrayList<RoomStatus>(), "11", new ArrayList<String>(), new ResourceMetadata());
		Room room12 = new Room("2301B", 15, true, new ArrayList<RoomStatus>(), "12", new ArrayList<String>(), new ResourceMetadata());
		Room room13 = new Room("2301C", 15, true, new ArrayList<RoomStatus>(), "13", new ArrayList<String>(), new ResourceMetadata());
		Room room14 = new Room("2301D", 15, true, new ArrayList<RoomStatus>(), "14", new ArrayList<String>(), new ResourceMetadata());
		Room room15 = new Room("2300", 30, true, new ArrayList<RoomStatus>(), "15", new ArrayList<String>(), new ResourceMetadata());
		Room room16 = new Room("2303", 30, true, new ArrayList<RoomStatus>(), "16", new ArrayList<String>(), new ResourceMetadata());
		Room room17 = new Room("2304", 30, true, new ArrayList<RoomStatus>(), "17", new ArrayList<String>(), new ResourceMetadata());

		roomService.save(room1);
		roomService.save(room2);
		roomService.save(room3);
		roomService.save(room4);
		roomService.save(room5);
		roomService.save(room6);
		roomService.save(room7);
		roomService.save(room8);
		roomService.save(room9);
		roomService.save(room10);
		roomService.save(room11);
		roomService.save(room12);
		roomService.save(room13);
		roomService.save(room14);
		roomService.save(room15);
		roomService.save(room16);
		roomService.save(room17);

		ArrayList<Room> building1Rooms = new ArrayList<>();
		ArrayList<Room> building2Rooms = new ArrayList<>();

		building1Rooms.add(room1);
		building1Rooms.add(room2);
		building1Rooms.add(room3);
		building1Rooms.add(room4);
		building1Rooms.add(room5);
		building1Rooms.add(room6);

		building2Rooms.add(room7);
		building2Rooms.add(room8);
		building2Rooms.add(room9);
		building2Rooms.add(room10);
		building2Rooms.add(room11);
		building2Rooms.add(room12);
		building2Rooms.add(room13);
		building2Rooms.add(room14);
		building2Rooms.add(room15);
		building2Rooms.add(room16);
		building2Rooms.add(room17);

		Building building1 = new Building("NEC", "NEC", new Address(), 5, new ArrayList<Amenity>(), building1Rooms, new ResourceMetadata());
		Building building2 = new Building("BSN", "BSN", new Address(), 4, new ArrayList<Amenity>(), building2Rooms, new ResourceMetadata());

		buildingService.save(building1);
		buildingService.save(building2);

		ArrayList<Building> campus1Buildings = new ArrayList<>();
		campus1Buildings.add(building1);
		campus1Buildings.add(building2);

		Campus campus1 = new Campus("University of South Florida", "USF", new Address(), 1, 2, 3, campus1Buildings, new ArrayList<Integer>(), new ResourceMetadata());
		campusService.save(campus1);
	}
}
