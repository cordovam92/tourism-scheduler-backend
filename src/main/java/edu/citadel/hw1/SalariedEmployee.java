package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

public class SalariedEmployee extends Employee {

    private double annualSalary;

    public SalariedEmployee(String name, LocalDate hireDate, double annualSalary) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double getMonthlyPay() {
        return annualSalary / 12;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "name=" + getName() +
                ", hireDate=" + getHireDate().toString() +
                ", annualSalary=" + annualSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalariedEmployee)) return false;
        SalariedEmployee that = (SalariedEmployee) o;
        return Double.compare(that.annualSalary, annualSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(annualSalary);
    }
}
