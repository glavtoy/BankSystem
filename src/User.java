import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private int balance;
    private List<Transaction> transactions;
    private String id;
    private String name;
    private Bank bank;

    @Override
    public String toString() {
        return "User{" +
                "balance=" + balance +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bank=" + bank.getName() +
                '}';
    }

    public User(String name, Bank bank) throws NoSuchAlgorithmException {
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.id = HexUtil.bytesToHex(name + new Date().getTime());
        this.name = name;
        this.bank = bank;
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
