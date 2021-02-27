package ksbysample.batch.flatreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 実行用コマンド
// java -jar itemreader-flatfile-fixedwidth-batch/build/libs/itemreader-flatfile-fixedwidth-batch-0.0.1-SNAPSHOT.jar customerFile=classpath:/fixedwidth-sample.txt
@SpringBootApplication
public class ItemreaderFlatfileFixedwidthBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemreaderFlatfileFixedwidthBatchApplication.class, args);
    }

}
