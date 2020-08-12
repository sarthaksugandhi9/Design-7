// Time complexity - O(n)
// Space complexity - O(n)

class SnakeGame {

    int[] snakeHead;
    int height; int width;
    LinkedList<int[]> snake;
    LinkedList<int[]> foodList;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snake = new LinkedList<>();
        foodList = new LinkedList<>(Arrays.asList(food));
        snakeHead = new int[]{0,0};
        snake.add(snakeHead);
    }
    
    public int move(String direction) {
        // update snake movement
        if(direction.equals("U")) snakeHead[0] -= 1;
        if(direction.equals("D")) snakeHead[0] += 1;
        if(direction.equals("L")) snakeHead[1] -= 1;
        if(direction.equals("R")) snakeHead[1] += 1;
        
        // check if snake hits boundary
        if(snakeHead[0] < 0 || snakeHead[0] >= height || snakeHead[1] < 0 || snakeHead[1] >= width)
            return -1;
        for(int i = 1; i < snake.size(); i++){
            int[] tmp = snake.get(i);
            if(tmp[0] == snakeHead[0] && tmp[1] == snakeHead[1])
                return -1;
        }
        
        // if food
        if(!foodList.isEmpty()){
            int[] appearedFood = foodList.get(0);
            if(appearedFood[0] == snakeHead[0] && appearedFood[1] == snakeHead[1]){
                snake.add(appearedFood);
                foodList.remove(appearedFood);
                return snake.size() - 1;
            }
        }
        
        // normal move
        snake.remove(); // deletes head of linked list
        snake.add(new int[]{snakeHead[0],snakeHead[1]});
        return snake.size() - 1;
    }
} 
