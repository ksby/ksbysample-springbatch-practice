package ksbysample.batch.sampleapp;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Statement {

    private final Customer customer;

    private List<Account> accounts = new ArrayList<>();

    public Statement(Customer customer) {
        this.customer = customer;
    }

    public Statement(Customer customer, List<Account> accounts) {
        this.customer = customer;
        this.accounts.addAll(accounts);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts.clear();
        this.accounts.addAll(accounts);
    }

}
