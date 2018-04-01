package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/chalkboard-xor-game/description/
 * <p>
 * We are given non-negative integers nums[i] which are written on a chalkboard.  Alice and Bob take turns erasing exactly one number from the chalkboard, with Alice starting first.  If erasing a number causes the bitwise XOR of all the elements of the chalkboard to become 0, then that player loses.  (Also, we'll say the bitwise XOR of one element is that element itself, and the bitwise XOR of no elements is 0.)
 * <p>
 * Also, if any player starts their turn with the bitwise XOR of all the elements of the chalkboard equal to 0, then that player wins.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * <pre>
 * Example:
 * Input: nums = [1, 1, 2]
 * Output: false
 * Explanation:
 * Alice has two choices: erase 1 or erase 2.
 * If she erases 1, the nums array becomes [1, 2]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 2 = 3. Now Bob can remove any element he wants, because Alice will be the one to erase the last element and she will lose.
 * If Alice erases 2 first, now nums becomes [1, 1]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 1 = 0. Alice will lose.
 * </pre>
 * Notes:
 * <ul>
 * <li>1 <= N <= 1000. </li>
 * <li>0 <= nums[i] <= 2^16.</li>
 * </ul>
 * Created by cyanflxy on 2018/4/1.
 */

public class _810_Chalkboard_XOR_Game {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _810_Chalkboard_XOR_Game object = new _810_Chalkboard_XOR_Game();
//        System.out.println(object.xorGame(new int[]{1, 2, 3}));
        System.out.println(object.xorGame(new int[]{1, 2, 1}));

    }

    public boolean xorGame(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == 0;
        }

        int allXor = 0;
        for (int i : nums) {
            allXor ^= i;
        }

        if (allXor == 0) {
            return true;
        }

        boolean isA = true;
        boolean[] used = new boolean[n];

        w:
        while (true) {
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    if ((allXor ^ nums[i]) != 0) {
                        allXor ^= nums[i];
                        used[i] = true;
                        isA = !isA;
                        continue w;
                    }
                }
            }

            return !isA;
        }

    }
}
