package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

public class HourlyEmployee extends Employee {

    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(String name, LocalDate hireDate, double wageRate, double hoursWorked) {
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getMonthlyPay() {
        return wageRate * hoursWorked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name=" + getName() +
                ", hireDate=" + getHireDate().toString() +
                ", wageRate=" + wageRate +
                ", hoursWorked=" + hoursWorked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HourlyEmployee)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return Double.compare(that.wageRate, wageRate) == 0 && Double.compare(that.hoursWorked, hoursWorked) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wageRate, hoursWorked);
    }
}
