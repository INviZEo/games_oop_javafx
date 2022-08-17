package ru.job4j.chess.firuges.black;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {

    @Test
    public void bishopBlackPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Assert.assertEquals(Cell.C1, bishopBlack.position());
    }

    @Test
    public void bishopBlackCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Assert.assertEquals(bishopBlack.position(), bishopBlack.copy(Cell.C1).position());
    }

    @Test
    public void bishopBlackWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = bishopBlack.way(Cell.G5);
        Cell[] steps2 = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertEquals(steps, steps2);
    }
}