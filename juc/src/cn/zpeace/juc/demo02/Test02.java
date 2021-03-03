package cn.zpeace.juc.demo02;

/**
 * @author zpeace
 * @date 2021/3/2
 */
public class Test02 {
    public static void main(String[] args) {
        Noodles noodles = new Noodles();
        new Thread(() -> { for (int i = 0; i < 10; i++) noodles.makeNoodles();},"厨师A").start();
        new Thread(() -> { for (int i = 0; i < 10; i++) noodles.eatNoodles();},"食客A").start();
        new Thread(() -> { for (int i = 0; i < 10; i++) noodles.makeNoodles();},"厨师B").start();
        new Thread(() -> { for (int i = 0; i < 10; i++) noodles.eatNoodles();},"食客B").start();
    }
}
