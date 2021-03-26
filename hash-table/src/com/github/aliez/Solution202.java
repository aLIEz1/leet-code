package com.github.aliez;

import java.util.HashSet;

/**
 * 202
 *
 * @author lm
 * @date 2021/3/23 17:53
 */
public class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set1 = new HashSet<>();
        while (true) {
            int sum=getSum(n);
            if (sum==1){
                return true;
            }
            if (set1.contains(sum)){
                return false;
            }else {
                set1.add(sum);
            }
            n=sum;
        }

    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
