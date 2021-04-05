package demo03.ThreadName.setName;

public class Demo01SetThreadName {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        // 设置线程名称方式一
        mt.setName("小强");
        mt.start();

        // 设置线程名称方式二
        new MyThread("旺财").start();
    }
}
