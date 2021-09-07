package 算法.贪心算法;

import java.util.*;

/**
 * 贪心算法：
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台
        Map<String, Set<String>> broadCasts = new HashMap<>();
        Set<String> set01 = new HashSet<>();
        set01.add("北京");
        set01.add("上海");
        set01.add("天津");
        Set<String> set02 = new HashSet<>();
        set02.add("广州");
        set02.add("北京");
        set02.add("深圳");
        Set<String> set03 = new HashSet<>();
        set03.add("成都");
        set03.add("上海");
        set03.add("杭州");
        Set<String> set04 = new HashSet<>();
        set04.add("上海");
        set04.add("天津");
        Set<String> set05 = new HashSet<>();
        set05.add("杭州");
        set05.add("大连");
        broadCasts.put("K1", set01);
        broadCasts.put("K2", set02);
        broadCasts.put("K3", set03);
        broadCasts.put("K4", set04);
        broadCasts.put("K5", set05);
        //所有的地区
        Set<String> allAreas = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : broadCasts.entrySet()) {
            allAreas.addAll(entry.getValue());
        }
        //list用于存放选择的电台集合
        List<String> selectList = new ArrayList<>();
        //定义一个临时的集合,用于存放遍历过程中电台覆盖的地区和当前还没有覆盖的地区的交集
        Set<String> tempSet;
        //最大覆盖地区的数量和key
        int maxSize;
        String maxKey;
        while (!allAreas.isEmpty()) {
            maxSize = 0;
            maxKey = null;
            for (Map.Entry<String, Set<String>> entry : broadCasts.entrySet()) {
                String key = entry.getKey();
                tempSet = entry.getValue();
                //取交集然后重新赋值给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区的数量，比maxkey指向的集合地区还要多
                if (!tempSet.isEmpty() && tempSet.size() > maxSize) {
                    maxKey = key;
                    maxSize = tempSet.size();
                }
            }
            if (maxSize != 0) {
                selectList.add(maxKey);
                //将makkey包含的广播电台覆盖的地区从allAreas去掉
                allAreas.removeAll(broadCasts.get(maxKey));
                broadCasts.remove(maxKey);
            }
        }
        System.out.println(selectList);
    }

}
