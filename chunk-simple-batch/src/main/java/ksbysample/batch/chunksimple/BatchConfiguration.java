package ksbysample.batch.chunksimple;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.batch.api.chunk.listener.ChunkListener;
import java.nio.charset.StandardCharsets;

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
                .<String, String>chunk(10)
                .reader(itemReader(null))
                .writer(itemWriter(null))
                .listener(new FlatFileChunkListener())
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<String> itemReader(
            @Value("#{jobParameters['inputFile']}") Resource inputFile) {
        return new FlatFileItemReaderBuilder<String>()
                .name("itemReader")
                .resource(inputFile)
                .lineMapper(new PassThroughLineMapper())
                // .comments(new String[]{}) を記述しないと、デフォルトでは # がコメント行と判断されて read されない
                .comments(new String[]{})
                // 文字コードは明示しないと Windows では文字化けする
                .encoding(StandardCharsets.UTF_8.name())
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemWriter<String> itemWriter(
            @Value("#{jobParameters['outputFile']}") Resource outputFile) {
        return new FlatFileItemWriterBuilder<String>()
                .name("itemWriter")
                .resource(outputFile)
                .lineAggregator(new PassThroughLineAggregator<>())
                .encoding(StandardCharsets.UTF_8.name())
                .build();
    }

}
