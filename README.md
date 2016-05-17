# ThreadPool Sample (Android)

#### - push task into threadpool with Runnable.
```javascript
ThreadPoolManager.getInstance().executeTask(new Runnable() {  
@Override  
public void run() {  
//TODO:  
}  
});
```


#### - push task into threadpool with Callback.


```javascript
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
```

