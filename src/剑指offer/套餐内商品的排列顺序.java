package 剑指offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 套餐内商品的排列顺序 {

    public static void main(String[] args) {
        String[] res = goodsOrder("aab");
        System.out.println(Arrays.toString(res));
    }

    static Set<String> set = new HashSet();
    public static String[] goodsOrder(String goods) {
        dfs(goods, "", new boolean[goods.length()]);
        return set.toArray(new String[set.size()]);
    }

    private static void dfs(String goods, String str, boolean[] isVisited) {
        if(str.length() == goods.length()) {
            set.add(str);
            return;
        }
        //aab
        for(int i = 0; i <goods.length();i++) {
            //(i > 0 && !isVisited[i - 1] && goods.charAt(i - 1) == goods.charAt(i))
            //譬如aab：第一个a记为a1，第二个a记为a2
            // a2 为第一个，则前面一个a1是false没有访问道的，所以可以去重a2a1b，之前已经有a1a2b
            if(isVisited[i] || (i > 0 && !isVisited[i - 1] && goods.charAt(i - 1) == goods.charAt(i))) {
                continue;
            }
            isVisited[i] = true;
            dfs(goods, str + goods.charAt(i), isVisited);
            isVisited[i] = false;
        }
    }


}
