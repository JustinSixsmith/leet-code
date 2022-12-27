package medium;

class BagsOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // Take rocks away from additional rocks
        while (additionalRocks > 0) {
            // Break out of loop if all bags are full
            boolean vacancy = false;
            for (int i = 0; i < capacity.length; i++) {
                if (capacity[i] != rocks[i]) {
                    vacancy = true;
                }
                if (!vacancy) {
                    break;
                }
                additionalRocks--;
            }
        }
    }
