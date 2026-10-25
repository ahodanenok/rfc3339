package ahodanenok.rfc3339;

public final class TimeOffset {

    public static final TimeOffset UTC = new TimeOffset(true, 0);

    public static TimeOffset plus(int hour, int minute) {
        return new TimeOffset(true, hour * 60 + minute);
    }

    public static TimeOffset minus(int hour, int minute) {
        return new TimeOffset(false, hour * 60 + minute);
    }

    private final boolean positive;
    private final int minutes;

    private TimeOffset(boolean positive, int minutes) {
        this.positive = positive;
        this.minutes = minutes;
    }

    public int getHours() {
        return minutes / 60;
    }

    public int getMinutes() {
        return minutes % 60;
    }

    public int getTotalMinutes() {
        return minutes;
    }

    public int getTotalSeconds() {
        return minutes * 60;
    }

    public boolean isPositive() {
        return positive;
    }

    @Override
    public String toString() {
        if (positive && minutes == 0) {
            return "Z";
        }

        StringBuilder sb = new StringBuilder();
        if (positive) {
            sb.append('+');
        } else {
            sb.append('-');
        }

        int hours = getHours();
        if (hours < 10) {
            sb.append('0');
        }
        sb.append(hours);
        sb.append(':');
        int minutes = getMinutes();
        if (minutes < 10) {
            sb.append('0');
        }
        sb.append(minutes);

        return sb.toString();
    }
}
