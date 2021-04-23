package com.github.aliez;

import java.util.HashMap;
import java.util.Map;

/**
 * 860 柠檬水找零
 *
 * @author lm
 * @date 2021/4/23 15:10
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {

        if (bills[0] > 5) {
            return false;
        }
        Map<Integer, Integer> hashmap = new HashMap<>(16);
        hashmap.put(5, 0);
        hashmap.put(10, 0);
        for (int bill : bills) {
            if (bill == 5) {
                hashmap.put(5, hashmap.get(5) + 1);
            }
            if (bill == 10) {
                if (hashmap.get(5) != 0) {
                    hashmap.put(5, hashmap.get(5) - 1);
                    hashmap.put(10, hashmap.get(10) + 1);
                } else {
                    return false;
                }

            }
            if (bill == 20) {
                if (hashmap.get(10) != 0) {
                    if (hashmap.get(5) != 0) {
                        hashmap.put(5, hashmap.get(5) - 1);
                        hashmap.put(10, hashmap.get(10) - 1);
                    } else {
                        return false;
                    }
                } else if (hashmap.get(5) >= 3) {
                    hashmap.put(5, hashmap.get(5) - 3);
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean lemonadeChange2(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                if (five != 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (ten != 0) {
                    if (five != 0) {
                        ten--;
                        five--;
                    } else {
                        return false;
                    }
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
        System.out.println(new Solution860().lemonadeChange(nums));
    }
}
