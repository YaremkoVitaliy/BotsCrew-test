package com.yaremko.university.service.impl;

import com.yaremko.university.model.Statistics;
import com.yaremko.university.repository.DepartmentRepository;
import com.yaremko.university.service.DepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHeadOfDepartment(String name) {
        return departmentRepository.findByName(name)
                .filter(it -> Objects.nonNull(it.getHead()))
                .map(it -> "Answer: Head of " + name + " department is " + it.getHead().getName())
                .orElse("There is no such department as " + name);
    }

    @Override
    public String getDepartmentStatistics(String name) {
        List<Statistics> statistics = departmentRepository.departmentStatistics(name);
        if (statistics.isEmpty()) {
            return "There is no such department as " + name;
        }
        return printStatistics(statistics);
    }

    @Override
    public String calculateAverageSalaryOfDepartment(String name) {
        Double avgSalary = departmentRepository.averageDepartmentSalary(name);
        if (Objects.isNull(avgSalary)) {
            return "There is no such department as " + name;
        }
        String result = "Answer: The average salary of " + name + " is ";
        return result + new DecimalFormat("##.##").format(avgSalary);
    }

    @Override
    // Thanks to @Transactional session will remain open until the method end.
    // So it gives opportunity to load and get lectors list
    @Transactional
    public String countEmployeeNumberForDepartment(String name) {
        return departmentRepository.findByName(name)
                .filter(d -> Objects.nonNull(d.getLectors()))
                .map(d -> "Answer: " + d.getLectors().size())
                .orElseGet(() -> "There is no such department as " + name);
    }

    private String printStatistics(List<Statistics> statistics) {
        StringBuilder result = new StringBuilder("Answer: ");
        for (Statistics st : statistics) {
            result
                    .append(System.lineSeparator())
                    .append(st.getDegree().getDegree())
                    .append("s - ")
                    .append(st.getQuantity());
        }
        return result.toString();
    }
}
