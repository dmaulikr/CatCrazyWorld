package ru.kiwaa.android;

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

    private float x = 0;
    private float y = 0;
    private float angle = 0;

    
    //create model
    public void createModel() {
        scene = new Group();

        Cube cube1 = new Cube(1,1,1);
        Cube cube2 = new Cube(1,1,1);
        Cube cube3 = new Cube(1,1,1);

        Cube physCube = new Cube(1,1,1);

        //gl.glRotatef(45f, 1, 0, 0);
        cube1.setColor(0.3f, 0,0, 1f);
        cube1.x = 0f;
        cube1.y = 0f;
        cube1.rz = 0f;
        scene.add(cube1);

        cube2.setColor(0, 0.2f,0, 1f);
        cube2.x = 1f;
        cube2.y = 0f;
        cube2.rz = 0f;
        scene.add(cube2);

        cube3.setColor(0, 0.2f,0.2F, 1f);
        cube3.x = 2f;
        cube3.y = 0f;
        cube3.rz = 0f;
        scene.add(cube3);

        physCube.setColor(1f, 1f, 1f, 1f);
        //physCube.x = x++ / 90f;
        //physCube.y = 1f;
        //physCube.rz = - (angle++);
        physCube.x = 0f;
        physCube.y = 1f;
        physCube.rz = 0f;
        scene.add(physCube);
    }

    //evaluate current state
    public Group getCurrentScene() {
        Cube cube = (Cube)scene.get(3);
        if (cube.x <= 2) {
            cube.x = x++ / 90f;
            cube.rz = angle--;
        }
        else {
            cube.x = 3;
            cube.y = 1 - (y--) / 90f;
        }
        return scene;
    }
}
