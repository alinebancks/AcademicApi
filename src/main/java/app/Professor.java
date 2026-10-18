package app;

import jakarta.persistence.Entity;

@Entity
public class Professor extends Person {

    private Double salary;

    public Professor() {}

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}