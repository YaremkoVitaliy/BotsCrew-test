package com.yaremko.university.service;

public interface DepartmentService {

    String getHeadOfDepartment(String name);

    String getDepartmentStatistics(String name);

    String calculateAverageSalaryOfDepartment(String name);

    String countEmployeeNumberForDepartment(String name);
}
