package ahodanenok.rfc3339;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeOffsetTest {

    @Test
    public void testZulu() {
        TimeOffset offset = TimeOffset.UTC;
        assertEquals(0, offset.getHours());
        assertEquals(0, offset.getMinutes());
        assertEquals(0, offset.getTotalMinutes());
        assertEquals(0, offset.getTotalSeconds());
        assertEquals(true, offset.isPositive());
    }

    @Test
    public void testNegative() {
        TimeOffset offset = TimeOffset.minus(3, 45);
        assertEquals(3, offset.getHours());
        assertEquals(45, offset.getMinutes());
        assertEquals(225, offset.getTotalMinutes());
        assertEquals(13500, offset.getTotalSeconds());
        assertEquals(false, offset.isPositive());
    }

    @Test
    public void testPositive() {
        TimeOffset offset = TimeOffset.plus(12, 7);
        assertEquals(12, offset.getHours());
        assertEquals(7, offset.getMinutes());
        assertEquals(727, offset.getTotalMinutes());
        assertEquals(43620, offset.getTotalSeconds());
        assertEquals(true, offset.isPositive());
    }

    @Test
    public void testFormat() {
        assertEquals("Z", TimeOffset.UTC.toString());
        assertEquals("+04:07", TimeOffset.plus(4, 7).toString());
        assertEquals("+01:34", TimeOffset.plus(1, 34).toString());
        assertEquals("+14:05", TimeOffset.plus(14, 5).toString());
        assertEquals("+16:23", TimeOffset.plus(16, 23).toString());
        assertEquals("-04:07", TimeOffset.minus(4, 7).toString());
        assertEquals("-01:34", TimeOffset.minus(1, 34).toString());
        assertEquals("-14:05", TimeOffset.minus(14, 5).toString());
        assertEquals("-16:23", TimeOffset.minus(16, 23).toString());
    }
}