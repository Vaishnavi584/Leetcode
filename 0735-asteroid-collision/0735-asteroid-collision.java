class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Process collisions only when asteroid is moving left and top of stack is moving right
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (Math.abs(asteroid) > top) {
                    stack.pop(); // right-moving asteroid explodes
                } else if (Math.abs(asteroid) == top) {
                    stack.pop(); // both explode
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // current asteroid explodes
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
