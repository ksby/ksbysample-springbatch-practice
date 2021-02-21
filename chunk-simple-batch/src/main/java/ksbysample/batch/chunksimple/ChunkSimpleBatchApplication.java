package ksbysample.batch.chunksimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 実行用コマンド
// java -jar chunk-simple-batch/build/libs/chunk-simple-batch-0.0.1-SNAPSHOT.jar inputFile=file:D:\project-springboot\ksbysample-springbatch-practice\chunk-simple-batch\src\test\resources\sample.txt outputFile=file:D:\project-springboot\ksbysample-springbatch-practice\chunk-simple-batch\src\test\resources\output.txt
@SpringBootApplication
public class ChunkSimpleBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChunkSimpleBatchApplication.class, args);
    }

}
