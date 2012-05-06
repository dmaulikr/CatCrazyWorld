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

public class Explosion extends Group{

    //public static final int STATE_ALIVE     = 0;    // at least 1 particle is alive
    //public static final int STATE_DEAD      = 1;    // all particles are dead

    private static Random rnd = new Random();

    private Particle[] particles;           // particles in the explosion
    private int x, y;                       // the explosion's origin

    public Explosion(int particleNr, int x, int y, Bitmap bitmap) {
        clear();
        //state = STATE_ALIVE;
        this.x = x;
        this.y = y;
        particles = new Particle[particleNr];
        for (int i = 0; i < particleNr; i++) {
            Particle p = new Particle(0.05f, 0.05f, x, y, (rnd.nextFloat() - 0.5f) /10, (rnd.nextFloat() - 0.5f) / 10, 50);
            //p.loadBitmap(bitmap);
            p.setColor(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat(), 1f);
            particles[i] = p;
            add(p);
        }
        //this.size = particleNr;
    }
    
    public void update() {
        for (int i = 0; i < particles.length; i++) {
            particles[i].update();
        }
    }

}


