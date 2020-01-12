package ru.itc60.samsung.sldungeon.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import ru.itc60.samsung.sldungeon.R;
import ru.itc60.samsung.sldungeon.view.pager.GameActivityPagingAdapter;

public class GameActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private GameActivityPagingAdapter viewPagerAdapter;
    private GameActivityVM vm;

    private Dialog gameOverDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        viewPagerAdapter = new GameActivityPagingAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        vm = ViewModelProviders.of(this).get(GameActivityVM.class);
        vm.getGameOver().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean gameOver) {
                onGameOverChange(gameOver);
            }
        });

    }

    private void onGameOverChange(boolean gameOver) {
        if (!gameOver) {
            return;
        }
        if (gameOverDialog != null && gameOverDialog.isShowing()) {
            return;
        }

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_gameover, null);

        Button restartButton = view.findViewById(R.id.restart_button);
        Button exitButton = view.findViewById(R.id.exit_button);

        gameOverDialog = new AlertDialog.Builder(this)
                .setView(view)
                .setCancelable(false)
                .create();

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameOverDialog.dismiss();
                vm.reset();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameOverDialog.dismiss();
                finish();
            }
        });

        gameOverDialog.show();
    }

}
