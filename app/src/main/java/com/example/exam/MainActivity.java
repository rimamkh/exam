package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private  box box;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_main);
        box gyscope=new box(this);
        gyscope.setListener(new box.listener() {
            @Override
            public void onTranslation(float x) {
                if(x > 50.0f){
                    SampleCanvasActivity    drawView = new SampleCanvasActivity(MainActivity.this);
                    drawView.setBackgroundColor(Color.WHITE);
                    setContentView(drawView);
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }else if(x < 50.0f){
                    SampleCanvasActivity    drawView = new SampleCanvasActivity(MainActivity.this);
                    drawView.setBackgroundColor(Color.WHITE);
                    setContentView(drawView);
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

        box.unregister();
    }
}