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
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CrazyWorldActivity extends Activity {
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


    }
}