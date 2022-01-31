package com.example.exam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

class SampleCanvasActivity extends View {
    Paint paint = new Paint();

    public SampleCanvasActivity(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawRect(130, 130, 180, 180, paint);
        paint.setStrokeWidth(0);
        paint.setColor(Color.CYAN);
        canvas.drawRect(133, 160, 177, 177, paint );
        paint.setColor(Color.YELLOW);
        canvas.drawRect(133, 133, 177, 160, paint );

    }
}
