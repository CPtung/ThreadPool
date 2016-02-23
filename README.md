# ThreadPool
thread pool sample for Android

/*******************************************************************************/
/*******************************************************************************/

// 1. push task into threadpool with finishing callback.

TaskBuilder taskbuilder = new TaskBuilder(new TaskCallback() {
	@Override
	public void onTaskFinished(Object object) {
		//TODO:
	}
}) {
	@Override
	public Object ToDo() {
		//TODO:
	}
};
ThreadPoolManager.getInstance().executeTaskWithCallback(taskbuilder);

/*******************************************************************************/

// 2. push task into threadpool with regular Rannable format.
ThreadPoolManager.getInstance().executeTask(new Runnable() {
	@Override
	public void run() {
		//TODO:
	}
});

/*******************************************************************************/
/*******************************************************************************/
