package com.yaremko.university.model;

import lombok.Getter;

@Getter
public enum UserInput {

    DEPARTMENT_HEAD("Who is head of department "),
    DEPARTMENT_STATISTICS_START("Show "),
    DEPARTMENT_STATISTICS_END(" statistics"),
    DEPARTMENT_AVERAGE_SALARY("Show the average salary for the department "),
    DEPARTMENT_COUNT_OF_EMPLOYEE("Show count of employee for "),
    LECTOR_GLOBAL_SEARCH("Global search by ");

    private final String input;

    UserInput(String input) {
        this.input = input;
    }

    public static void printListOfUserInputs() {
        String departmentName = "{department_name}";
        System.out.println(DEPARTMENT_HEAD.input + departmentName);
        System.out.println(DEPARTMENT_STATISTICS_START.input + departmentName + DEPARTMENT_STATISTICS_END.input);
        System.out.println(DEPARTMENT_AVERAGE_SALARY.input + departmentName);
        System.out.println(DEPARTMENT_COUNT_OF_EMPLOYEE.input + departmentName);
        String template = "{template}";
        System.out.println(LECTOR_GLOBAL_SEARCH.input + template);
    }
}
