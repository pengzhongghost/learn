package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 大礼包 {

    /**
     * https://leetcode.cn/problems/shopping-offers/?envType=problem-list-v2&envId=backtracking
     */

    public static void main(String[] args) {
        Arrays.stream(new int[1]).sum();
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> special01 = new ArrayList<>();
        special01.add(3);
        special01.add(0);
        special01.add(5);
        List<Integer> special02 = new ArrayList<>();
        special02.add(1);
        special02.add(2);
        special02.add(10);
        special.add(special01);
        special.add(special02);
        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);
        int result = shoppingOffers(price, special, needs);
        System.out.println(result);
    }

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        List<List<Integer>> filteredSpecial = new ArrayList<>();
        for (List<Integer> pack : special) {
            int totalCount = 0;
            int totalPrice = 0;
            int packPrice = pack.get(n);
            for (int i = 0; i < n; i++) {
                totalCount += pack.get(i);      //东西的数量
                totalPrice += pack.get(i) * price.get(i);
            }

            if (totalCount > 0 && totalPrice > packPrice) {
                filteredSpecial.add(pack);
            }
        }

        return dfs(price, filteredSpecial, needs, 0, n);
    }

    //不能用记忆化搜索，因为可能不同的礼包组合得到相同的curNeeds，但是之前的效果更差；要是用记忆化搜索得每次都遍历所有礼包保证得到一个curNeeds的最小值
    private static int dfs(List<Integer> prices, List<List<Integer>> specials, List<Integer> curNeeds, int idx, int n) {
        int minPrice = 0;
        //先假设全部直接购买
        for (int i = 0; i < n; i++) {
            minPrice += prices.get(i) * curNeeds.get(i);
        }

        if (!specials.isEmpty()) {      //可能一个礼包都没有
            List<Integer> special = specials.get(idx);
            //看看能不能买这个special
            List<Integer> nextNeeds = new ArrayList<>(n);
            int specialPrice = special.get(n);
            for (int i = 0; i < n; i++) {
                if (special.get(i) > curNeeds.get(i)) {      //超过了需要，不买
                    break;
                }
                nextNeeds.add(curNeeds.get(i) - special.get(i));
            }
            //如果数量对上，说明没有物品超出要求，可以考虑买这个礼包
            if (nextNeeds.size() == n) {
                minPrice = Math.min(minPrice, dfs(prices, specials, nextNeeds, idx, n) + specialPrice);
            }

            //如果还有可以考虑的礼包，看看不考虑当前礼包会不会有更好的效果
            if (idx + 1 < specials.size()) {
                minPrice = Math.min(minPrice, dfs(prices, specials, curNeeds, idx + 1, n));
            }
        }
        return minPrice;
    }


}
