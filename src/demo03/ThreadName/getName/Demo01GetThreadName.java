package demo03.ThreadName.getName;

/**
 * 线程的名称：
 *      主线程：main
 *      新线程：Thread-0、Thread-1、Thread2......
 */
public class Demo01GetThreadName {
    public static void main(String[] args) {
        // 创建Thread类的子类对象
        MyThread mt = new MyThread();
        // 调用start方法，开启新线程，执行run方法
        mt.start();

        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

        System.out.println(Thread.currentThread().getName());  // 获取主线程的名字
    }
}
