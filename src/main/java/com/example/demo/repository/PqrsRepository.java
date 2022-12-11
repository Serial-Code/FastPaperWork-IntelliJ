package com.example.demo.repository;

import com.example.demo.entity.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqrsRepository extends JpaRepository<Pqrs, Long> {

    @Query("SELECT pq FROM Pqrs pq WHERE pq.user.id = :id")
    List<Pqrs> getPqrsByUser(@Param("id")Long id);


}
