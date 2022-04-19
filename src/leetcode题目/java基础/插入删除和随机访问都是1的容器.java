package leetcode题目.java基础;

import java.util.*;

public class 插入删除和随机访问都是1的容器 {
    /**
     * https://leetcode-cn.com/problems/FortPu/
     * 插入、删除和随机访问都是 O(1) 的容器
     * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：
     *
     * insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
     * remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
     * getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
     */
    static class RandomizedSet {

        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            int index = list.size();
            list.add(val);
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Integer index = map.get(val);
            Integer last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
