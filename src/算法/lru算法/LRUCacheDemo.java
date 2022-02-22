package 算法.lru算法;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCacheDemo(int capacity) {
        /**
         * Params:
         * initialCapacity – the initial capacity 初始容量
         * loadFactor – the load factor 负载因子
         * accessOrder  true for access-order, 按照访问顺序排序，新放入和新访问的数据会放到队列头
         *              false for insertion-order 按照插入顺序排序
         */
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo<Object, Object> lruCacheDemo = new LRUCacheDemo<>(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        System.out.println(lruCacheDemo.get(4));
        System.out.println(lruCacheDemo.keySet());
    }

}
