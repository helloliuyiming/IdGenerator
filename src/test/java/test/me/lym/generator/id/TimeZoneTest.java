package test.me.lym.generator.id;

import me.lym.generator.id.segment.YearSegment;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneTest {

    private String shanghai = "Asia/Shanghai";
    @Test
    public void a(){
        TimeZone localTimeZone = TimeZone.getDefault();
        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String availableID : availableIDs) {
//            System.out.println(availableID);
        }

        TimeZone shanghaiTimeZone = TimeZone.getTimeZone(shanghai);
        System.out.println(localTimeZone);
        System.out.println(shanghaiTimeZone);

        int i = Calendar.getInstance(TimeZone.getDefault()).get(Calendar.YEAR);
        System.out.println(i);
    }

    @Test
    public void b(){
        YearSegment yearSegment = new YearSegment(0,2);
        System.out.println(yearSegment.generate());
    }

    @Test
    public void c(){
        StringBuilder stringBuilder = new StringBuilder();
        String a = null;
        stringBuilder.append(a);
        stringBuilder.append("hello");
        System.out.println(stringBuilder);
    }
}
