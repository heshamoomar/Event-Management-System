package com.company;

public class Librarian extends Person /*implements  Display*/ {

    private
        int id;
        double salaryPerHour;
        double workedHours;
        double netSalary = (salaryPerHour*workedHours);

    public Librarian() {
    }

//    public Librarian(int id, double salaryPerHour, double workedHours) {
//        this.id = id;
//        this.salaryPerHour = salaryPerHour;
//        this.workedHours = workedHours;
//    }

    public Librarian(String fullName, String address, String email, long phoneNumber, Gender sex,
                     int id, double salaryPerHour, double workedHours) {
        super(fullName, address, email, phoneNumber, sex);
        this.id = id;
        this.salaryPerHour = salaryPerHour;
        this.workedHours = workedHours;
    }

    public void displayAll() {
        //System.out.println(super.toString());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", salaryPerHour=" + salaryPerHour +
                ", workedHours=" + workedHours +
                ", netSalary=" + netSalary +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex=" + sex +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public double getNetSalary() {
        return netSalary;
    }
}
