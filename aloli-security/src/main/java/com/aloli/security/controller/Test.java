package com.aloli.security.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class  ddx{

    public void aa(Boolean x){
        if(x){
            try {
                Thread.sleep(10);
                System.out.println("运行");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}



public class Test {



    public static void main(String[] args) throws InterruptedException {
        ddx a = new ddx();
        Thread.sleep(50);







 /*      TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<Thread>();
        for (int i=0; i<1; i++) {
            Thread t = new Thread(()->{
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
            }) ;
            t.start();
            ts.add(t);
        }*/
    /*     Thread add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }*/
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask( ) throws InterruptedException {
        System.out.println("运行"+Thread.currentThread().getName());
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }


}
