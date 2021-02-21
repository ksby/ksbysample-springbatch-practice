package ksbysample.batch.chunkcomppolicy;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.policy.CompositeCompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.batch.repeat.policy.TimeoutTerminationPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1")
                .<String, String>chunk(completionPolicy())
                .reader(itemReader())
                .writer(itemWriter())
                .listener(new PrintChunkListener())
                .build();
    }

    @Bean
    public ListItemReader<String> itemReader() {
        List<String> items = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            items.add(UUID.randomUUID().toString());
        }
        return new ListItemReader<>(items);
    }

    @Bean
    public ItemWriter<String> itemWriter() {
        return items -> {
            for (String item : items) {
                // System.out.println(">> current item = " + item);
            }
        };
    }

    @Bean
    public CompletionPolicy completionPolicy() {
        CompositeCompletionPolicy policy = new CompositeCompletionPolicy();
        policy.setPolicies(
                new CompletionPolicy[]{
                        new TimeoutTerminationPolicy(1000),
                        new SimpleCompletionPolicy(10000)});
        return policy;
    }

}
