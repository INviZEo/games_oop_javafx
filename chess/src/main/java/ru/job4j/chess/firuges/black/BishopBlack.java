package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static java.lang.Math.abs;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }

        int posX = position.getX();
        int posY = position.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        int size = destX - posX;
        Cell[] steps = new Cell[abs(size)];
        int deltaX = destX - posX > 0 ? 1 : -1;
        int deltaY = destY - posY > 0 ? 1 : -1;
        for (int index = 0; index < abs(size); index++) {
            posX += deltaX;
            posY += deltaY;
            steps[index] = Cell.findBy(posX, posY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return abs(dest.getX() - source.getX()) == abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
