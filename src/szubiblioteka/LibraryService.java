package szubiblioteka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public boolean loanBook(String bookId, String memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);
        if (book != null && member != null && book.isAvailable()) {
            book.setAvailable(false);
            Loan loan = new Loan(book, member, LocalDate.now());
            member.getLoans().add(loan);
            return true;
        } else {
            return false;
        }
    }

    public void returnBook(String bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setAvailable(true);
        }
    }

    private Book findBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    private Member findMemberById(String id) {
        return members.stream().filter(member -> member.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }
}
