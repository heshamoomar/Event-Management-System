package com.company;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.*;

public class Main {

//          USERNAME IS "user1" AND PASSWORD IS "1234"
//          USERNAME IS "user1" AND PASSWORD IS "1234"
//          USERNAME IS "user1" AND PASSWORD IS "1234"

    static void printInterface(){
        String username = JOptionPane.showInputDialog("Enter Your Username:");
        String passwd = JOptionPane.showInputDialog("Enter Your Password:");
        if (username.equals("user1") && passwd.equals("1234")) {
            JOptionPane.showMessageDialog(null,
                    "Access Granted.",
                    "Message",
                    JOptionPane.WARNING_MESSAGE
            );
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println();
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("\t\t\t\t Event Management");
            System.out.println("Welcome\t\t\t\t\t\t\t\t" + dtf.format(now));
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("0. Exit.");
            System.out.println("1. Display number of participants in your event.");
            System.out.println("2. Display info of participants of your event.");
            System.out.println("3. Remove participant from your event.");
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Incorrect Username or Password!",
                    "Alert",
                    JOptionPane.WARNING_MESSAGE
            );
            System.exit(1);
        }

    }

    static void secondaryInterface(){
        System.out.println();
        System.out.println("What else? :)");
        System.out.println("0. Exit.");
        System.out.println("1. Display number of participants in your event.");
        System.out.println("2. Display info of participants of your event.");
        System.out.println("3. Remove participant from your event.");
    }

    public static void main(String[] args) {

        Manager m1 = new Manager("Hesham Omar","Nasr City, Cairo","hesham.omar1122@gmail.com",
                1129166147, Person.Gender.male,"heshamOmar","1234");

        Event ev1 = new Event("Christmas","The new year celebration will be on college campus",
                "1/1/2022",6, Event.EventType.Yearly);

        EventOrganizers eo1 = new EventOrganizers("Abdallah","Cairo","abdallah@.com3",
                838383838, Person.Gender.male, 2235,12,4);

        EventOrganizers eo2 = new EventOrganizers("Mostafa Ayman","Helwan","mostafa@.com3",
                12211312, Person.Gender.male,1933,13,2);

        Participant p1 = new Participant("Ahmed","Banha","ahmed@.com3",776765333,
                Person.Gender.male,"CIC");

        Participant p2 = new Participant("Mahmoud","Giza","mahmoud@.com3",333342211,
                Person.Gender.male,"CS, Ciro Uni");

        Participant p3 = new Participant("mohamed","Helwan","mohamed@.com3",12334554,
                Person.Gender.male,"IS, Helwan Uni");

//        System.out.println(m1.toString());
//        System.out.println(ev1.toString());
//        System.out.println(eo1.toString());
//        System.out.println(eo2.toString());
//        System.out.println(p1.toString());
//        System.out.println(p2.toString());
//        System.out.println(p3.toString());

        ev1.ParticipantsAndOrganizersList.add(eo1);
        ev1.ParticipantsAndOrganizersList.add(eo2);
        ev1.ParticipantsAndOrganizersList.add(p1);
        ev1.ParticipantsAndOrganizersList.add(p2);
        ev1.ParticipantsAndOrganizersList.add(p3);

        printInterface();
        Scanner input = new Scanner(System.in);

        int selection, removeChoice;

        do {
            selection = input.nextInt();
            switch (selection) {
                case (0) -> System.out.println("Goodbye :)");
                case (1) -> System.out.println("You have " + ev1.getNumberOfPersons() + " People");
                case (2) -> ev1.displayAll();
                case (3) -> {
                    try{
                        System.out.println("Which person to remove:");
                        int i;
                        for (i = 1; i <= ev1.ParticipantsAndOrganizersList.size(); i++)
                            System.out.print(i + ", ");
                        System.out.println("?");
                        removeChoice = input.nextInt();
                        ev1.removePerson((removeChoice - 1));
                        System.out.println("Person " + removeChoice + " was removed :)");
                        secondaryInterface();
                    }
                    catch (Exception exception){
                        System.out.println("Error, out of list boundaries!");
                        secondaryInterface();
                    }
                }
                default -> System.out.println("Invalid input :(");
            }
        }
        while (selection !=0);
    }
}
