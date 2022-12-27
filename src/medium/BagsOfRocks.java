package medium;

class BagsOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int fullBags = 0;

        // Fill bags while there are additional rocks leftover
        while (additionalRocks > 0) {
            int leastSpace = 0;
            int bagIndex = 0;
            boolean vacancy = false;

            for (int i = 0; i < capacity.length; i++) {
                // Check for vacancy
                if (capacity[i] > rocks[i]) {
                    vacancy = true;
                    // Find bag with the least amount of space
                    int space = capacity[i] - rocks[i];
                    if (space < leastSpace || space != 0) {
                        leastSpace = space;
                        bagIndex = i;
                    }
                }
            }

            // Break out of loop if all bags are full
            if (!vacancy) {
                // Return all bags if all are full
                return capacity.length;
            }

            // Fill the bag with the least amount of space
            rocks[bagIndex]++;
            additionalRocks--;
        }
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] == rocks[i]) {
                fullBags++;
            }
        }
        return fullBags;
    }
}
