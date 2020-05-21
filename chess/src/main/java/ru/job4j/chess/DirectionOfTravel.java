package ru.job4j.chess;

public class DirectionOfTravel {
    int direction;

    public int directionOfTravel (int xs, int xf, int ys, int yf) {
        if(xs < xf && ys < yf) {                    // вверх и вправо
            direction = 0;
        } else if (xs > xf && ys < yf) {            // вверх и влево
            direction = 1;
        } else if (xs < xf && ys > yf) {            // вниз и вправо
            direction = 2;
        } else if (xs > xf && ys > yf) {            // вниз и влево
            direction = 3;
        }
        return direction;
    }
}
