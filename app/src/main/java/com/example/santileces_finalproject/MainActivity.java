package com.example.santileces_finalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private int num1 = 5;
    private int num2 = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("onCreate", "Allen Kirby V. Santileces");

        num1 += 2;
        num2 += 2;
        Log.d("onCreate", "num1 = " + num1 + "and num2 = " + num2);

        Toolbar tlb = findViewById(R.id.toolbar);
        setSupportActionBar(tlb);

        loadFragment(new guessing_game());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.luMV) {
            loadFragment(new MissionVision());
            return true;
        }
        else if (id == R.id.guessingGame) {
            loadFragment(new guessing_game());
            return true;
        }
        else {
                return super.onOptionsItemSelected(item);
            }
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        num1 += 2;
        num2 += 2;

        Log.d("onPause", "num1 = " + num1 + "and num2 = " + num2);
    }
}