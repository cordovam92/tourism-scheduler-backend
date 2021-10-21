package edu.citadel.hw1;

import java.time.LocalDate;

public abstract class Employee implements Comparable<Employee> {

    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public int compareTo(Employee o1) {
        return Double.compare(o1.getMonthlyPay(), this.getMonthlyPay());
    }


    public abstract double getMonthlyPay();

}
