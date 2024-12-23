class Solution {
    public int[] asteroidCollision(int[] asteroids) {
                Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            if(asteroid > 0 || stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                }

                if(!stack.isEmpty() && Math.abs(asteroid) == stack.peek()) {
                    stack.pop();
                } else if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];

        for(int i=stack.size()-1; i>=0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
