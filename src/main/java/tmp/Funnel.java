package tmp;


import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * 漏斗算法简单实现
 */
@Data
public class Funnel {

    //漏斗容量
    private long capacity;

    //漏斗流出速率
    private int speed;

    //漏斗剩余容量
    private long leftCapacity;

    //上次流水时间
    private long lastConsumerTime;


    public Funnel(int capacity, int speed) {
        this.capacity = capacity;
        this.speed = speed;
        this.leftCapacity = capacity;
        this.lastConsumerTime = System.currentTimeMillis() / 1000;
    }

    //腾出空间
    public void makeSpace() {

        long now = System.currentTimeMillis() / 1000;
        long delay = now - getLastConsumerTime();
        long space = delay * speed;
        //腾出空间不足
        if (space < 1) {
            return;
        }
        lastConsumerTime = System.currentTimeMillis() / 1000;
        leftCapacity = leftCapacity + space;
        if (leftCapacity > capacity) leftCapacity = capacity;
    }

    //装水(类似请求)
    public boolean watering(int water) {
        makeSpace();
        if (leftCapacity > water) {
            leftCapacity = leftCapacity - water;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        Funnel funnel = new Funnel(10, 1);

        for (int i = 0; i < 10; i++) {

            boolean success = funnel.watering(4);
            if (success) {
                System.out.println("accept" + System.currentTimeMillis() / 1000);
            } else {
                System.out.println("限流");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
