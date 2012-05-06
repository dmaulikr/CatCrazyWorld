package ru.kiwaa.android;

import android.graphics.Bitmap;

/**
 * Created by IntelliJ IDEA.
 * User: Shana
 * Date: 21.04.12
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class Home extends Group{
    public Home(float width, float height, float depth, Bitmap wall, Bitmap roofTex) {
        Cube cube = new Cube(0.8f * width, 0.8f * height, 0.8f *  depth );
        cube.x = 0;
        cube.y = -0.1f * height;
        cube.loadBitmap(wall);

        FishPart roof = new FishPart(0.75f * width, 1f * height, 1.5f * depth);
        roof.x = 0;
        roof.y = 0.5f * height;
        roof.rz = -90f;


        add(roof);
        add(cube);
    }
}
