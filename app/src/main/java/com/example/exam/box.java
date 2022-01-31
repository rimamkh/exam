package com.example.exam;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class box  {
    public  interface  listener{
        void onTranslation(float x);

    }
    private box.listener listener;
    public  void setListener(box.listener l){
        listener=l;
    }
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    box(Context context){
        sensorManager=(SensorManager)context.getSystemService(context.SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(listener !=null){
                    listener.onTranslation(sensorEvent.values[0]);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorManager.registerListener(sensorEventListener,sensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    public  void unregister(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}
