package me.lym.generator.id.segment;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;

public class YearSegment implements Segment{

    private int offset = 0; // 偏移
    private int length = 4; //长度 1-4
    private TimeZone timezone; //时区

    public YearSegment(){
        this(null,null,null);
    }

    public YearSegment(TimeZone timezone) {
        this(timezone, null, null);
    }

    public YearSegment(Integer offset, Integer length) {
        this(null, offset, length);
    }

    public YearSegment(TimeZone timezone, Integer offset, Integer length) {
        if (timezone != null) {
            this.timezone = timezone;
        }else {
            this.timezone = TimeZone.getDefault();
        }

        if (offset != null) {
            this.offset = offset;
        }
        if (length != null) {
            if (length < 1 || length > 4) {
                throw new IllegalArgumentException("length must be in 1-4");
            }
            this.length = length;
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 1 || length > 4) {
            throw new IllegalArgumentException("length must be in 1-4");
        }
        this.length = length;
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
        int year = calendar.get(Calendar.YEAR);
        year = year + offset;
        String yearStr = String.valueOf(year).substring(4-length);
        return yearStr;
    }

}
