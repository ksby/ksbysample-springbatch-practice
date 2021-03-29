package ksbysample.batch.delimitedreader;

import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FieldSetFactory;
import org.springframework.batch.item.file.transform.LineTokenizer;

import java.util.ArrayList;
import java.util.List;

public class CustomFileLineTokenizer implements LineTokenizer {

    private String delimiter = ",";
    private String[] names = new String[]{
            "firstName",
            "middleInitial",
            "lastName",
            "addressNumber",
            "street",
            "city",
            "state",
            "zipCode"
    };

    private FieldSetFactory fieldSetFactory = new DefaultFieldSetFactory();

    @Override
    public FieldSet tokenize(String record) {
        String[] fields = record.split(delimiter);

        List<String> parsedFields = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            parsedFields.add(fields[i]);
        }

        return fieldSetFactory.create(parsedFields.toArray(new String[0]), names);
    }

}
