package ru.kiwaa.android;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.opengl.GLUtils;

import javax.microedition.khronos.opengles.GL10;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Shana
 * Date: 20.04.12
 * Time: 12:59
 * To change this template use File | Settings | File Templates.
 */
public class WorldModel {
    //scene
    Group scene;
    Context context;

    //Used to figure out elapsed time between frames
    private long mLastTime;
    //Variables for the counter
    private int frameSamplesCollected = 0;
    private int frameSampleTime = 0;
    private int fps = 0;

    List<Point> fields = new ArrayList<Point>();
    List<Point> rocks = new ArrayList<Point>();

    //for camera
    public float rx = 0;
    public float ry = 0;
    public float rz = 0;
    
    //for players cube
    private float diffX = 0;
    private float diffY = 0;
    private float diffZ = 0;

    Explosion exp;

    Fish fish;
    Home home;

    private boolean expTrigger = false;
    private  boolean gameEnded = false;
    
    //Cube rock;

    public void setCameraXAngle(float angle) {
        rx = angle;
    }

    public void setCameraYAngle(float angle) {
        ry = angle;
    }

    public void setCameraZAngle(float angle) {
        rz = angle;
    }

    public void setXAngle(float angle) {
        diffX = angle;
    }

    public void setYAngle(float angle) {
        diffY = angle;
    }

    public void setZAngle(float angle) {
        diffZ = angle;
    }

    //create model
    public void createModel(Context context) {
        gameEnded = false;

        this.context = context;

        scene = new Group();
        
        Cube grass = new Cube(1,1,1);
        Cube grass1 = new Cube(1,1,1);
        Cube grass2 = new Cube(1,1,1);
        Cube grass3 = new Cube(1,1,1);
        Cube grass4 = new Cube(1,1,1);
        Cube sand = new Cube(1,1,1);
        Cube sand1 = new Cube(1,1,1);
        Cube sand2 = new Cube(1,1,1);
        Cube ice = new Cube(1,1,1);
        Cube cloud = new Cube(1,1,1);
        Cube brokenRock = new Cube(1,1,1);
        Cube brokenRock1 = new Cube(1,1,1);
        Cube brokenRock2 = new Cube(1,1,1);
        fish = new Fish(0.5f, 0.5f, 0.5f);
        Cube cat = new Cube(1,1,1);
                
        cat.setColor(1f, 1f, 1f, 1f);
        cat.x = -2f;
        cat.y = 2f;
        cat.rz = 0f;
        scene.add(cat);

        home = new Home(1f, 1f, 1f, BitmapFactory.decodeResource(context.getResources(), R.drawable.brick256), null);

        grass.setColor(1f, 1f, 1f, 1f);
        grass.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.grass3));
        grass.x = -2f;
        grass.y = 0f;
        grass.rz = 0f;
        scene.add(grass);
        Point grassCoor = new Point(-2, 0);
        fields.add(grassCoor);

        grass1.setColor(1f, 1f, 1f, 1f);
        grass1.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.grass3));
        grass1.x = -3f;
        grass1.y = 0f;
        grass1.rz = 0f;
        scene.add(grass1);
        fields.add(new Point(-3, 0));

        grass2.setColor(1f, 1f, 1f, 1f);
        grass2.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.grass3));
        grass2.x = -2f;
        grass2.y = 0f;
        grass2.z = 1f;
        grass2.rz = 0f;
        scene.add(grass2);
        fields.add(new Point(-2, 1));

        grass3.setColor(1f, 1f, 1f, 1f);
        grass3.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.grass3));
        grass3.x = -2f;
        grass3.y = 0f;
        grass3.z = 2f;
        grass3.rz = 0f;
        scene.add(grass3);
        fields.add(new Point(-2, 2));

        grass4.setColor(1f, 1f, 1f, 1f);
        grass4.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.grass3));
        grass4.x = 2f;
        grass4.y = 0f;
        grass4.z = 1f;
        grass4.rz = 0f;
        scene.add(grass4);
        fields.add(new Point(2, 1));


        //sand.setColor(0f, 0.7f, 0.7f, 1f);
        sand.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.sand));
        sand.x = -1f;
        sand.y = 0f;
        sand.rz = 0f;
        scene.add(sand);
        Point sandCoor = new Point(-1, 0);
        fields.add(sandCoor);

        sand1.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.sand));
        sand1.x = -1f;
        sand1.y = 0f;
        sand1.z = -1f;
        sand1.rz = 0f;
        scene.add(sand1);
        fields.add(new Point(-1, -1));

        sand2.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.sand));
        sand2.x = 0f;
        sand2.y = 0f;
        sand2.z = 1f;
        sand2.rz = 0f;
        scene.add(sand2);
        fields.add(new Point(0, 1));

        ice.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ice));
        //ice.setColor(0, 0f, 0.9f, 0.4f);
        ice.x = 0f;
        ice.y = 0f;
        ice.rz = 0f;
        scene.add(ice);
        Point iceCoor = new Point(0, 0);
        fields.add(iceCoor);

        cloud.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.cloud));
        //cloud.setColor(0.9f, 0.9f, 0.99f, 0.3f);
        cloud.x = 1f;
        cloud.y = 0f;
        cloud.rz = 0f;
        scene.add(cloud);
        //Point cloudCoor = new Point(1, 0);
        //fields.add(cloudCoor);

        brokenRock.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.rock));
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        brokenRock.x = 2f;
        brokenRock.y = 0f;
        brokenRock.rz = 0f;
        scene.add(brokenRock);
        Point rockCoor = new Point(2, 0);
        fields.add(rockCoor);

        brokenRock1.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.rock));
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        brokenRock1.x = 1f;
        brokenRock1.y = 0f;
        brokenRock1.z = 1f;
        brokenRock1.rz = 0f;
        scene.add(brokenRock1);
        fields.add(new Point(1, 1));

        brokenRock2.loadBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.rock));
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        brokenRock2.x = 2f;
        brokenRock2.y = 0f;
        brokenRock2.z = -1f;
        brokenRock2.rz = 0f;
        scene.add(brokenRock2);
        fields.add(new Point(2, -1));

        fish.setColor(1f, 1f, 1f, 1f);
        fish.x = 0f;
        fish.y = 1f;
        scene.add(fish);

        home.x = 2f;
        home.y = 1f;
        home.z = -1f;
        scene.add(home);

        exp = new Explosion(100, 2, 1, BitmapFactory.decodeResource(context.getResources(), R.drawable.cloud8));
        exp.shouldDraw = false;
        //exp = new CloudSystem(100, 0.5f, 0.5f, 0, BitmapFactory.decodeResource(context.getResources(), R.drawable.cloud3));
        //exp.setTexture();
        scene.add(exp);
    }

    public Group getCurrentScene() {
        return scene;
    }

    //evaluate current state
    public void updateScene() {
        if (!gameEnded) {
        Cube cube = (Cube)scene.get(0);
        
        boolean down = true;
        for (Point p : fields) {
             if (p.x <= cube.x + 0.5f && cube.x <= p.x + 0.5f)
                 if (p.y <= cube.z + 0.5f && cube.z <= p.y + 0.5f)
                    if (Math.abs(0 + 1 - cube.y) < 0.01)
                        down = false;
        }

        if (down) {
            cube.y = cube.y - 10f / 90f;

            //fall
            if (cube.y < -2)
                //restart
                createModel(this.context);
        }
        else {
            //if (diffZ > 0) {
                cube.z = cube.z + diffZ / 90f;
                //cube.y = 1 * (float)Math.abs (Math.cos(cube.x) + Math.sin(cube.x));
                cube.rx = cube.rx + diffZ;
//            }
//            if (diffX > 0) {
                cube.x = cube.x - diffX / 90f;
                //cube.y = 1 * (float)Math.abs (Math.cos(cube.x) + Math.sin(cube.x));
                cube.rz = cube.rz + diffX;
            //}
        }
        
        if (Math.abs(cube.x) < 0.05f && Math.abs(cube.y - 1) < 0.05f){
            fish.shouldDraw = false;
            cube.scale = 1.2f;
        }

      if (Math.abs(cube.x - 2) < 0.3f)
        if (Math.abs(cube.z + 1) < 0.3f)
            if (Math.abs(cube.y - 1) < 0.05f){
                expTrigger = true;
                exp.shouldDraw = true;
                gameEnded = true;
                cube.shouldDraw = false;
                home.scale = 2f;
            }
        }
        if (expTrigger)
            exp.update();
    }

    public float getPlayerX() {
        Cube cube = (Cube)scene.get(0);
        return cube.x;
    }

    public float getPlayerY() {
        Cube cube = (Cube)scene.get(0);
        return cube.y;
    }

    private void calculateFps() {
        long now = System.currentTimeMillis();
        if (mLastTime != 0) {
            //Time difference between now and last time we were here
            int time = (int) (now - mLastTime);
            frameSampleTime += time;
            frameSamplesCollected++;
            //After 10 frames
            if (frameSamplesCollected == 10) {
                //Update the fps variable
                fps = (int) (10000 / frameSampleTime);
                //Reset the sampletime + frames collected
                frameSampleTime = 0;
                frameSamplesCollected = 0;
            }
        }
        mLastTime = now;
    }
    
    public int getFps() {
        return fps;
    }

    public void writeText(GL10 gl) {
        // Create an empty, mutable bitmap
        Bitmap bitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_4444);
// get a canvas to paint over the bitmap
        Canvas canvas = new Canvas(bitmap);
        bitmap.eraseColor(0);

// get a background image from resources
// note the image format must match the bitmap format
        Drawable background = context.getResources().getDrawable(R.drawable.cloud);
        background.setBounds(0, 0, 256, 256);
        background.draw(canvas); // draw the background to our bitmap

// Draw the text
        Paint textPaint = new Paint();
        textPaint.setTextSize(32);
        textPaint.setAntiAlias(true);
        textPaint.setARGB(0xff, 0x00, 0x00, 0x00);
// draw the text centered
        canvas.drawText("Hello World", 16,112, textPaint);

        int[] textures = new int[1];
//Generate one texture pointer...
        gl.glGenTextures(1, textures, 0);
//...and bind it to our array
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

//Create Nearest Filtered Texture
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

//Different possible texture parameters, e.g. GL10.GL_CLAMP_TO_EDGE
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);

//Use the Android GLUtils to specify a two-dimensional texture image from our bitmap
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);

//Clean up
        bitmap.recycle();
    }
}
