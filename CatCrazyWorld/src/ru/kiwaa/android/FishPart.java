package ru.kiwaa.android;

/**
 * Created by IntelliJ IDEA.
 * User: kiwaa
 * Date: 19.04.12
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class FishPart extends Mesh {
    public FishPart(float width, float height, float depth) {
        width  /= 2;
        height /= 2;
        depth  /= 2;

        float vertices[] = {
                -width, 0f, -depth, // head0
                width, -height, -depth, // head1
                width,  height, -depth, // head2
                -width, 0f, depth, // head3
                width, -height, depth, // head4
                width,  height, depth, // head5
        };

        short indices[] = {
                0, 2, 1,
                0, 1, 4,
                0, 4, 3,
                2, 0, 3,
                2, 3, 5,
                3, 4, 5,
                5, 1, 2,
                5, 4, 1,
//                2, 1, 4,
//                2, 4, 5,
//                3, 4, 5,
//                3, 1, 4,
//                3, 4, 0,
//                5, 3, 0,
//                5, 0, 2,
        };

        setIndices(indices);
        setVertices(vertices);
    }
}
