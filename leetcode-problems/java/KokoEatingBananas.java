package problems;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            if (pile > maxPile) {
                maxPile = pile;
            }
        }
        int l = 1, r = maxPile;

        while (l < r){
            int mid = l + (r - l)/2;
            int hours = 0;
            for (int pile : piles){
                hours += (pile - 1) / mid + 1;
            }
            if (hours <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
