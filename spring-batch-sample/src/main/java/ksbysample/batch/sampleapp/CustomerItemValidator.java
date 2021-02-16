package ksbysample.batch.sampleapp;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Component
public class CustomerItemValidator implements Validator<CustomerUpdate> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String FIND_CUSTOMER =
            "select count(*) from CUSTOMER where CUSTOMER_ID = :id";

    public CustomerItemValidator(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void validate(CustomerUpdate customer) throws ValidationException {
        Map<String, Long> paramterMap =
                Collections.singletonMap("id", customer.getCustomerId());
        Long count = jdbcTemplate.queryForObject(FIND_CUSTOMER, paramterMap, Long.class);
        if (count == 0) {
            throw new ValidationException(
                    String.format("Customer id %s was not able to be found",
                            customer.getCustomerId()));
        }
    }

}
