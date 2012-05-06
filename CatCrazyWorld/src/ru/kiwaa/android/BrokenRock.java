package ru.kiwaa.android;

import android.graphics.Bitmap;

/**
 * Created by IntelliJ IDEA.
 * User: Shana
 * Date: 21.04.12
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class BrokenRock extends Group{
    private Cube[] rockParts;
    
    public int broken = 0;
    
    public BrokenRock(float width, float height, float depth, Bitmap rock) {
        rockParts = new Cube[8];

        rockParts[0] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[0].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[0].x = -0.25f;
        rockParts[0].y = 0.25f;
        rockParts[0].z = -0.25f;
        rockParts[0].rz = 0f;

        rockParts[1] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[1].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[1].x = 0.5f-0.25f;
        rockParts[1].y = 0.5f-0.25f;
        rockParts[1].z = 0f-0.25f;
        rockParts[1].rz = 0f;

        rockParts[2] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[2].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[2].x = 0f-0.25f;
        rockParts[2].y = 0f-0.25f;
        rockParts[2].z = 0f-0.25f;
        rockParts[2].rz = 0f;

        rockParts[3] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[3].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[3].x = 0.5f-0.25f;
        rockParts[3].y = 0f-0.25f;
        rockParts[3].z = 0f-0.25f;
        rockParts[3].rz = 0f;

        rockParts[4] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[4].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[4].x = 0f-0.25f;
        rockParts[4].y = 0.5f-0.25f;
        rockParts[4].z = 0.5f-0.25f;
        rockParts[4].rz = 0f;

        rockParts[5] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[5].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[5].x = 0.5f-0.25f;
        rockParts[5].y = 0.5f-0.25f;
        rockParts[5].z = 0.5f-0.25f;
        rockParts[5].rz = 0f;

        rockParts[6] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[6].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[6].x = 0f-0.25f;
        rockParts[6].y = 0f-0.25f;
        rockParts[6].z = 0.5f-0.25f;
        rockParts[6].rz = 0f;

        rockParts[7] = new Cube(0.5f * width, 0.5f * height, 0.5f * depth);
        rockParts[7].loadBitmap(rock);
        //brokenRock.setColor(0.2f, 0.2f, 0.2f, 1f);
        rockParts[7].x = 0f-0.25f;
        rockParts[7].y = 0f-0.25f;
        rockParts[7].z = 0.5f-0.25f;
        rockParts[7].rz = 0f;


        add(rockParts[0]);
        add(rockParts[1]);
        add(rockParts[2]);
        add(rockParts[3]);
        add(rockParts[4]);
        add(rockParts[5]);
        add(rockParts[6]);
        add(rockParts[7]);

    }
    
    public void broke() {
        if (broken == 0)
            broken = 1;
        else
            broken = 4;
    }
    
    public void update() {
        if (broken == 1) {
           rockParts[3].y -= 1 / 90f;
        }
        if (broken == 4) {
            int speed = 10;
            for(Cube part : rockParts) {
                part.y -= speed / 90f;
                speed ++;
            }
        }
    }
}
