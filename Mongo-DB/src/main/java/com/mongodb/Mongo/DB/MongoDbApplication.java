package com.mongodb.Mongo.DB;

import com.mongodb.Mongo.DB.dataAccess.StudentRepository;
import com.mongodb.Mongo.DB.entities.Address;
import com.mongodb.Mongo.DB.entities.Gender;
import com.mongodb.Mongo.DB.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentRepository studentRepository){
//		return args -> {
//			Address address = new Address(
//					"Turkey",
//					"Istanbul",
//					"34"
//			);
//			Student student = new Student(
//					"ayaz",
//					"armagan",
//					"ayazarm2@mail.com",
//					Gender.MALE,
//					address,
//					List.of("Java","MongoDB"),
//					BigDecimal.TEN,
//					LocalDateTime.now()
//			);
//
//			studentRepository.findStudentByEmail(student.getEmail())
//							.ifPresentOrElse(s -> {
//								throw new IllegalStateException("Email alredy exits!!!");
//							}, () -> {
//								studentRepository.insert(student);
//							});
//		};
//	}

}
