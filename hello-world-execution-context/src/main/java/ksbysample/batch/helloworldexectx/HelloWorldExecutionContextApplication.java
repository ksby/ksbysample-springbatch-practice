package ksbysample.batch.helloworldexectx;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 実行用コマンド
// java -jar hello-world-execution-context/build/libs/hello-world-execution-context-0.0.1-SNAPSHOT.jar name="Tanaka Taro"
@SpringBootApplication
public class HelloWorldExecutionContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldExecutionContextApplication.class, args);
    }

}
