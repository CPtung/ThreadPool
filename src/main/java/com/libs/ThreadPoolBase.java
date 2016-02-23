package com.libs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by justin on 2016/2/16.
 */
public class ThreadPoolBase {

    private final long KEEP_ALIVE_TIME = 60L;

    // Main
    private BlockingQueue<Runnable> taskQueue = null;
    protected TaskTrackingThreadPool mtaskExecutor = null;
    final int N = Runtime.getRuntime().availableProcessors();

    protected ThreadPoolBase() {
        taskQueue = new LinkedBlockingQueue<>();
        mtaskExecutor = new TaskTrackingThreadPool( N < 1 ? 1 : N
                                                  , 2 * N
                                                  , KEEP_ALIVE_TIME
                                                  , TimeUnit.SECONDS
                                                  , taskQueue);
    }

    protected void execute(Runnable task){
        if (null != task)
            mtaskExecutor.execute(task);
    }

    protected void execute(TaskBuilder task) {
        try {
            if (null != task)
                mtaskExecutor.execute(task.build());
        }catch(Exception ex) {}
    }

    protected void shutdownAllTask() {
        try {
            if (mtaskExecutor.getNbrOfTasks() == 0)
                mtaskExecutor.shutdownNow();
            else {
                mtaskExecutor.shutdown();
                int count = 0;
                while( count <= 3 ) {
                    Thread.sleep(500);
                    if (mtaskExecutor.isTerminated())
                        break;
                    count ++;
                }
            }
        }catch(Exception ex) {ex.printStackTrace();}
    }

}
