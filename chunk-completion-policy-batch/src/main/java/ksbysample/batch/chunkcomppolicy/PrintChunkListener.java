package ksbysample.batch.chunkcomppolicy;


import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class PrintChunkListener implements ChunkListener {

    @Override
    public void beforeChunk(ChunkContext context) {
        System.out.println("●●●");
    }

    @Override
    public void afterChunk(ChunkContext context) {
        System.out.println("★★★");
    }

    @Override
    public void afterChunkError(ChunkContext context) {
    }

}
