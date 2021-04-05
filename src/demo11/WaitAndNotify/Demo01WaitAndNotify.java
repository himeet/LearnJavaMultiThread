package demo11.WaitAndNotify;

/**
 * 等待唤醒案例：线程之间的通信
 *      创建一个顾客线程（消费者）：告知老板要的包子的种类和数量，调用wait()方法，放弃cpu的执行，进入到waiting状态（无限等待状态）
 *      创建一个老板线程（生产者）：花了5s做包子，做好包子后，调用notify()方法，唤醒顾客吃包子
 *
 *      注意：
 *          1.顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
 *          2.同步使用的锁对象必须保证是唯一的
 *          3.只有锁对象才能调用wait方法和notify方法
 *
 *      Object类中方法：
 *      void wait()
 *          在其他线程调用此对象的notify()方法或notifyAll()方法前，导致当前线程等待。
 *      void notify()
 *          唤醒在此对象监视器上等待的单个线程。会继续执行wait()方法之后的代码
 */
public class Demo01WaitAndNotify {
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
                        System.out.println("告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                            // 唤醒之后执行的代码
                            System.out.println("包子已经做好了，开吃\n-------------------------");
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
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
