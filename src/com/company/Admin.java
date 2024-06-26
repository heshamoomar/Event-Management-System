package com.company;

public class Admin extends Person /*implements Display*/ {

    private
        String username;
        String passwd;

    public Admin() {
    }

//    public Admin(String username, String passwd) {
//        this.username = username;
//        this.passwd = passwd;
//    }

    public Admin(String fullName, String address, String email, long phoneNumber, Gender sex, String username, String passwd) {
        super(fullName, address, email, phoneNumber, sex);
        this.username = username;
        this.passwd = passwd;
    }

//    public void displayAll() {
//        //System.out.println(super.toString());
//        System.out.println(this);
//    }

//    @Override
//    public String toString() {
//        return "Admin{" +
//                "username='" + username + '\'' +
//                ", passwd='" + passwd + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex=" + sex +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
