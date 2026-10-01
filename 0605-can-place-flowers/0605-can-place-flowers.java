class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        while (n > 0) {
            boolean planted = false;

            for (int i = 0; i < flowerbed.length; i++) {

                if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                    flowerbed[i] = 1;
                    n--;
                    planted = true;
                    break;
                }
            }

            // No valid position found
            if (!planted) {
                return false;
            }
        }

        return true;
    }
}