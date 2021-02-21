package ksbysample.batch.helloworld;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class Parametervalidator implements JobParametersValidator {

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String fileName = parameters.getString("fileName");
        if (StringUtils.isEmpty(fileName)) {
            throw new JobParametersInvalidException("fileName parameter is missing");
        } else if (!StringUtils.endsWith(fileName, "csv")) {
            throw new JobParametersInvalidException(
                    "fileName parameter does not use the csv file extension");
        }
    }

}
