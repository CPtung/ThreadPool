package com.libs;

/**
 * Created by justin on 2016/2/17.
 */
public abstract class TaskBuilder{

    public abstract Object ToDo();

    private TaskCallback mCallback = null;

    public TaskBuilder(TaskCallback callback) {
        mCallback = callback;
    }

    private Runnable mTask = new Runnable() {
        @Override
        public void run() {
            mCallback.onTaskFinished(ToDo());
        }
    };

    public Runnable build() {
        return mTask;
    }

}
