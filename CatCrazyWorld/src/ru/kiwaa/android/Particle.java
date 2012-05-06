package ru.kiwaa.android;

/**
 * Created by IntelliJ IDEA.
 * User: Shana
 * Date: 27.04.12
 * Time: 2:06
 * To change this template use File | Settings | File Templates.
 */
public class Particle extends Mesh {
    
        
        public static final int STATE_ALIVE = 0;    // particle is alive
        public static final int STATE_DEAD = 1;     // particle is dead
        public static final int DEFAULT_LIFETIME    = 20;  // play with this

        //Particle properties
        private int state;          // particle is alive or dead
        public double xv, yv;      // vertical and horizontal velocity
        private int age;            // current age of the particle
        private int lifetime;       // particle dies when it reaches this value

        public Particle(float width, float height) {
            this(width, height, 0f, 0f, 0.1f, 0.1f);
        }
    
        public Particle(float width, float height, float x, float y, float xv, float yv) {
                this(width, height, x, y, xv, yv, DEFAULT_LIFETIME);
        }

        public Particle(float width, float height, float x, float y, float xv, float yv, int lifetime) {

        state = Particle.STATE_ALIVE;
        this.lifetime = lifetime;
        age = 0;

        this.x = x;
        this.y = y;

        this.xv = xv;
        this.yv = yv;

        float vertices[] = { -width, -height, 0, // 0
                width, -height, 0, // 1
                width,  height, 0, // 2
                -width,  height, 0, // 3
        };

        short indices[] = {
                0, 1, 3,
                1, 2, 3,
        };

        float texture[] = {
                0f, 0f,
                0f, 0.01f,
                0.01f, 0.01f,
                0.01f, 0f,
        };

        setIndices(indices);
        setVertices(vertices);
        setTextureCoordinates(texture);

    }

    
        public void update() {
            if (this.state != STATE_DEAD) {
                this.x += this.xv;
                this.y += this.yv;
                this.age++; // increase the age of the particle
                if (this.age >= this.lifetime) { // reached the end if its life
                    this.state = STATE_DEAD;
                }
            }
            else
                shouldDraw = false;
        }

}
