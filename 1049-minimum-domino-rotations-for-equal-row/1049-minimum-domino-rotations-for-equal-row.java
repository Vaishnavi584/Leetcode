class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0], tops, bottoms);  // try tops[0] as target
        if (result != -1 || tops[0] == bottoms[0]) {
            return result;
        } else {
            return check(bottoms[0], tops, bottoms);  // try bottoms[0] as target
        }
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotationsTop = 0;
        int rotationsBottom = 0;
        
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; // impossible for this target
            } else if (tops[i] != target) {
                rotationsTop++;  // rotate to bring target to top
            } else if (bottoms[i] != target) {
                rotationsBottom++;  // rotate to bring target to bottom
            }
        }
        
        return Math.min(rotationsTop, rotationsBottom);
    }
}
