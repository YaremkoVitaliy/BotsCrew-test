package com.yaremko.university.repository;

import com.yaremko.university.model.Department;
import com.yaremko.university.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    @Query(value = "SELECT AVG(l.salary) " +
            "FROM department as d " +
            "   inner join department_lector as dl on d.id = dl.department_id " +
            "   inner join lector as l on dl.lector_id = l.id " +
            "WHERE d.name = ?1",
            nativeQuery = true)
    Double averageDepartmentSalary(String department);

    @Query(value = "SELECT new com.yaremko.university.model.Statistics(l.degree, COUNT(l.degree)) " +
            "FROM Department as d " +
            "   inner join d.lectors l " +
            "WHERE d.name = ?1 " +
            "GROUP BY l.degree")
    List<Statistics> departmentStatistics(String name);

}
