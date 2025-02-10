import java.util.Stack;

class TrappingRainWaterStack {
    public static int trapRainWater(int[] height) {
        Stack<Integer> stack = new Stack<>(); // Stack stores indices of bars
        int trappedWater = 0; // Total trapped water
        
        for (int i = 0; i < height.length; i++) {
            // While the current bar is taller than the stack top, process the trapped water
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop(); // Pop the lower height
                
                // If the stack becomes empty, break (no left boundary)
                if (stack.isEmpty()) break;
                
                int leftIndex = stack.peek(); // Left boundary index
                int width = i - leftIndex - 1; // Distance between left and right boundary
                int heightDiff = Math.min(height[i], height[leftIndex]) - height[bottom]; // Height of water above popped bar
                
                trappedWater += width * heightDiff; // Add trapped water
            }
            stack.push(i); // Push current index to stack
        }
        
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] elevationMap = {7, 0, 4, 2, 5, 0, 6, 4, 0, 6};
        System.out.println("Total Trapped Water: " + trapRainWater(elevationMap)); // Output: 25
    }
}

