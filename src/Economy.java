import java.util.ArrayList;
import java.util.List;

public class Economy {

    private static Economy instance;

    private static List<Bank> banks = new ArrayList<>();

    public static Economy getInstance() {
        return instance;
    }

    public void addBank(Bank bank) {
        if (!banks.contains(bank)) {
            banks.add(bank);
            System.out.println("ECONOMY SUCCESS ADD BANK " + bank.getName());
        } else {
            System.out.println("ERROR: ECONOMY NOT CONTAINS BANK " + bank.getName());
        }
    }

    public void removeBank(Bank bank) {
        if (banks.contains(bank)) {
            banks.remove(bank);
            System.out.println("ECONOMY SUCCESS REMOVE BANK " + bank.getName());
        } else {
            System.out.println("ERROR: ECONOMY NOT CONTAINS BANK " + bank.getName());
        }
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public static void registerEconomy() {
        instance = new Economy();
    }
}
