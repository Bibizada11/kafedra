package com.example.demo.reposotories;

import com.example.demo.models.Teacher;
import com.example.demo.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    Optional<Student> findById(Long id);
}
