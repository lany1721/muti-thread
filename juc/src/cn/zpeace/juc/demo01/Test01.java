package cn.zpeace.juc.demo01;


/**
 * @author zpeace
 * @date 2021/3/2
 */
public class Test01 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> ticket.sales()).start();
        new Thread(() -> ticket.sales()).start();
//        new Thread(() -> { ticket.synchronizedSales(); }).start();
//        new Thread(() -> { ticket.synchronizedSales(); }).start();
//        new Thread(() -> { ticket.lockSales(); }).start();
//        new Thread(() -> { ticket.lockSales(); }).start();

    }
}
