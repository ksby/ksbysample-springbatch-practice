package ksbysample.batch.helloworldsyscmd;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.SimpleSystemProcessExitCodeMapper;
import org.springframework.batch.core.step.tasklet.SystemCommandTasklet;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@EnableBatchProcessing
@Configuration
public class SystemCommandTaskletConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("systemCommandJob")
                .start(systemCommandStep())
                .build();
    }

    @Bean
    public Step systemCommandStep() {
        return this.stepBuilderFactory.get("systemCommandStep")
                .tasklet(systemCommandTasklet())
                .build();
    }

    @Bean
    public Tasklet systemCommandTasklet() {
        SystemCommandTasklet tasklet = new SystemCommandTasklet();
        tasklet.setCommand("cmd /C echo > D:\\tmp\\sample.txt");
        tasklet.setTimeout(5000);
        tasklet.setInterruptOnCancel(true);

        tasklet.setWorkingDirectory("D:\\Java");

        tasklet.setSystemProcessExitCodeMapper(dirCodeMapper());
        tasklet.setTerminationCheckInterval(1000);
        tasklet.setTaskExecutor(new SimpleAsyncTaskExecutor());
        tasklet.setEnvironmentParams(new String[]{
                "BATCH_HOME=D:\\tmp"
        });

        return tasklet;
    }

    @Bean
    public SimpleSystemProcessExitCodeMapper dirCodeMapper() {
        return new SimpleSystemProcessExitCodeMapper();
    }

}
