package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TopKFrequentElements {
    // Space O(n) - Time O(nlog(n))
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[][] arr = new int[map.size()][2];

        int index = 0;
        for (int n : map.keySet()) {
            arr[index][0] = n;
            arr[index][1] = map.get(n);
            index++;
        }

        Arrays.sort(arr, (a,b)-> Integer.compare(b[1] , a[1]));

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = arr[i][0];
        }

        return result;
    }
}
