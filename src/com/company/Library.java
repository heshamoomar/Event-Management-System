package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private
    String libraryName;
    String libraryDescription;
    String libraryDate;
    int duration;
    ArrayList <Person> People;
    ArrayList<Book> booksList;
    private ArrayList<Loan> loans;

    public Library() {
    }

    public Library(String libraryName, String libraryDescription, String libraryDate,
                   int duration) {
        this.libraryName = libraryName;
        this.libraryDescription = libraryDescription;
        this.libraryDate = libraryDate;
        this.duration = duration;
        People = new ArrayList <Person>();
        booksList = new ArrayList <>(); // Initialize books list
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", libraryDescription='" + libraryDescription + '\'' +
                ", libraryDate='" + libraryDate + '\'' +
                ", duration=" + duration +
                ", People=" + People +
                '}';
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        booksList.add(book);
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    // Method to loan out a book to a member
    public void loanBook(Book book, Member member, LocalDate dueDate) {
        if (book.isAvailable()) {
            Loan loan = new Loan(loans.size() + 1, dueDate, book, member);
            loans.add(loan);
            member.addLoan(loan);
            book.setAvailable(false);
            System.out.println("Book " + book.getTitle() + " has been loaned to " + member.getFullName());
        } else {
            System.out.println("Sorry, the book is not available for loan.");
        }
    }

    // Method to return a book loaned by a member
    public void returnBook(Book book, Member member) {
        for (Loan loan : loans) {
            if (!loan.isReturned() && loan.getBook() == book && loan.getMember() == member) {
                loan.returnBook();
                book.setAvailable(true);
                member.removeLoan(loan);
                loans.remove(loan);
                return;
            }
        }
        System.out.println("No active loan found for the specified book and member.");
    }

    // Method to check if a book is currently on loan
    public boolean isBookOnLoan(Book book) {
        for (Loan loan : loans) {
            if (!loan.isReturned() && loan.getBook() == book) {
                return true;
            }
        }
        return false;
    }


    public void displayBooks() {
        System.out.println("Books added to the library:");
        for (Book book : booksList) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Publication Date: " + book.getPublicationDate());
            System.out.println(); // Add a blank line for better readability
        }
    }


    public void displayAll() {  //  type casting
        for (int i = 0; i< People.size(); i++) {
            if (People.get(i) instanceof Member)
                ((Member) People.get(i)).displayAll();
            if (People.get(i) instanceof Librarian)
                ((Librarian) People.get(i)).displayAll();
        }
    }

    public void addPerson(Person p) {
        People.add(p);
    }

    public void removePerson(int pIndex) {
        People.remove(pIndex);
    }

    public int getNumberOfPersons() {
        return People.size();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryDescription() {
        return libraryDescription;
    }

    public void setLibraryDescription(String libraryDescription) {
        this.libraryDescription = libraryDescription;
    }

    public String getLibraryDate() {
        return libraryDate;
    }

    public void setLibraryDate(String libraryDate) {
        this.libraryDate = libraryDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Person> getPeople() {
        return People;
    }

    public void setPeople(ArrayList<Person> people) {
        People = people;
    }
}
