package ksbysample.batch.helloworld;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// 実行用コマンド
// java -jar hello-world-batch/build/libs/hello-world-batch-0.0.1-SNAPSHOT.jar name="tanaka taro"
@EnableBatchProcessing
@SpringBootApplication
public class HelloWorldBatchApplication {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    public HelloWorldBatchApplication(JobBuilderFactory jobBuilderFactory,
                                      StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("basicJob")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1")
                .tasklet(helloWorldTasklet(null))
                .build();
    }

    // @StepScope が付いていないと @Value("#{jobParameters['name']}") で値を取れない
    @Bean
    @StepScope
    public Tasklet helloWorldTasklet(
            @Value("#{jobParameters['name']}") String name) {
        return (contribution, chunkContext) -> {
            System.out.println(String.format("★★★ Hello, %s", name));
            return RepeatStatus.FINISHED;
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldBatchApplication.class, args);
    }

}
