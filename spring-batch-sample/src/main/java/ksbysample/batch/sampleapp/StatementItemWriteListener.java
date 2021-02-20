package ksbysample.batch.sampleapp;

import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class StatementItemWriteListener implements ItemWriteListener<Statement> {

    @Override
    public void beforeWrite(List<? extends Statement> items) {
        items.forEach(item -> System.out.println("★★★" + item.toString()));
    }

    @Override
    public void afterWrite(List<? extends Statement> items) {

    }

    @Override
    public void onWriteError(Exception exception, List<? extends Statement> items) {

    }

}
