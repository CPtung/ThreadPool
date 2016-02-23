package com.libs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by justin on 2016/2/16.
 */
public class TaskTrackingThreadPool extends ThreadPoolExecutor {

    private AtomicInteger mTaskCount = new AtomicInteger(0);

    public TaskTrackingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        mTaskCount.getAndIncrement();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        mTaskCount.getAndDecrement();
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
            return super.newTaskFor(callable);
    }

    public int getNbrOfTasks() {
        return mTaskCount.get();
    }
}