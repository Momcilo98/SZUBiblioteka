package UI;

import szubiblioteka.Book;
import szubiblioteka.LibraryService;
import szubiblioteka.Member;

import javax.swing.*;
import java.awt.*;

public class LibraryApp {
    private JFrame frame;
    private LibraryService libraryService;

    public LibraryApp() {
        libraryService = new LibraryService();
        initializeData();  // Pozovi metodu za inicijalizaciju podataka

        frame = new JFrame("Library Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void initializeData() {
        // Dodaj nekoliko knjiga
        libraryService.addBook(new Book("1", "1984", "George Orwell"));
        libraryService.addBook(new Book("2", "Brave New World", "Aldous Huxley"));
        libraryService.addBook(new Book("3", "To Kill a Mockingbird", "Harper Lee"));
        libraryService.addBook(new Book("4", "The Great Gatsby", "F. Scott Fitzgerald"));
        libraryService.addBook(new Book("5", "Moby Dick", "Herman Melville"));
        libraryService.addBook(new Book("6", "War and Peace", "Leo Tolstoy"));

        // Dodaj nekoliko članova
        libraryService.addMember(new Member("1", "Alice"));
        libraryService.addMember(new Member("2", "Bob"));
        libraryService.addMember(new Member("3", "Charlie"));
        libraryService.addMember(new Member("4", "David"));
        libraryService.addMember(new Member("5", "Eve"));
        libraryService.addMember(new Member("6", "Frank"));
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel bookLabel = new JLabel("Book ID:");
        bookLabel.setBounds(10, 20, 80, 25);
        panel.add(bookLabel);

        JTextField bookIdText = new JTextField(20);
        bookIdText.setBounds(100, 20, 165, 25);
        panel.add(bookIdText);

        JLabel memberLabel = new JLabel("Member ID:");
        memberLabel.setBounds(10, 50, 80, 25);
        panel.add(memberLabel);

        JTextField memberIdText = new JTextField(20);
        memberIdText.setBounds(100, 50, 165, 25);
        panel.add(memberIdText);

        JButton loanButton = new JButton("Loan Book");
        loanButton.setBounds(10, 80, 150, 25);
        panel.add(loanButton);
        loanButton.addActionListener(e -> {
            boolean success = libraryService.loanBook(bookIdText.getText(), memberIdText.getText());
            if (success) {
                JOptionPane.showMessageDialog(frame, "Book loaned successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Book is not available for loan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton returnButton = new JButton("Return Book");
        returnButton.setBounds(10, 110, 150, 25);
        panel.add(returnButton);
        returnButton.addActionListener(e -> {
            libraryService.returnBook(bookIdText.getText());
            JOptionPane.showMessageDialog(frame, "Book returned successfully!");
        });
    }

    public static void main(String[] args) {
        new LibraryApp();
    }
}
