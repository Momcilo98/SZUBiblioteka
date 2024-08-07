
package szubiblioteka;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Member member;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, Member member, LocalDate loanDate) {
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
    }

    // Getters and setters
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

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
