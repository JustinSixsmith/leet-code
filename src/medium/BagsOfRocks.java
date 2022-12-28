package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class BagsOfRocks {
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
//        int fullBags = 0;
//
//        // Fill bags while there are additional rocks leftover
//        while (additionalRocks > 0) {
//            int leastSpace = 0;
//            int bagIndex = 0;
//            boolean vacancy = false;
//
//            for (int i = 0; i < capacity.length; i++) {
//                // Check for vacancy
//                if (capacity[i] > rocks[i]) {
//                    vacancy = true;
//                    // Find the bag with the least amount of space
//                    int space = capacity[i] - rocks[i];
//                    if (space < leastSpace || space != 0) {
//                        leastSpace = space;
//                        bagIndex = i;
//                    }
//                }
//            }
//
//            // CHeck if all the bags are full
//            if (!vacancy) {
//                // Return number of bags if all are full
//                return capacity.length;
//            }
//
//            // Fill the bag with the least amount of space
//            rocks[bagIndex]++;
//            additionalRocks--;
//        }
//        for (int i = 0; i < capacity.length; i++) {
//            if (capacity[i] == rocks[i]) {
//                fullBags++;
//            }
//        }
//        return fullBags;

        int bags = capacity.length;
        int fullBags = 0;
        ArrayList<Integer> difference = new ArrayList<>();

        for (int i = 0; i < bags; i++) {
            int space = capacity[i] - rocks[i];
            difference.add(space);
        }
        Collections.sort(difference);
        System.out.println(Arrays.toString(difference.toArray()));
        for (int i = 0; i < bags; i++) {
            int currentBag = difference.get(i);
            while (currentBag > 0 && additionalRocks > 0) {
                currentBag--;
                additionalRocks--;
            }
            if (currentBag == 0) {
                fullBags++;
            }
        }

        return fullBags;
    }

    public static void main(String[] args) {
        int[] capacity = {91, 54, 63, 99, 24, 45, 78};
        int[] rocks = {35, 32, 45, 98, 6, 1, 25};
        System.out.println(BagsOfRocks.maximumBags(capacity, rocks, 27));
    }
}


