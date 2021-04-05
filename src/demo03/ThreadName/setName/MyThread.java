package demo03.ThreadName.setName;

/**
 * 设置线程的名称：（了解）
 *      1.使用Thread类中的setName方法
 *          void setName(String name)  改变线程名称，使之与参数name相同
 *      2.创建一个带参的构造方法，参数传递线程的名称；调用父类的带参构造方法，把线程名称传递给父类，让父类（Thread）给子线程起一个名字
 *          Thread(String name) 带参构造
 */
public class MyThread extends Thread{

    public MyThread () {}

    public MyThread (String name) {
        super(name);
    }

    @Override
    public void run() {
        // 获取线程的名称
        System.out.println(Thread.currentThread().getName());
    }
}
