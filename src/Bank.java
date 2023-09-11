import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<User> users;
    private String name;

    public Bank(String name) {
        boolean fail = false;
        for (Bank b : Economy.getInstance().getBanks()) {
            if (b.name.equalsIgnoreCase(name)) {
                System.out.println("ERROR: ECONOMY ALREADY CONTAINS BANK " + name);
                fail = true;
                break;
            }
        }
        if (!fail) {
            this.name = name;
            this.users = new ArrayList<>();
            Economy.getInstance().addBank(this);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void withdrawBalance(User user, int amount) {
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            user.addTransaction(new Transaction(user, amount, TransactionType.WITHDRAW));
            System.out.println("SUCCESS WITHDRAW USER " + user.getId() + " BALANCE IN $" + amount);
        } else {
            System.out.println("ERROR: NOT ENOUGH USER " + user.getId() + " BALANCE");
        }
    }

    public void depositBalance(User user, int amount) {
            user.setBalance(user.getBalance() + amount);
            user.addTransaction(new Transaction(user, amount, TransactionType.DEPOSIT));
            System.out.println("SUCCESS DEPOSIT USER " + user.getId() + " BALANCE IN $" + amount);
    }

    public void setBalance(User user, int amount) {
        if (amount < 0) {
            user.setBalance(amount);
            user.addTransaction(new Transaction(user, amount, TransactionType.SET));
            System.out.println("SUCCESS SET USER " + user.getId() + " BALANCE IN $" + amount);
        } else {
            System.out.println("ERROR: NOT ENOUGH USER " + user.getId() + " BALANCE");
        }
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            System.out.println("SUCCESS ADD USER " + user.getId() + " TO BANK " + name);
        }
        else System.out.println("ERROR: BANK " + getName() + " ALREADY CONTAINS USER");
    }

    public String getName() {
        return name;
    }
}
