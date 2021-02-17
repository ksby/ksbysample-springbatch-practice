package ksbysample.batch.sampleapp;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 実行用コマンド
//  java -jar spring-batch-sample/build/libs/spring-batch-sample-0.0.1-SNAPSHOT.jar customerUpdateFile=file:D:\project-springboot\ksbysample-springbatch-practice\spring-batch-sample\src\test\resources\testdata\customer_update.csv transactionFile=file:D:\project-springboot\ksbysample-springbatch-practice\spring-batch-sample\src\test\resources\testdata\transaction.xml
@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchSampleApplication.class, args);
    }

}
