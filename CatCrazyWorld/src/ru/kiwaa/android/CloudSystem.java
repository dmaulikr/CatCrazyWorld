package ru.kiwaa.android;

import android.graphics.Bitmap;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Shana
 * Date: 27.04.12
 * Time: 14:01
 * To change this template use File | Settings | File Templates.
 */

public class CloudSystem extends Group{

    private static Random rnd = new Random();

    private Particle[] particles;           // particles in the explosion
    private float x, y, radius;                       // the explosion's origin

    public CloudSystem(int particleNr, float radius, float x, float y, Bitmap bitmap) {
        clear();
        //state = STATE_ALIVE;
        this.x = x;
        this.y = y;
        particles = new Particle[particleNr];
        for (int i = 0; i < particleNr; i++) {
            Particle p = new Particle(0.02f, 0.02f, x, y, rnd.nextFloat() - 0.5f, rnd.nextFloat() - 0.5f, 2000);
            p.loadBitmap(bitmap);
            p.setColor(1f, 1f, 1f, 1f);
            particles[i] = p;
            add(p);
        }
        //this.size = particleNr;
    }
    
    public void update() {
        for (int i = 0; i < particles.length; i++) {
            if (particles[i].x + particles[i].xv > x + radius ||
                    particles[i].x + particles[i].xv < x - radius ||
                particles[i].y + particles[i].yv > y + radius ||
                    particles[i].y + particles[i].yv < y - radius) {
                particles[i].xv = -particles[i].xv * 2 * rnd.nextFloat();
                particles[i].yv = -particles[i].yv * 2 * rnd.nextFloat();
            }
            particles[i].update();            
        }
    }

}


