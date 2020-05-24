package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack test = new BishopBlack(Cell.A1);
        assertEquals(Cell.A1, test.position());
    }

    @Test
    public void testWay() {
        BishopBlack test = new BishopBlack(Cell.C1);
        Assert.assertArrayEquals(new Cell[]{ Cell.D2, Cell.E3, Cell.F4, Cell.G5}, test.way(Cell.C1, Cell.G5));
    }

    @Test
    public void testCopy() {
        BishopBlack test = new BishopBlack(Cell.A1);
        assertEquals(Cell.A7,test.copy(Cell.A7).position());
    }

    @Test
    public void testIsDiagonal()  {
        BishopBlack test = new BishopBlack(Cell.A1);
        assertFalse(test.isDiagonal(Cell.A1, Cell.A2));
        }
    }


