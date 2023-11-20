package com.yaremko.university.repository;

import com.yaremko.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query("SELECT l.name FROM Lector l WHERE l.name LIKE %?1%")
    List<String> findAllByNameLike(String nameTemplate);

}
