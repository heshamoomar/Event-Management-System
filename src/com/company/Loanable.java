package com.company;
import java.time.LocalDate;

public interface Loanable {
    // Implement Loanable interface methods
    void loanOut(Book book, Member member);

    void returnLoan(Book book, Member member);

    // Method to loan a book to a member
    void loanBook(Member member, Book book, LocalDate dueDate);

    // Method to return a book
    void returnBook(Member member, Book book);

    // Method to check if a book is overdue
    boolean isOverdue(Book book);
}