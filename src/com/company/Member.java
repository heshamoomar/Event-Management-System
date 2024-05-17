package com.company;

import java.util.ArrayList;

public class Member extends Person /*implements Display*/{

    private String participantCollege;

    public Member() {
    }

//    public Member(String participantCollege) {
//        this.participantCollege = participantCollege;
//    }

    public Member(String fullName, String address, String email, long phoneNumber, Gender sex, String participantCollege) {
        super(fullName, address, email, phoneNumber, sex);
        this.participantCollege = participantCollege;
    }

    public void displayAll() {
        //System.out.println(super.toString());
        System.out.println(this);
    }

    private ArrayList<Loan> loans;

    public Member(String name, String address, String email, long phoneNumber) {
        // Existing constructor code...
        this.loans = new ArrayList<>();
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }


    @Override
    public String toString() {
        return "Member{" +
                "participantCollege='" + participantCollege + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex=" + sex +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Member{" +
//                "participantCollege='" + participantCollege + '\'' +
//                '}';
//    }

    public String getParticipantCollege() {
        return participantCollege;
    }

    public void setParticipantCollege(String participantCollege) {
        this.participantCollege = participantCollege;
    }
}
