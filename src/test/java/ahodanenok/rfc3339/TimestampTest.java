package ahodanenok.rfc3339;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimestampTest {

    @Test
    public void testGetters() {
        Timestamp timestamp = new Timestamp(
            2026, 10, 26, 22, 35, 37, 123,
            TimeOffset.plus(1, 30)
        );
        assertEquals(2026, timestamp.getYear());
        assertEquals(10, timestamp.getMonth());
        assertEquals(26, timestamp.getDay());
        assertEquals(22, timestamp.getHour());
        assertEquals(35, timestamp.getMinute());
        assertEquals(37, timestamp.getSecond());
        assertEquals(123, timestamp.getNanosecond());
        assertEquals(1, timestamp.getOffset().getHours());
        assertEquals(30, timestamp.getOffset().getMinutes());
        assertEquals(true, timestamp.getOffset().isPositive());
    }

    @Test
    public void testFormat() {
        assertEquals(
            "2026-10-26T22:35:37.000000123Z",
            new Timestamp(2026, 10, 26, 22, 35, 37, 123, TimeOffset.UTC).toString());
        assertEquals(
            "0000-01-01T00:00:00.000000000Z",
            new Timestamp(0, 1, 1, 0, 0, 0, 0, TimeOffset.UTC).toString());
        assertEquals(
            "9999-12-31T23:59:59.999999999Z",
            new Timestamp(9999, 12, 31, 23, 59, 59, 999999999, TimeOffset.UTC).toString());
        assertEquals(
            "2025-05-03T14:02:15.000162331-04:30",
            new Timestamp(2025, 5, 3, 14, 2, 15, 162331, TimeOffset.minus(4, 30)).toString());
    }
}