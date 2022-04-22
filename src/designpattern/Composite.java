package designpattern;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
    private String accNumber;
    public Account(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return this.accNumber;
    }
    public abstract float getBalance();
}

class CheckingAccount extends Account {
    private float balance;

    public CheckingAccount(String accNumber, float balance) {
        super(accNumber);
        this.balance = balance;
    }

    @Override
    public float getBalance() {
        return this.balance;
    }
}

class SavingAccount extends Account {
    private float balance;

    public SavingAccount(String accNumber, float balance) {
        super(accNumber);
        this.balance = balance;
    }

    @Override
    public float getBalance() {
        return this.balance;
    }
}

class CombinedAccount extends Account {
    private List<Account> accountList = new ArrayList<>();

    public CombinedAccount(String accNumber) {
        super(accNumber);
    }

    @Override
    public float getBalance() {
        float total = 0;
        for (Account a : accountList) {
            total += a.getBalance();
        }
        return total;
    }

    public void addAccount(Account acc) {
        this.accountList.add(acc);
    }

    public void removeAccount(Account acc) {
        this.accountList.remove(acc);
    }
}

public class Composite {
    public static void main(String[] args) {
        CombinedAccount combinedAccount = new CombinedAccount("123");
        combinedAccount.addAccount(new CheckingAccount("333", 20.0f));
        combinedAccount.addAccount(new SavingAccount("666", 60.0f));
        System.out.println("Total: " + combinedAccount.getBalance());
    }
}
