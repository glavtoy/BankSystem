import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {

    private User user;
    private int amount;
    private long timeStamp;
    private TransactionType transactionType;

    public Transaction(User user, int amount, TransactionType transactionType) {
        this.user = user;
        this.amount = amount;
        this.timeStamp = new Date().getTime();
    }

}
