package com.example.santileces_finalproject;

import android.graphics.Color;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.Random;

public class guessing_game extends Fragment {

    public guessing_game() {

    }

    public static guessing_game newInstance() {
        return new guessing_game();
    }
    private int randomNumber;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guessing_game, container, false);


        final EditText editTextGuess = view.findViewById(R.id.numberGuess);
        Button buttonGuess = view.findViewById(R.id.Guess);
        Button restartGuess = view.findViewById(R.id.Restart);


        buttonGuess.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String userGuessString = editTextGuess.getText().toString();
                checkGuess(userGuessString);
            }
        });
        generateRandomNumber();
        restartGuess.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                editTextGuess.setText("");
                generateRandomNumber();
            }
        });
        return view;
    }
    private void checkGuess(String guessNumber){
        if (!guessNumber.isEmpty()) {
            int userGuess = Integer.parseInt(guessNumber);

            if (userGuess == randomNumber) {
                Toast.makeText(requireContext(), "Yot Got It", Toast.LENGTH_SHORT).show();
            } else if (userGuess < randomNumber) {
                Toast.makeText(requireContext(), "Try Higher", Toast.LENGTH_SHORT).show();
            } else if (userGuess > randomNumber){
                Toast.makeText(requireContext(), "Try Lower", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(requireContext(), "Invalid Guess", Toast.LENGTH_SHORT).show();
        }
    }
    private void generateRandomNumber() {
        randomNumber = new Random().nextInt(100) + 1;
    }
}
