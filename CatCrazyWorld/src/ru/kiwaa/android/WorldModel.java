package ru.kiwaa.android;

import android.graphics.Point;

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

    //Used to figure out elapsed time between frames
    private long mLastTime;
    //Variables for the counter
    private int frameSamplesCollected = 0;
    private int frameSampleTime = 0;
    private int fps = 0;
    
    List<Point> fields = new ArrayList<Point>();
    
    //for players cube
    private float diffX = 0;
    private float diffY = 0;
    private float diffZ = 0;

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
    public void createModel() {
        scene = new Group();
        
        Cube grass = new Cube(1,1,1);
        Cube sand = new Cube(1,1,1);
        Cube ice = new Cube(1,1,1);
        Cube cloud = new Cube(1,1,1);
        Cube brokenRock = new Cube(1,1,1);

        Cube cat = new Cube(1,1,1);
        Fish fish = new Fish(1,1,1);
                
        cat.setColor(1f, 1f, 1f, 1f);
        cat.x = -2f;
        cat.y = 2f;
        cat.rz = 0f;
        scene.add(cat);
        
        grass.setColor(0f, 0.3f,0, 1f);
        grass.x = -2f;
        grass.y = 0f;
        grass.rz = 0f;
        scene.add(grass);
        Point grassCoor = new Point(-2, 0);
        fields.add(grassCoor);

        sand.setColor(0f, 0.7f, 0.7f, 1f);
        sand.x = -1f;
        sand.y = 0f;
        sand.rz = 0f;
        scene.add(sand);
        Point sandCoor = new Point(-1, 0);
        fields.add(sandCoor);
        
        ice.setColor(0, 0f, 0.9f, 0.4f);
        ice.x = 0f;
        ice.y = 0f;
        ice.rz = 0f;
        scene.add(ice);
        Point iceCoor = new Point(0, 0);
        fields.add(iceCoor);

        cloud.setColor(0.9f, 0.9f, 0.99f, 0.3f);
        cloud.x = 1f;
        cloud.y = 0f;
        cloud.rz = 0f;
        scene.add(cloud);
        Point cloudCoor = new Point(1, 0);
        fields.add(cloudCoor);

        brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        brokenRock.x = 2f;
        brokenRock.y = 0f;
        brokenRock.rz = 0f;
        scene.add(brokenRock);
        Point rockCoor = new Point(2, 0);
        fields.add(rockCoor);
        
        fish.x = 0f;
        fish.y = 1f;
        scene.add(fish);
    }

    public Group getCurrentScene() {
        return scene;
    }

    //evaluate current state
    public void updateScene() {
        Cube cube = (Cube)scene.get(0);
        
        boolean down = true;
        for (Point p : fields) {
             if (p.x <= cube.x && cube.x <= p.x + 1 && Math.abs(p.y + 1 - cube.y) < 0.01)
                down = false;
        }

        if (down) {
            cube.y = cube.y - 10f / 90f;

            //fall
            if (cube.y < -1)
                //restart
                createModel();
        }
        else {
            cube.x = cube.x + 10f / 90f;
            cube.rz = cube.rz - 10f;
        }
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
}
