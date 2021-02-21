package ksbysample.batch.helloworldexectx;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

public class GoodbyTasklet implements Tasklet {

    private static final String GOODBYTE_= "Goody bye, %s";

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext)
            throws Exception {
        ExecutionContext jobContext = chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext();
        String name = (String) jobContext.get("user.name");

        System.out.println(String.format(GOODBYTE_, name));
        return RepeatStatus.FINISHED;
    }

}
