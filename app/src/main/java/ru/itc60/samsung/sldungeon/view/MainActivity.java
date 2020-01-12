package ru.itc60.samsung.sldungeon.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import ru.itc60.samsung.sldungeon.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNewGameButtonClick(View view) {
        startActivity(new Intent(this, GameActivity.class));
    }

    public void onExitButtonClick(View view) {
        finishAndRemoveTask();
    }
}