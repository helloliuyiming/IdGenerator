package test.me.lym.generator.id;

import me.lym.generator.id.IdGeneratorBuilder;
import me.lym.generator.id.segment.*;
import org.junit.jupiter.api.Test;

public class SegmentIdGeneratorTest {

    @Test
    public void test(){
        SegmentIdGenerator segmentIdGenerator = IdGeneratorBuilder.buildSegmentIdGenerator()
                .addSegment(new YearSegment())
                .addSegment(new MonthSegment())
                .addSegment(new DayOfMonthSegment())
                .addSegment(new SequenceSegment())
                .build();

        for (int i = 0; i < 100; i++) {
            System.out.println(segmentIdGenerator.next());
        }
    }
}