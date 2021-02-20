package ksbysample.batch.sampleapp;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;


@Component
public class AccountItemProcessor implements ItemProcessor<Statement, Statement> {

    private final JdbcTemplate jdbcTemplate;

    public AccountItemProcessor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Statement process(Statement item) throws Exception {
        item.setAccounts(this.jdbcTemplate.query("select a.ACCOUNT_ID, " +
                        "a.BALANCE, " +
                        "a.LAST_STATEMENT_DATE, " +
                        "t.TRANSACTION_ID, " +
                        "t.DESCRIPTION, " +
                        "t.CREDIT, " +
                        "t.DEBIT, " +
                        "t.TIMESTAMP " +
                        "from ACCOUNT a left join " +
                        "TRANSACTION t on a.ACCOUNT_ID = t.ACCOUNT_ACCOUNT_ID " +
                        "where a.ACCOUNT_ID in " +
                        "(select ACCOUNT_ACCOUNT_ID " +
                        "from CUSTOMER_ACCOUNT " +
                        "where CUSTOMER_CUSTOMER_ID = ?) " +
                        "order by t.TIMESTAMP",
                new Object[]{item.getCustomer().getId()},
                new int[]{Types.NUMERIC},
                new AccountResultSetExtractor()));

        return item;
    }

}
