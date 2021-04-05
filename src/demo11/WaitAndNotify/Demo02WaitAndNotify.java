package demo11.WaitAndNotify;

/**
 * 进入到TimeWaiting（计时等待）有两种方式：
 *      1.使用sleep(long m)方法，在毫秒值结束之后，线程睡醒进入到Runnable/Block状态
 *      2.使用wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来，线程睡醒进入到Runnable/Block状态
 *
 * 唤醒的方法：
 *      1.void notify() 唤醒在此对象监视器（对象锁，同步锁）上等待的单个线程。如果有多个等待线程，随机唤醒一个。
 *      2.void notifyAll() 唤醒在此对象监视器上等待的所有线程。
 */
public class Demo02WaitAndNotify {
    public static void main(String[] args) {
        // 创建锁对象，保证唯一
        Object obj = new Object();

        // 创建一个顾客线程（消费者）
        new Thread() {
            @Override
            public void run() {
                // 一直等着买包子
                while(true) {
                    // 保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("顾客1告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                            // 唤醒之后执行的代码
                            System.out.println("包子已经做好了，顾客1开吃\n-------------------------");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        // 创建一个顾客线程（消费者）
        new Thread() {
            @Override
            public void run() {
                // 一直等着买包子
                while(true) {
                    // 保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("顾客2告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                            // 唤醒之后执行的代码
                            System.out.println("包子已经做好了，顾客2开吃\n-------------------------");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        // 创建一个老板线程（生产者）
        new Thread() {
            @Override
            public void run() {
                // 一直在做包子
                while(true) {
                    // 花了5s做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("老板已经做好包子，告知顾客可以吃包子了");
                        obj.notifyAll();
                    }
                }
            }
        }.start();
    }
}
