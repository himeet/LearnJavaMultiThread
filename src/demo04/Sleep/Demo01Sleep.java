package demo04.Sleep;

/**
 * public static void sleep(long millis)：使当前正在执行的线程以指定的毫秒数暂停
 * 毫秒结束后，线程继续执行
 */
public class Demo01Sleep {
    public static void main(String[] args) throws InterruptedException {
        // 使用sleep方法模拟秒表
        for (int i = 1; i <= 60; i++) {
            System.out.println(i);
            // 使用Thread类的sleep方法让程序睡眠1秒钟
            Thread.sleep(1000);
        }
    }
}
