package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class InheritanceDemo {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        HourlyEmployee johnDoe = new HourlyEmployee("John Doe", LocalDate.of(2009, 5, 21), 50.5, 160);
        HourlyEmployee janeDoe = new HourlyEmployee("Jane Doe", LocalDate.of(2005, 9, 1), 150.5, 80);

        SalariedEmployee moeHoward = new SalariedEmployee("Moe Howard", LocalDate.of(2004, 1, 1), 75000);
        SalariedEmployee curlyHoward = new SalariedEmployee("Curly Howard", LocalDate.of(2018, 1, 1), 105000);

        employees.add(johnDoe);
        employees.add(janeDoe);
        employees.add(moeHoward);
        employees.add(curlyHoward);

        System.out.println("List of Employees (before sorting)");
        employees.forEach(System.out::println);

        Collections.sort(employees);

        System.out.println("List of Employees (after sorting)");
        employees.forEach(System.out::println);

        System.out.println("Monthly Pay");
        employees.forEach(employee -> {
            System.out.print(employee.getName() + ": ");
            System.out.println(employee.getMonthlyPay());
        });

        double total = 0;
        for (Employee e : employees) {
            total += e.getMonthlyPay();
        }

        System.out.println("Total Monthly Pay: " + total);
    }
}
