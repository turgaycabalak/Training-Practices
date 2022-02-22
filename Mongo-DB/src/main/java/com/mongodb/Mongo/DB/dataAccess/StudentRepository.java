package com.mongodb.Mongo.DB.dataAccess;

import com.mongodb.Mongo.DB.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {

    Optional<Student> findStudentByEmail(String email);

//    @Query("")
//    void customTestMethod();
}
