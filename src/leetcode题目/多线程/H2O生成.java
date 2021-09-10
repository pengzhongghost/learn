package leetcode题目.多线程;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class H2O生成 {
    public static void main(String[] args) throws InterruptedException {
        H2O生成 test = new H2O生成();
        String result = test.getH2O("HOH");
        System.out.println(result);
    }

    //h执行两次后，o获得两次信号量,o需要两次信号量才能执行，此时释放两个信号量给h
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);

    public String getH2O(String str) throws InterruptedException {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String[] split = str.split("");
        for (String s : split) {
            map.put(s, map.get(s) == null ? 1 : (map.get(s) + 1));
        }
        for (int i = 0; i < map.get("H"); i++) {
            hydrogen(() -> {
                result.append("H");
            });
        }
        for (int i = 0; i < map.get("O"); i++) {
            oxygen(() -> {
                result.append("O");
            });
        }
        return result.toString();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }

}
