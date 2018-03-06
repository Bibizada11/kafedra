package com.example.demo.reposotories;

import com.example.demo.models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TaecherRepository extends CrudRepository<Teacher, Long> {
    Optional<Teacher> findById(Long id);
}

