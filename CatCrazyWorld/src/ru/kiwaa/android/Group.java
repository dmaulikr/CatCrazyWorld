package ru.kiwaa.android;

/**
 * Created by IntelliJ IDEA.
 * User: kiwaa
 * Date: 19.04.12
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
import javax.microedition.khronos.opengles.GL10;
import java.util.Vector;

public class Group extends Mesh {
    private Vector<Mesh> children = new Vector<Mesh>();

    @Override
    public void draw(GL10 gl) {
        int size = children.size();
        if (shouldDraw) {
            gl.glTranslatef(x, y, z);
            gl.glScalef(scale, scale, scale);
            for( int i = 0; i < size; i++) {
                gl.glPushMatrix();
                children.get(i).draw(gl);
                gl.glPopMatrix();
            }
        }
    }

    public void add(int location, Mesh object) {
        children.add(location, object);
    }

    public boolean add(Mesh object) {
        return children.add(object);
    }

    public void clear() {
        children.clear();
    }

    public Mesh get(int location) {
        return children.get(location);
    }

    public Mesh remove(int location) {
        return children.remove(location);
    }

    public boolean remove(Object object) {
        return children.remove(object);
    }

    public int size() {
        return children.size();
    }
}