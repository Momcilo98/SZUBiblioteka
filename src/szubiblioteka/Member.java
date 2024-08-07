package szubiblioteka;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String id;
    private String name;
    private List<Loan> loans;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.loans = new ArrayList<>();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
