package ru.kiwaa.android;

/**
 * Created by IntelliJ IDEA.
 * User: Shana
 * Date: 21.04.12
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class Fish extends Group{
    public Fish(float width, float height, float depth) {
        FishPart head = new FishPart(0.4f * width, 0.6f * height, 0.2f * depth);
        head.x = -width / 2;
        head.y = 0.1f * height;
        Cube bone1 = new Cube(0.2f * width, 0.2f * height, 0.2f * depth);
        bone1.x = -width * 3f / 10f;
        bone1.y = 0;
        Cube bone2 = new Cube(0.2f * width, 0.2f * height, 0.2f * depth);
        bone2.x = -width * 1f / 10f;
        bone2.y = 0;
        Cube bone3 = new Cube(0.2f * width, 0.2f * height, 0.2f * depth);
        bone3.x = width * 1f / 10f;
        bone3.y = 0;
        FishPart tail = new FishPart(0.4f * width, 0.4f * height, 0.2f * depth);
        tail.x = 3f/10f * width;
        tail.y = 0;
        
        add(head);
        add(bone1);
        add(bone2);
        add(bone3);
        add(tail);
    }
}
