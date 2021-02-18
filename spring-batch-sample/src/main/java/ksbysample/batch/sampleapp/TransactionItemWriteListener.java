package ksbysample.batch.sampleapp;

import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class TransactionItemWriteListener implements ItemWriteListener<Transaction> {

    @Override
    public void beforeWrite(List<? extends Transaction> items) {
        items.forEach(item -> System.out.println("★★★" + item.getTransactionAmount()));
    }

    @Override
    public void afterWrite(List<? extends Transaction> items) {

    }

    @Override
    public void onWriteError(Exception exception, List<? extends Transaction> items) {

    }

}
