package me.lym.generator.id.segment;

import java.util.Calendar;
import java.util.TimeZone;

public class MonthSegment extends AbstractSegment{

    private int offset = 0; // 偏移
    private TimeZone timezone; //时区

    public MonthSegment(){
        this(null,null);
    }

    public MonthSegment(TimeZone timezone) {
        this(timezone, null);
    }

    public MonthSegment(Integer offset) {
        this(null, offset);
    }

    public MonthSegment(TimeZone timezone, Integer offset) {
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
        int month = calendar.get(Calendar.MONTH);
        month = month + offset;
        String monthStr = String.valueOf(month);
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }
        return monthStr;
    }

}
