package com.revature.rms.campus;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.repos.BuildingRepository;
import com.revature.rms.campus.repos.CampusRepository;
import com.revature.rms.campus.repos.RoomRepository;
import com.revature.rms.core.models.ResourceMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.revature.rms.campus.entities.Address.Country;

@EnableEurekaClient
@SpringBootApplication
public class AppConfig implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	private CampusRepository campusRepo;
	private BuildingRepository buildingRepo;
	private RoomRepository roomRepo;

	public AppConfig(CampusRepository cRepo, BuildingRepository bRepo, RoomRepository rRepo) {
		this.campusRepo = cRepo;
		this.buildingRepo = bRepo;
		this.roomRepo = rRepo;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("INIT DATA SOURCE");

		ResourceMetadata metadata_active = new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b64");
		ResourceMetadata metadata_inactive = new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b64", false);

		List<Room> bsnRooms = Arrays.asList(new Room ("1300", 30, new ArrayList<>(), metadata_active),
				new Room("1304", 25, new ArrayList<>(), metadata_active),
				new Room("1400", 30, new ArrayList<>(), metadata_active),
				new Room("1402", 35, new ArrayList<>(), metadata_active),
				new Room("2300", 30, new ArrayList<>(), metadata_active),
				new Room("2301a", 15, new ArrayList<>(), metadata_inactive),
				new Room("2301b", 15, new ArrayList<>(), metadata_active),
				new Room("2301c", 15, new ArrayList<>(), metadata_active),
				new Room("2301d", 15, new ArrayList<>(), metadata_inactive),
				new Room("2303", 25, new ArrayList<>(), metadata_active),
				new Room("2304", 25, new ArrayList<>(), metadata_active));

		List<Room> necRooms = Arrays.asList(new Room ("107", 20, new ArrayList<>(), metadata_active),
				new Room("200a", 25, new ArrayList<>(), metadata_active),
				new Room("200b", 35, new ArrayList<>(), metadata_active),
				new Room("300", 35, new ArrayList<>(), metadata_active),
				new Room("320", 25, new ArrayList<>(), metadata_active),
				new Room("328", 50, new ArrayList<>(), metadata_active));

		bsnRooms.stream().forEach(room -> roomRepo.save(room).block());
		necRooms.stream().forEach(room -> roomRepo.save(room).block());

		Address bsnAddress = new Address("4202 E. Fowler Ave.", "BSN 3403", "Tampa", "FL", "33620", Country.USA);
		Address necAddress = new Address("4202 E. Fowler Ave.", "SVC1072", "Tampa", "FL", "33620", Country.USA);

		List<Amenity> bsnAmenities = Arrays.asList(
				new Amenity("Coffee", AmenityStatus.OK),
				new Amenity("Creamer", AmenityStatus.OK),
				new Amenity("Coffee Stirrers", AmenityStatus.OK),
				new Amenity("Utensils", AmenityStatus.OK),
				new Amenity("Cleaning Wipes", AmenityStatus.OUT),
				new Amenity("Cups", AmenityStatus.LOW)
		);

		List<Amenity> necAmenities = Arrays.asList(
				new Amenity("Coffee", AmenityStatus.OK),
				new Amenity("Creamer", AmenityStatus.OK),
				new Amenity("Coffee Stirrers", AmenityStatus.OK),
				new Amenity("Utensils", AmenityStatus.OK),
				new Amenity("Cleaning Wipes", AmenityStatus.OK),
				new Amenity("Cups", AmenityStatus.OK),
				new Amenity("Water", AmenityStatus.LOW)
		);

		List<Building> usfBuildings = Arrays.asList(
				new Building("Muma College of Business", "BSN", bsnAddress, "5e768d0ef21b4b41fbbd3c5d", bsnAmenities, bsnRooms, metadata_active),
				new Building("Northwest Education Complex", "NEC", necAddress, "5e768d0ef21b4b41fbbd3c5c", necAmenities, necRooms, metadata_active)
		);

		usfBuildings.stream().forEach(bldg -> buildingRepo.save(bldg).block());

		List<String> usfEmployees = Arrays.asList(
				"5e768d0ef21b4b41fbbd3c57",
				"5e768d0ef21b4b41fbbd3c58",
				"5e768d0ef21b4b41fbbd3c59",
				"5e768d0ef21b4b41fbbd3c5a",
				"5e768d0ef21b4b41fbbd3c5b",
				"5e768d0ef21b4b41fbbd3c5c",
				"5e768d0ef21b4b41fbbd3c5d",
				"5e768d0ef21b4b41fbbd3c5e",
				"5e768d0ef21b4b41fbbd3c5f",
				"5e768d0ef21b4b41fbbd3c60",
				"5e768d0ef21b4b41fbbd3c61",
				"5e768d0ef21b4b41fbbd3c62",
				"5e768d0ef21b4b41fbbd3c63",
				"5e768d0ef21b4b41fbbd3c64",
				"5e768d0ef21b4b41fbbd3c65",
				"5e768d0ef21b4b41fbbd3c68"
		);

		Address usfAddress = new Address("4202 E. Fowler Ave.", "Tampa", "FL", "33620", Country.USA);

		Campus usf = new Campus("Revature at University of South Florida", "USF", usfAddress, "5e768d0ef21b4b41fbbd3c57",
				"5e768d0ef21b4b41fbbd3c58", "5e768d0ef21b4b41fbbd3c59", usfBuildings, usfEmployees, metadata_active);

		campusRepo.save(usf).block();

		System.out.println("DATA SOURCE INIT COMPLETE");

	}
}
