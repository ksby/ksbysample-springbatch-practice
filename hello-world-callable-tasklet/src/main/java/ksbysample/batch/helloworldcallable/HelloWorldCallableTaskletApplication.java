package ksbysample.batch.helloworldcallable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 実行用コマンド
// java -jar hello-world-callable-tasklet/build/libs/hello-world-callable-tasklet-0.0.1-SNAPSHOT.jar
@SpringBootApplication
public class HelloWorldCallableTaskletApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldCallableTaskletApplication.class, args);
    }

}
