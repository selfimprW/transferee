package com.hitomi.transferimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.hitomi.tilibrary.Transferee;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private Button btnList, btnGrid, btnGoTouchMove, btnClearGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = (Button) findViewById(R.id.btn_list);
        btnGrid = (Button) findViewById(R.id.btn_grid);
        btnGoTouchMove = (Button) findViewById(R.id.btn_touch_move);
        btnClearGlide = (Button) findViewById(R.id.btn_clear_glide);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestGlideActivity.class));
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridViewActivity.class));
            }
        });

        btnGoTouchMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TouchMoveActivity.class));
            }
        });

        btnClearGlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transferee.clear(MainActivity.this);
                Executors.newSingleThreadExecutor().submit(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(getApplicationContext()).clearDiskCache();
                        Glide.get(getApplicationContext()).clearMemory();
                    }
                });
            }
        });

    }

}
