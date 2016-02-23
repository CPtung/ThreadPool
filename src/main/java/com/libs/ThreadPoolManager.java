package com.libs;

/**
 * Created by justin on 2016/2/16.
 */
public class ThreadPoolManager extends ThreadPoolBase{

    // Singleton
    private static ThreadPoolManager mThreadPoolInstancer;
    public static ThreadPoolManager getInstance(){
        if(null == mThreadPoolInstancer){
            mThreadPoolInstancer = new ThreadPoolManager();
        }
        return mThreadPoolInstancer;
    }

    private ThreadPoolManager() {
        super();
    }

    public void shutdown() {
        this.shutdownAllTask();
    }

    public void executeTask(Runnable rTask) {
        this.execute(rTask);
    }

    public void executeTaskWithCallback(TaskBuilder rTaskBuilder) {
        this.execute(rTaskBuilder);
    }

    public void allowThreadTimeOut(boolean bIsAllow) {mtaskExecutor.allowCoreThreadTimeOut(bIsAllow);}

    public void setMaxThreadNumber(int max) {
        mtaskExecutor.setMaximumPoolSize(max);
    }

}
