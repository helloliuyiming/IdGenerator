package test.me.lym.generator.id;

import me.lym.generator.id.IdGeneratorBuilder;
import me.lym.generator.id.segment.*;
import me.lym.generator.id.segment.seqelement.NumericSeqElement;
import org.junit.jupiter.api.Test;

public class SegmentIdGeneratorTest {

    @Test
    public void test(){
        NumericSeqElement numericSeqElement = new NumericSeqElement("numericSeqElement");
        numericSeqElement.setOriginValue("0");
        numericSeqElement.setMinLength(3);
        numericSeqElement.setPlaceholder('0');
        SegmentIdGenerator segmentIdGenerator = IdGeneratorBuilder.buildSegmentIdGenerator()
                .addSegment(new YearSegment())
                .addSegment(new MonthSegment())
                .addSegment(new DayOfMonthSegment())
                .addSegment(new SequenceSegment())
                .addSegment(new SequenceSegment()
                        .addSeqElement(numericSeqElement))
                .build();

        for (int i = 0; i < 100; i++) {
            System.out.println(segmentIdGenerator.next());
        }
    }
}
