package com.mongodb.Mongo.DB.business;

import com.mongodb.Mongo.DB.dataAccess.StudentRepository;
import com.mongodb.Mongo.DB.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student saveStudent(Student student) {
        studentRepository.findStudentByEmail(student.getEmail())
                        .orElseThrow(() -> new IllegalStateException("Email already exists!!!"));

        student.setCreated(LocalDateTime.now());
        return studentRepository.insert(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }


}
