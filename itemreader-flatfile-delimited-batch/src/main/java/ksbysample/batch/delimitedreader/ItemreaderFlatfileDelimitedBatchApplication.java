package ksbysample.batch.delimitedreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 実行用コマンド
// java -jar itemreader-flatfile-delimited-batch/build/libs/itemreader-flatfile-delimited-batch-0.0.1-SNAPSHOT.jar customerFile=classpath:/delimited-sample.csv
@SpringBootApplication
public class ItemreaderFlatfileDelimitedBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemreaderFlatfileDelimitedBatchApplication.class, args);
    }

}
