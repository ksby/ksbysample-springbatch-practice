package ksbysample.batch.sampleapp;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
public class Account {

    private final long id;

    private final BigDecimal balance;

    private final Date lastStatementDate;

    private final List<Transaction> transactions = new ArrayList<>();

    public Account(long id, BigDecimal balance, Date lastStatementDate) {
        this.id = id;
        this.balance = balance != null ? balance : new BigDecimal("0");
        this.lastStatementDate = lastStatementDate;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Date getLastStatementDate() {
        return lastStatementDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

}
