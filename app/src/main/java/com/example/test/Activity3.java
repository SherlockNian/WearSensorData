package com.example.test;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.test.databinding.Activity3Binding;

public class Activity3 extends Activity implements SensorEventListener {

    private TextView textView;
    private Activity3   activity3 ;
    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textView = findViewById(R.id.text_accelerometer);
        sensorManager = (SensorManager)  getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Activity3.this,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //here the event.values will provide you with the data
        //index 0 for x axis , 1 for y axis , 2 for z axis
        textView.setText(event.values[0]+"\n"+event.values[1]+"\n"+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}