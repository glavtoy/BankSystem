import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        // NEED TO WORK API

        Economy.registerEconomy();

        // CODE EXAMPLE

        Bank bank1 = new Bank("super bank");

        User user1 = new User("alex", bank1);
        bank1.depositBalance(user1, 500);
        System.out.println(user1.getBalance());
        User user2 = new User("john", bank1);
        bank1.depositBalance(user2, 1000);
        System.out.println(user2.getBalance());

        // OUTPUT ADDITIONAL INFO ABOUT USERS ( toString() method )

        System.out.println(user1);
        System.out.println(user2);
    }
}