package ahodanenok.rfc3339;

import java.util.Comparator;

public final class Timestamp { //implements Comparable<Timestamp> {

    // private static Comparator<Timestamp> COMPARATOR =
    //     Comparator
    //         .comparingInt(t -> t.year)
    //         .comparingInt(t -> t.month)
    //         .comparingInt(t -> t.day)
    //         .comparingInt(t -> t.hour)
    //         .comparingInt(t -> t.minute)
    //         .comparingInt(t -> t.second)
    //         .comparingInt(t -> t.nanosecond);

    private final int year;
    private final int month;
    private final int day;

    private final int hour;
    private final int minute;
    private final int second;
    private final int nanosecond;

    private final TimeOffset offset;

    public Timestamp(
            int year, int month, int day,
            int hour, int minute, int second, int nanosecond,
            TimeOffset offset) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.nanosecond = nanosecond;
        this.offset = offset;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getNanosecond() {
        return nanosecond;
    }

    public TimeOffset getOffset() {
        return offset;
    }

    // public Timestamp toUtc() {
    //     int secondsOffset = offset.getTotalMinutes();
    //     if (secondsOffset == 0) {
    //         return this;
    //     }

    //     int yearUtc;
    //     int monthUtc;
    //     int dayUtc;
    //     int hourUtc;
    //     int minuteUtc;
    //     int secondUtc;
    //     if (offset.isPositive()) {
    //         secondUtc = second + secondsOffset;
    //         minuteUtc = minute + (secondUtc / 60);
    //         hourUtc
    //     } else {

    //     }

    //     return new Timestamp(
    //         yearUtc, monthUtc, dayUtc,
    //         hourUtc, minuteUtc, secondUtc, nanosecond,
    //         TimeOffset.UTC
    //     );
    // }

    // public int compareTo(Timestamp other) {
    //     return COMPARATOR.compare(this, other);
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (year < 1000) {
            sb.append('0');
            if (year < 100) {
                sb.append('0');
                if (year < 10) {
                    sb.append('0');
                }
            }
        }
        sb.append(year);
        sb.append('-');
        if (month < 10) {
            sb.append('0');
        }
        sb.append(month);
        sb.append('-');
        if (day < 10) {
            sb.append('0');
        }
        sb.append(day);
        sb.append('T');
        if (hour < 10) {
            sb.append('0');
        }
        sb.append(hour);
        sb.append(':');
        if (minute < 10) {
            sb.append('0');
        }
        sb.append(minute);
        sb.append(':');
        if (second < 10) {
            sb.append('0');
        }
        sb.append(second);
        sb.append('.');
        if (nanosecond < 100_000_000) {
            sb.append('0');
            if (nanosecond < 10_000_000) {
                sb.append('0');
                if (nanosecond < 1_000_000) {
                    sb.append('0');
                    if (nanosecond < 100_000) {
                        sb.append('0');
                        if (nanosecond < 10_000) {
                            sb.append('0');
                            if (nanosecond < 1000) {
                                sb.append('0');
                                if (nanosecond < 100) {
                                    sb.append('0');
                                    if (nanosecond < 10) {
                                        sb.append('0');
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(nanosecond);
        sb.append(offset);

        return sb.toString();
    }
}
