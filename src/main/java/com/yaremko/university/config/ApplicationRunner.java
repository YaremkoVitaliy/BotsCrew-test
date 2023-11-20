package com.yaremko.university.config;

import com.yaremko.university.model.UserInput;
import com.yaremko.university.service.DepartmentService;
import com.yaremko.university.service.LectorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public ApplicationRunner(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String departmentName;
        String template;
        System.out.println("To see the list of available commands enter \"help\". To stop the application enter \"exit\".");
        while (sc.hasNextLine()) {
            String userInput = sc.nextLine();
            if (userInput.startsWith(UserInput.DEPARTMENT_HEAD.getInput())) {
                departmentName = userInput.replaceFirst(
                        UserInput.DEPARTMENT_HEAD.getInput(),
                        ""
                );
                System.out.println(departmentService.getHeadOfDepartment(departmentName));
            } else if (userInput.startsWith(UserInput.DEPARTMENT_STATISTICS_START.getInput())
                    && userInput.endsWith(UserInput.DEPARTMENT_STATISTICS_END.getInput())) {
                departmentName = userInput.replaceFirst(
                                UserInput.DEPARTMENT_STATISTICS_START.getInput(),
                                "")
                        .replace(
                                UserInput.DEPARTMENT_STATISTICS_END.getInput(),
                                ""
                        );
                System.out.println(departmentService.getDepartmentStatistics(departmentName));
            } else if (userInput.startsWith(UserInput.DEPARTMENT_AVERAGE_SALARY.getInput())) {
                departmentName = userInput.replaceFirst(
                        UserInput.DEPARTMENT_AVERAGE_SALARY.getInput(),
                        ""
                );
                System.out.println(departmentService.calculateAverageSalaryOfDepartment(departmentName));
            } else if (userInput.startsWith(UserInput.DEPARTMENT_COUNT_OF_EMPLOYEE.getInput())) {
                departmentName = userInput.replaceFirst(
                        UserInput.DEPARTMENT_COUNT_OF_EMPLOYEE.getInput(),
                        ""
                );
                System.out.println(departmentService.countEmployeeNumberForDepartment(departmentName));
            } else if (userInput.startsWith(UserInput.LECTOR_GLOBAL_SEARCH.getInput())) {
                template = userInput.replaceFirst(
                        UserInput.LECTOR_GLOBAL_SEARCH.getInput(),
                        ""
                );
                System.out.println(lectorService.searchByTemplate(template));
            } else if (userInput.equals("help")) {
                UserInput.printListOfUserInputs();
            } else if (userInput.equals("exit")) {
                return;
            } else {
                System.out.println("There is no such command. Enter \"help\" to see all available commands.");
            }
        }
    }
}
