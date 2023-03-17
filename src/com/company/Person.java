package com.company;

public abstract class Person {

    public
        String fullName;
        String address;
        String email;
        long phoneNumber;
        enum Gender {male,female}
        Gender sex;

    public Person() {
    }

    public Person(String fullName, String address, String email, long phoneNumber, Gender sex) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.sex = sex;
    }

    public abstract String toString();

//    @Override
//    public String toString() {
//        return "Person{" +
//                "fullName='" + fullName + '\'' +
//                ", address='" + address + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber=" + phoneNumber +
//                ", sex=" + sex +
//                '}';
//    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }
}
