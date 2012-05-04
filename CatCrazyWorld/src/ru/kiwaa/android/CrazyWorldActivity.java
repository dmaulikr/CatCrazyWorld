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
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

public class CrazyWorldActivity extends Activity implements SensorEventListener {
    
    SensorManager sensorManager;
    Sensor sensor;
    
    WorldModel model = new WorldModel();
    int x;
    int y;
    
    float srx;
    float sry;
    float srz;
    boolean first = true;

    boolean down = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        model.createModel(this);
        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(new OpenGLRenderer(model));
        setContentView(view);

        //for accelerometer
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0 && sensor == null) {
            sensor = sensors.get(0);
        }
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float rx1 = sensorEvent.values[0];
            float ry1 = sensorEvent.values[1];
            float rz1 = sensorEvent.values[2];

            if (first) {
                srx = rx1;
                sry = ry1;
                srz = rz1;
                first = false;

//                Log.d("-----", "-------------------------------");
//                Log.d("srx", String.valueOf(srx));
//                Log.d("sry", String.valueOf(sry));
//                //Log.d("srz", String.valueOf(srz));
//                Log.d("-----", "-------------------------------");
            }
            float diffX = rx1 - srx;
            float diffY = ry1 - sry;
            //float diffZ = rz1 - srz;

//            Log.d("-----", "-------------------------------");
//            Log.d("diffX", String.valueOf(diffX));
//            Log.d("diffY", String.valueOf(diffY));
            //Log.d("diffZ", String.valueOf(diffZ));
            
            model.setXAngle(diffX);
            //model.setYAngle(diffZ);
            model.setZAngle(diffY);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // check if explosion is null or if it is still active
            //int currentExplosion = 0;
            //Explosion explosion = explosions[currentExplosion];
            //while (explosion != null && explosion.isAlive() && currentExplosion < explosions.length) {
             //   currentExplosion++;
             //   explosion = explosions[currentExplosion];
            //}
            //if (explosion == null || explosion.isDead()) {
                //Explosion explosion = new Explosion(15, (int)event.getX(), (int)event.getY());
                //explosions[currentExplosion] = explosion;
            //}
            x = (int)event.getX();
            y = (int)event.getY();
            down = true;
            
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (down){
                int currentX = (int)event.getX();
                int currentY = (int)event.getY();
                int xdiff = x - currentX;
                int ydiff = y - currentY;
                model.setCameraXAngle(model.rx - ydiff);
                model.setCameraYAngle(model.ry - xdiff);
            }
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //int x = event
            //model.setXAngle();
            down = false;
        }
        return true;
    }

}