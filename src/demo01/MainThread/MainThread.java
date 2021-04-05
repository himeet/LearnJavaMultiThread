package demo01.MainThread;


/**
 * 主线程：执行主方法(main方法)的线程
 * 单线程程序：java程序中只有一个线程。执行从main方法开始，从上到下执行。
 */
public class MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("A");
        p1.run();

        Person p2 = new Person("B");
        p2.run();
    }
}
