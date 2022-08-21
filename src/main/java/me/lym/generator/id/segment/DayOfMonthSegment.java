package me.lym.generator.id.segment;

import java.util.Calendar;
import java.util.TimeZone;

public class DayOfMonthSegment implements Segment{

    private int offset = 0; // 偏移
    private TimeZone timezone; //时区

    public DayOfMonthSegment(){
        this(null,null);
    }

    public DayOfMonthSegment(TimeZone timezone) {
        this(timezone, null);
    }

    public DayOfMonthSegment(Integer offset) {
        this(null, offset);
    }

    public DayOfMonthSegment(TimeZone timezone, Integer offset) {
        if (timezone != null) {
            this.timezone = timezone;
        }else {
            this.timezone = TimeZone.getDefault();
        }

        if (offset != null) {
            this.offset = offset;
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }

    @Override
    public String generate() {
        Calendar calendar = Calendar.getInstance(timezone);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        day = day + offset;
        String dayStr = String.valueOf(day);
        if (dayStr.length() == 1) {
            dayStr = "0" + dayStr;
        }
        return dayStr;
    }

}
