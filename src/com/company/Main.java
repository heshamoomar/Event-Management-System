package com.company;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.*;
import java.time.LocalDate; // Import LocalDate
import com.company.Library; // Import Library class if it's in a different package

public class Main {

//          USERNAME IS "user1" AND PASSWORD IS "1234"
//          USERNAME IS "user1" AND PASSWORD IS "1234"
//          USERNAME IS "user1" AND PASSWORD IS "1234"

    static void printInterface() {
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
            System.out.println("\t\t\t\t Library Management");
            System.out.println("Welcome\t\t\t\t\t\t\t\t" + dtf.format(now));
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Incorrect Username or Password!",
                    "Alert",
                    JOptionPane.WARNING_MESSAGE
            );
            System.exit(1);
        }

    }

   static void secondaryInterface() {
        System.out.println("What else? :)");
        System.out.println("0. Exit.");
        System.out.println("1. Display members in your library");
        System.out.println("2. Display info of members in your library");
        System.out.println("3. Remove members from your library");
        System.out.println("4. Add a book to your library");
        System.out.println("5. Display added books"); // New option to display added books
       System.out.println("6. Loan a book.");
       System.out.println("7. Return a book.");
       System.out.print("Enter your selection: ");
    }

    public static void main(String[] args) {

        Admin ad1 = new Admin("Hesham Omar", "Nasr City, Cairo", "hesham.o@gmail.com",
                1129166147, Person.Gender.male, "heshamOmar", "1234");

        Library library1 = new Library("Christmas", "The new year celebration will be on college campus",
                "1/1/2022", 6);

        Librarian librarian1 = new Librarian("Abdallah", "Cairo", "abdallah@.com3",
                838383838, Person.Gender.male, 2235, 12, 4);

        Librarian librarian2 = new Librarian("Mostafa Ayman", "Helwan", "mostafa@.com3",
                12211312, Person.Gender.male, 1933, 13, 2);

        Member m1 = new Member("Ahmed", "Banha", "ahmed@.com3", 776765333,
                Person.Gender.male, "CIC");

        Member m2 = new Member("Mahmoud", "Giza", "mahmoud@.com3", 333342211,
                Person.Gender.male, "CS, Ciro Uni");

        Member m3 = new Member("mohamed", "Helwan", "mohamed@.com3", 12334554,
                Person.Gender.male, "IS, Helwan Uni");

//        System.out.println(ad1.toString());
//        System.out.println(library1.toString());
//        System.out.println(librarian1.toString());
//        System.out.println(librarian2.toString());
//        System.out.println(m1.toString());
//        System.out.println(m2.toString());
//        System.out.println(m3.toString());

        library1.People.add(librarian1);
        library1.People.add(librarian2);
        library1.People.add(m1);
        library1.People.add(m2);
        library1.People.add(m3);

        printInterface();
        Scanner input = new Scanner(System.in);

        int selection, removeChoice;

        do {
            System.out.println();
            System.out.println("Choose an option:");
            System.out.println("0. Exit");
            System.out.println("1. Display members in your library");
            System.out.println("2. Display info of members in your library");
            System.out.println("3. Remove members from your library");
            System.out.println("4. Add a book to your library");
            System.out.println("5. Display added books"); // New option to display added books
            System.out.println("6. Loan a book.");
            System.out.println("7. Return a book.");
            System.out.println();
            System.out.print("Enter your selection: ");

            selection = input.nextInt();

            switch (selection) {
                case 0:
                    System.out.println("Goodbye :)");
                    break;
                case 1:
                    System.out.println("You have " + library1.getNumberOfPersons() + " People");
                    break;

                case 2:
                    library1.displayAll();
                    break;
                case 3:
                    try {
                        System.out.println("Which person to remove:");
                        int i;
                        for (i = 1; i <= library1.People.size(); i++)
                            System.out.print(i + ", ");
                        System.out.println("?");
                        removeChoice = input.nextInt();
                        library1.removePerson((removeChoice - 1));
                        System.out.println("Person " + removeChoice + " was removed :)");
                        //secondaryInterface();
                    } catch (Exception exception) {
                        System.out.println("Error, out of list boundaries!");
                        //secondaryInterface();
                    }
                    break;
                case 4:
                    System.out.println("Enter details of book:");
                    System.out.print("Title: ");
                    String title = input.next();
                    System.out.print("Author: ");
                    String author = input.next();
                    System.out.print("Publisher: ");
                    String publisher = input.next();
                    System.out.print("Publication Date: ");
                    String publicationDate = input.next();
                    Book book = new Book(title, author, publisher, publicationDate);
                    library1.addBook(book);
                    System.out.println("Book added successfully!");
                    //secondaryInterface();
                    break;
                case 5:
                    System.out.println();
                    library1.displayBooks();
                    //secondaryInterface();
                    break;
                case 6:
                    System.out.println("Enter details for loan:");
                    System.out.print("Enter member name: ");
                    String memberName = input.next();
                    System.out.print("Enter book title: ");
                    String bookTitle = input.next();
                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dueDateStr = input.next();
                    LocalDate dueDate = LocalDate.parse(dueDateStr);
                    // Find member and book
                    Member member = null;
                    Book loanBook = null;
                    for (Person person : library1.getPeople()) {
                        if (person instanceof Member && ((Member) person).getFullName().equals(memberName)) {
                            member = (Member) person;
                            break;
                        }
                    }
                    for (Book bk : library1.getBooksList()) {
                        if (bk.getTitle().equals(bookTitle)) {
                            loanBook = bk;
                            break;
                        }
                    }
                    if (member != null && loanBook != null) {
                        library1.loanBook(loanBook, member, dueDate);
                    } else {
                        System.out.println("Member or book not found.");
                    }
                    secondaryInterface();
                    break;
                case 7:
                    System.out.println("Enter details for returning a book:");
                    System.out.print("Enter member name: ");
                    String returnMemberName = input.next();
                    System.out.print("Enter book title: ");
                    String returnBookTitle = input.next();
                    // Find member and book
                    Member returnMember = null;
                    Book returnBook = null;
                    for (Person person : library1.getPeople()) {
                        if (person instanceof Member && ((Member) person).getFullName().equals(returnMemberName)) {
                            returnMember = (Member) person;
                            break;
                        }
                    }
                    for (Book bk : library1.getBooksList()) {
                        if (bk.getTitle().equals(returnBookTitle)) {
                            returnBook = bk;
                            break;
                        }
                    }
                    if (returnMember != null && returnBook != null) {
                        library1.returnBook(returnBook, returnMember);
                    } else {
                        System.out.println("Member or book not found.");
                    }
                    secondaryInterface();
                    break;
                default:
                    System.out.println("Invalid input :(");
                    break;
            }
        } while (selection != 0);
    }
}