package ru.kiwaa.android;
/**
 * Created by IntelliJ IDEA.
 * User: kiwaa
 * Date: 19.04.12
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */

//http://blog.jayway.com/2009/12/03/opengl-es-tutorial-for-android-part-i/

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CrazyWorldActivity extends Activity implements SensorEventListener {
    
    SensorManager sensorManager;
    Sensor sensor;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        WorldModel model = new WorldModel();
        model.createModel();
        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(new OpenGLRenderer(model));
        setContentView(view);
        
        //for accelerometer
//        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
//        if (sensors.size() > 0 && sensor == null) {
//            sensor = sensors.get(0);
//        }
//        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            boolean b = true;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}