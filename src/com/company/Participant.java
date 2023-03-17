package com.company;

public class Participant extends Person /*implements Display*/{

    private String participantCollege;

    public Participant() {
    }

//    public Participant(String participantCollege) {
//        this.participantCollege = participantCollege;
//    }

    public Participant(String fullName, String address, String email, long phoneNumber, Gender sex, String participantCollege) {
        super(fullName, address, email, phoneNumber, sex);
        this.participantCollege = participantCollege;
    }

    public void displayAll() {
        //System.out.println(super.toString());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Participant{" +
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
//        return "Participant{" +
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
