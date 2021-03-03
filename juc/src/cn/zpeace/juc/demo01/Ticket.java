package cn.zpeace.juc.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zpeace
 * @date 2021/3/2
 */
public class Ticket {

    private Integer number = 50;

    public void sales() {
        while (number > 0) {
            System.out.println("已售出" + number-- + ",剩余" + number);
        }
    }

    public synchronized void synchronizedSales() {
        while (number > 0) {
            System.out.println("已售出" + number-- + ",剩余" + number);
        }
    }

    public void lockSales() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            while (number > 0) {
                System.out.println("已售出" + number-- + ",剩余" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
