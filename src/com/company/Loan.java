package com.company;

import java.time.LocalDate;
public class Loan implements Loanable {
    private int loanId;
    private LocalDate dueDate;
    private boolean returned;
    private Book book;
    private Member member;

    // Constructor
    public Loan(int loanId, LocalDate dueDate, Book book, Member member) {
        this.loanId = loanId;
        this.dueDate = dueDate;
        this.book = book;
        this.member = member;
        this.returned = false;
    }

    // Getters and setters
    public int getLoanId() {
        return loanId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    // Method to check if the loan is overdue
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && !returned;
    }

    // Method to return the book
    public void returnBook() {
        if (!returned) {
            returned = true;
            // Perform any additional actions here, such as updating the member's record
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book has already been returned.");
        }
    }

    // Method to calculate fine for overdue books
    public double calculateFine(double fineRatePerDay) {
        if (isOverdue()) {
            long daysOverdue = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
            return daysOverdue * fineRatePerDay;
        } else {
            return 0; // No fine if not overdue
        }
    }

    // Implement Loanable interface methods
    @Override
    public void loanOut(Book book, Member member) {
        // Implement loaning out logic
    }

    @Override
    public void returnLoan(Book book, Member member) {
        // Implement returning loan logic
    }

    @Override
    public void loanBook(Member member, Book book, LocalDate dueDate) {

    }

    @Override
    public void returnBook(Member member, Book book) {

    }

    @Override
    public boolean isOverdue(Book book) {
        return false;
    }
}
