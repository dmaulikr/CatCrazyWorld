package ru.kiwaa.android;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by IntelliJ IDEA.
 * User: kiwaa
 * Date: 19.04.12
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */

public class OpenGLRenderer implements Renderer {

    //private Mesh root;
    private  WorldModel model;

    private float angle = 0f;
    int width;
    int height;

    public OpenGLRenderer(WorldModel model) {
        this.model = model;
        //root = model.getCurrentScene();
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background color to black ( rgba ).
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);  // OpenGL docs.

        // Enable Smooth Shading, default not really needed.
        gl.glShadeModel(GL10.GL_SMOOTH);// OpenGL docs.
        // Depth buffer setup.
        gl.glClearDepthf(1.0f);// OpenGL docs.
        // Enables depth testing.
        gl.glEnable(GL10.GL_DEPTH_TEST);// OpenGL docs.
        // The type of depth testing to do.
        gl.glDepthFunc(GL10.GL_LEQUAL);// OpenGL docs.
        // Really nice perspective calculations.
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, // OpenGL docs.
                GL10.GL_NICEST);
    }

    public void onDrawFrame(GL10 gl) {
        // Clears the screen and depth buffer.
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | // OpenGL docs.
                GL10.GL_DEPTH_BUFFER_BIT);

        model.updateScene();
        //GLU.gluLookAt(gl, (float)(10 * Math.cos(model.rx)), (float)(10 * Math.sin(model.ry)), -10, model.getPlayerX(), model.getPlayerY(), 0, (float)(10 * Math.sin(model.ry)), 1, 0);
        // Replace the current matrix with the identity matrix
        gl.glLoadIdentity();
        GLU.gluLookAt(gl,
                model.getPlayerX() + (float)(10 * Math.cos(model.rx / 100) * Math.sin(model.ry / 100)),
                model.getPlayerY() + (float)(10 * Math.sin(model.rx / 100) * Math.sin(model.ry / 100)),
                (float)(10 * Math.cos(model.ry / 100)),
                model.getPlayerX(), model.getPlayerY(), 0,
                0, 1, 0);
        //angle  += 1;
        //model.setZAngle(5);
        model.getCurrentScene().draw(gl);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        this.width = width;
        this.height = height;
        // Sets the current view port to the new size.
        gl.glViewport(0, 0, width, height);// OpenGL docs.
        // Select the projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);// OpenGL docs.
        // Reset the projection matrix
        gl.glLoadIdentity();// OpenGL docs.
        // Calculate the aspect ratio of the window
        GLU.gluPerspective(gl, 45.0f,
                (float) width / (float) height,
                0.1f, 100.0f);
        // Select the modelview matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);// OpenGL docs.
        // Reset the modelview matrix
        gl.glLoadIdentity();// OpenGL docs.
    }

}