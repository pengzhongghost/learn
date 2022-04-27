package leetcode题目.java基础;

import java.util.Arrays;
import java.util.LinkedList;

public class 动物收容所 {
    /**
     * https://leetcode-cn.com/problems/animal-shelter-lcci/
     * 动物收容所
     * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，
     * 收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗
     * （同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。
     * 请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。
     * 允许使用Java内置的LinkedList数据结构。
     * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
     * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
     * <p>
     * 示例1:
     * 输入：
     * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
     * [[], [[0, 0]], [[1, 0]], [], [], []]
     * 输出：
     * [null,null,null,[0,0],[-1,-1],[1,0]]
     */
    public static void main(String[] args) {
        AnimalShelf animal = new AnimalShelf();
        animal.enqueue(new int[]{0, 0});
        animal.enqueue(new int[]{1, 0});
        System.out.println(Arrays.toString(animal.dequeueCat()));
        System.out.println(Arrays.toString(animal.dequeueDog()));
        System.out.println(Arrays.toString(animal.dequeueAny()));
    }

    static class AnimalShelf {

        LinkedList<int[]> list;
        LinkedList<int[]> cat;
        LinkedList<int[]> dog;

        public AnimalShelf() {
            list = new LinkedList<>();
            cat = new LinkedList<>();
            dog = new LinkedList<>();

        }

        public void enqueue(int[] animal) {
            list.offer(animal);
            //todo linkedlist的push是在队列头添加元素，而offer是在队列尾添加元素
            //list.push();
            if (animal[1] == 0) {
                cat.offer(animal);
            } else {
                dog.offer(animal);
            }
        }

        public int[] dequeueAny() {
            if (list.isEmpty()) {
                return new int[]{-1, -1};
            }
            //todo pop==removeFirst
            int[] pop = list.poll();
            if (pop[1] == 0) {
                cat.pop();
            } else {
                dog.pop();
            }
            return pop;
        }

        public int[] dequeueDog() {
            if (dog.isEmpty()) {
                return new int[]{-1, -1};
            }
            int[] pop = dog.pop();
            list.remove(pop);
            return pop;
        }

        public int[] dequeueCat() {
            if (cat.isEmpty()) {
                return new int[]{-1, -1};
            }
            int[] pop = cat.pop();
            list.remove(pop);
            return pop;
        }

    }
}
