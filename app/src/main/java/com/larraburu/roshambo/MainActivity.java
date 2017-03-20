package com.larraburu.roshambo;

/**
 * Jonathan Larraburu
 * JLarrab1@my.smccd.edu
 * CIS 135 OL
 * MainActivity.java
 * Main Activity for the updated Roshambo game.  Lizard-Spock mode is now a menu option.
 * Midterm
 * March 15,2017
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private boolean gameMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Paper = (Button) findViewById(R.id.PaperButton);
        Paper.setOnClickListener(this);

        Button Rock = (Button) findViewById(R.id.RockButton);
        Rock.setOnClickListener(this);

        Button Scissors = (Button) findViewById(R.id.ScissorsButton);
        Scissors.setOnClickListener(this);

        Button Lizard = (Button) findViewById(R.id.LizardButton);
        Lizard.setOnClickListener(this);

        Button Spock = (Button) findViewById(R.id.SpockButton);
        Spock.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_roshambo, menu);
        return true;
    }

    public void onClick(View v) {

        TextView responseText = (TextView) findViewById(R.id.responseText);

        switch (v.getId()) {
            case R.id.PaperButton:
                responseText.setText(play("paper"));
                break;
            case R.id.RockButton:
                responseText.setText(play("rock"));
                break;
            case R.id.ScissorsButton:
                responseText.setText(play("scissors"));
                break;
            case R.id.LizardButton:
                responseText.setText(play("lizard"));
                break;
            case R.id.SpockButton:
                responseText.setText(play("spock"));
                break;
        }
    }

    public String play(String userChoice) {
        // Creates a random number
        Random rand = new Random();
        if(gameMode) {
            int randomNumber = rand.nextInt(3) + 1;

            String opponent = "";
            switch (randomNumber) {
                case 1:
                    opponent = "paper";
                    break;
                case 2:
                    opponent = "rock";
                    break;
                case 3:
                    opponent = "scissors";
                    break;
            }

            if (userChoice == opponent) {
                return userChoice + " vs. " + opponent + ".  You tie!";
            } else if ((userChoice == "rock") && (opponent == "scissors") ||
                    (userChoice == "scissors") && (opponent == "paper") ||
                    (userChoice == "paper") && (opponent == "rock")) {
                return userChoice + " beats " + opponent + ".  You win!";
            } else {
                return opponent + " beats " + userChoice + ".  You lose!";
            }
        } else {
            int randomNumber = rand.nextInt(5) + 1;

            String opponent = "";
            switch (randomNumber) {
                case 1:
                    opponent = "paper";
                    break;
                case 2:
                    opponent = "rock";
                    break;
                case 3:
                    opponent = "scissors";
                    break;
                case 4:
                    opponent = "lizard";
                    break;
                case 5:
                    opponent = "spock";
                    break;
            }

            if (userChoice == opponent) {
                return userChoice + " vs. " + opponent + ".  You tie!";
            } else if ((userChoice == "rock") && (opponent == "scissors") ||
                    (userChoice == "rock") && (opponent == "lizard") ||
                    (userChoice == "scissors") && (opponent == "paper") ||
                    (userChoice == "scissors") && (opponent == "lizard") ||
                    (userChoice == "paper") && (opponent == "rock") ||
                    (userChoice == "paper") && (opponent == "spock") ||
                    (userChoice == "lizard") && (opponent == "paper") ||
                    (userChoice == "lizard") && (opponent == "spock") ||
                    (userChoice == "spock") && (opponent == "scissors") ||
                    (userChoice == "spock") && (opponent == "rock"))
                    {
                return userChoice + " beats " + opponent + ".  You win!";
            } else {
                return opponent + " beats " + userChoice + ".  You lose!";
            }
        }
    }

    void updateView(boolean gameMode) {
        Button Spock = (Button) findViewById(R.id.SpockButton);
        Button Lizard = (Button) findViewById(R.id.LizardButton);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        TextView responseText = (TextView) findViewById(R.id.responseText);
        responseText.setText("Play");
        if(gameMode) {
            // Traditional mode
            Spock.setVisibility(View.INVISIBLE);
            Lizard.setVisibility(View.INVISIBLE);
            imageView.setImageResource(R.drawable.roshambo);
        } else {
            // Lizard Spock mode
            Spock.setVisibility(View.VISIBLE);
            Lizard.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.rpsls);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConstraintLayout mainLayout =
                (ConstraintLayout) findViewById(R.id.layoutView);
        switch (item.getItemId()) {
            case R.id.menu_traditional:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                gameMode = true;
                updateView(gameMode);
                return true;
            case R.id.menu_lizard_spock:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                gameMode = false;
                updateView(gameMode);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
