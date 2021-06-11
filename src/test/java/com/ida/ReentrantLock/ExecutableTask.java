package com.ida.ReentrantLock;

import java.util.concurrent.Callable;

public class ExecutableTask implements Callable<String> {

    private String name;
    @Override
    public String call() throws Exception {
        return null;
    }

    public ExecutableTask(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
