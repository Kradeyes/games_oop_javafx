package ru.job4j.chess.firuges.black;

import ru.job4j.chess.DirectionOfTravel;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack extends DirectionOfTravel implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = 0;
        int deltaX = source.x;
        int deltaY = source.y;
        int a = 0;
        int b = 0;
        switch (directionOfTravel(source.x, dest.x, source.y, dest.y)){
            case 0:
                size = dest.x - source.x;
                deltaX += 1;
                deltaY += 1;
                a = 1;
                b = 1;
                break;
            case 1:
                size = source.x - dest.x;
                deltaX -= 1;
                deltaY += 1;
                a = -1;
                b = 1;
                break;
            case 2:
                size = dest.x - source.x;
                deltaX += 1;
                deltaY -= 1;
                a = 1;
                b = -1;
                break;
            case 3:
                size = source.x - dest.x;
                deltaX -= 1;
                deltaY -= 1;
                a = -1;
                b = -1;
                break;
        }
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            int x = deltaX + (index * a);
            int y = deltaY + (index * b);
            steps[index] = Cell.findBy(x, y);
        }

        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest)  {
        if(Math.abs(dest.x-source.x) != Math.abs(dest.y-source.y)){
            throw new IllegalStateException();
        }
        return true;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
