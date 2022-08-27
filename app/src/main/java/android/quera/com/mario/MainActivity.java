package android.quera.com.mario;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    ArrayList<TextView> cells;
    TextView up;
    TextView down;
    TextView left;
    TextView right;
    Random random;
    int snakeLocation;
    int foodLocation;
    int oldSnakeLocation = -1;
    int oldFoodLocation = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cells = new ArrayList<>();
        //_______________________________________________
        cells.add((TextView) findViewById(R.id.one_one));
        cells.add((TextView) findViewById(R.id.one_two));
        cells.add((TextView) findViewById(R.id.one_three));
        cells.add((TextView) findViewById(R.id.one_four));
        cells.add((TextView) findViewById(R.id.one_five));
        cells.add((TextView) findViewById(R.id.one_six));
        //_______________________________________________
        cells.add((TextView) findViewById(R.id.two_one));
        cells.add((TextView) findViewById(R.id.two_two));
        cells.add((TextView) findViewById(R.id.two_three));
        cells.add((TextView) findViewById(R.id.two_four));
        cells.add((TextView) findViewById(R.id.two_five));
        cells.add((TextView) findViewById(R.id.two_six));
        //_______________________________________________
        cells.add((TextView) findViewById(R.id.three_one));
        cells.add((TextView) findViewById(R.id.three_two));
        cells.add((TextView) findViewById(R.id.three_three));
        cells.add((TextView) findViewById(R.id.three_four));
        cells.add((TextView) findViewById(R.id.three_five));
        cells.add((TextView) findViewById(R.id.three_six));
        //_______________________________________________
        cells.add((TextView) findViewById(R.id.four_one));
        cells.add((TextView) findViewById(R.id.four_two));
        cells.add((TextView) findViewById(R.id.four_three));
        cells.add((TextView) findViewById(R.id.four_four));
        cells.add((TextView) findViewById(R.id.four_five));
        cells.add((TextView) findViewById(R.id.four_six));
        //_______________________________________________
        cells.add((TextView) findViewById(R.id.five_one));
        cells.add((TextView) findViewById(R.id.five_two));
        cells.add((TextView) findViewById(R.id.five_three));
        cells.add((TextView) findViewById(R.id.five_four));
        cells.add((TextView) findViewById(R.id.five_five));
        cells.add((TextView) findViewById(R.id.five_six));
        //_______________________________________________
        cells.add((TextView) findViewById(R.id.six_one));
        cells.add((TextView) findViewById(R.id.six_two));
        cells.add((TextView) findViewById(R.id.six_three));
        cells.add((TextView) findViewById(R.id.six_four));
        cells.add((TextView) findViewById(R.id.six_five));
        cells.add((TextView) findViewById(R.id.six_six));
        //_______________________________________________
        up = (TextView) findViewById(R.id.up);
        down = (TextView) findViewById(R.id.down);
        left = (TextView) findViewById(R.id.left);
        right = (TextView) findViewById(R.id.right);
        //_______________________________________________

        initializeGame();
        updateUI(snakeLocation, foodLocation);
        checkBoundaries();

        up.setOnClickListener(view -> goUp());

        down.setOnClickListener(view -> goDown());

        left.setOnClickListener(view -> goLeft());

        right.setOnClickListener(view -> goRight());

    }

    private void initializeGame() {
        snakeLocation = 14;
        foodLocation = randomizeFoodLocation(snakeLocation);
    }

    private int randomizeFoodLocation(int snake) {
        random = new Random();
        int temp = random.nextInt(36);
        if (temp == snake) {
            if (snake == 0) {
                return 1;
            } else {
                return snake - 1;
            }
        } else {
            return temp;
        }
    }

    private void checkBoundaries() {
        if (snakeLocation == 0) {
            up.setEnabled(false);
            left.setEnabled(false);
            down.setEnabled(true);
            right.setEnabled(true);
        } else if (snakeLocation == 30) {
            down.setEnabled(false);
            left.setEnabled(false);
            up.setEnabled(true);
            right.setEnabled(true);
        } else if (snakeLocation == 5) {
            right.setEnabled(false);
            up.setEnabled(false);
            down.setEnabled(true);
            left.setEnabled(true);
        } else if (snakeLocation == 35) {
            down.setEnabled(false);
            right.setEnabled(false);
            up.setEnabled(true);
            left.setEnabled(true);
        } else if (snakeLocation == 1 ||
                snakeLocation == 2 ||
                snakeLocation == 3 ||
                snakeLocation == 4) {
            up.setEnabled(false);
            down.setEnabled(true);
            left.setEnabled(true);
            right.setEnabled(true);
        } else if (snakeLocation == 6 ||
                snakeLocation == 12 ||
                snakeLocation == 18 ||
                snakeLocation == 24) {
            left.setEnabled(false);
            right.setEnabled(true);
            up.setEnabled(true);
            down.setEnabled(true);
        } else if (snakeLocation == 31 ||
                snakeLocation == 32 ||
                snakeLocation == 33 ||
                snakeLocation == 34) {
            down.setEnabled(false);
            up.setEnabled(true);
            right.setEnabled(true);
            left.setEnabled(true);
        } else if (snakeLocation == 11 ||
                snakeLocation == 17 ||
                snakeLocation == 23 ||
                snakeLocation == 29) {
            right.setEnabled(false);
            left.setEnabled(true);
            down.setEnabled(true);
            up.setEnabled(true);
        } else {
            up.setEnabled(true);
            down.setEnabled(true);
            left.setEnabled(true);
            right.setEnabled(true);
        }
    }

    private void goUp(){
        oldSnakeLocation = snakeLocation;
        snakeLocation = snakeLocation - 6;
        if(snakeLocation == foodLocation){
            oldFoodLocation = foodLocation;
            foodLocation = randomizeFoodLocation(snakeLocation);
        }
        checkBoundaries();
        updateUI(oldSnakeLocation,oldFoodLocation,snakeLocation,foodLocation);
    }

    private void goDown(){
        oldSnakeLocation = snakeLocation;
        snakeLocation = snakeLocation + 6;
        if(snakeLocation == foodLocation){
            oldFoodLocation = foodLocation;
            foodLocation = randomizeFoodLocation(snakeLocation);
        }
        checkBoundaries();
        updateUI(oldSnakeLocation,oldFoodLocation,snakeLocation,foodLocation);
    }

    private void goRight(){
        oldSnakeLocation = snakeLocation;
        snakeLocation = snakeLocation + 1;
        if(snakeLocation == foodLocation){
            oldFoodLocation = foodLocation;
            foodLocation = randomizeFoodLocation(snakeLocation);
        }
        checkBoundaries();
        updateUI(oldSnakeLocation,oldFoodLocation,snakeLocation,foodLocation);
    }

    private void goLeft(){
        oldSnakeLocation = snakeLocation;
        snakeLocation = snakeLocation - 1;
        if(snakeLocation == foodLocation){
            oldFoodLocation = foodLocation;
            foodLocation = randomizeFoodLocation(snakeLocation);
        }
        checkBoundaries();
        updateUI(oldSnakeLocation,oldFoodLocation,snakeLocation,foodLocation);
    }

    private void updateUI(int oldSnake, int oldFood, int newSnake, int newFood) {
        if(oldFood == -1){
            cells.get(oldSnake).setTextColor(getResources().getColor(R.color.default_background));
            cells.get(newSnake).setTextColor(getResources().getColor(R.color.snake_color));
            cells.get(newFood).setTextColor(getResources().getColor(R.color.food_color));
        } else {
            cells.get(oldSnake).setTextColor(getResources().getColor(R.color.default_background));
            cells.get(oldFood).setTextColor(getResources().getColor(R.color.default_background));
            cells.get(newSnake).setTextColor(getResources().getColor(R.color.snake_color));
            cells.get(newFood).setTextColor(getResources().getColor(R.color.food_color));
        }

    }

    private void updateUI(int snake, int food) {
        cells.get(snake).setTextColor(getResources().getColor(R.color.snake_color));
        cells.get(food).setTextColor(getResources().getColor(R.color.food_color));
    }
}
