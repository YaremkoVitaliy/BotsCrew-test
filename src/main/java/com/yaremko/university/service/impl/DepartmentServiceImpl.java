package com.yaremko.university.service.impl;

import com.yaremko.university.model.Degree;
import com.yaremko.university.model.Department;
import com.yaremko.university.model.Lector;
import com.yaremko.university.repository.DepartmentRepository;
import com.yaremko.university.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHeadOfDepartment(String name) {
        StringBuilder answer = new StringBuilder("Answer: Head of ").append(name).append(" department is ");
        Optional<Department> department = departmentRepository.findByName(name);
        if (department.isPresent()) {
            answer.append(department.get().getHead().getName());
        } else {
            return "There is no such department as " + name;
        }
        return answer.toString();
    }

    @Override
    public String getDepartmentStatistics(String name) {
        StringBuilder answer = new StringBuilder("Answer: assistans - ");
        Optional<Department> department = departmentRepository.findByName(name);
        List<Lector> lectors;
        if (department.isPresent()) {
            lectors = department.get().getLectors();
        } else {
            return "There is no such department as " + name;
        }
        answer.append(lectors
                .stream()
                .filter(lector -> lector.getDegree().equals(Degree.ASSISTANT))
                .count()
        );
        answer.append("\nassociate professors - ");
        answer.append(lectors
                .stream()
                .filter(lector -> lector.getDegree().equals(Degree.ASSOCIATE_PROFESSOR))
                .count()
        );
        answer.append("\nprofessors - ");
        answer.append(lectors
                .stream()
                .filter(lector -> lector.getDegree().equals(Degree.PROFESSOR))
                .count()
        );
        return answer.toString();
    }

    @Override
    public String calculateAverageSalaryOfDepartment(String name) {
        StringBuilder answer = new StringBuilder("Answer: The average salary of ").append(name).append(" is ");
        Optional<Department> department = departmentRepository.findByName(name);
        List<Double> salaries;
        if (department.isPresent()) {
            salaries = department.get().getLectors()
                    .stream()
                    .map(Lector::getSalary)
                    .collect(Collectors.toList());
        } else {
            return "There is no such department as " + name;
        }
        double averageSalary = salaries.stream().reduce(0.00, Double::sum) / (double) salaries.size();
        answer.append(new DecimalFormat("##.##").format(averageSalary));
        return answer.toString();
    }

    @Override
    public String countEmployeeNumberForDepartment(String name) {
        Optional<Department> department = departmentRepository.findByName(name);
        return department
                .map(value -> "Answer: " + value.getLectors().size())
                .orElseGet(() -> "There is no such department as " + name);
    }
}
