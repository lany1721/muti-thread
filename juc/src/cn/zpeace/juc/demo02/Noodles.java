package cn.zpeace.juc.demo02;

/**
 * 资源类，面条
 * @author zpeace
 * @date 2021/3/2
 */
public class Noodles {

    private Integer num = 0;

    //做面
    public synchronized void makeNoodles(){
        while (num != 0) {
            // 有面，暂时不需要做
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"做好了一份面，当前有"+num+"份面");
        this.notifyAll();
    }

    //吃面
    public synchronized void eatNoodles() {
        //如果面的数量为0，则等待厨师做完面再吃面
        while (num == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        num--;
        System.out.println(Thread.currentThread().getName()+"吃了一份面，当前有"+num+"份面");
        //吃完则唤醒厨师来做面
        this.notifyAll();
    }
}
