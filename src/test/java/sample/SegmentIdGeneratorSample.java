package sample;

import me.lym.generator.id.segment.*;
import me.lym.generator.id.segment.segment.DayOfMonthSegment;
import me.lym.generator.id.segment.segment.MonthSegment;
import me.lym.generator.id.segment.segment.SequenceSegment;
import me.lym.generator.id.segment.segment.YearSegment;
import me.lym.generator.id.segment.seqelement.LowerCaseSeqElement;
import me.lym.generator.id.segment.seqelement.NumericSeqElement;
import org.junit.jupiter.api.Test;

public class SegmentIdGeneratorSample {

    @Test
    public void basic(){
        SegmentIdGenerator segmentIdGenerator = new SegmentIdGeneratorBuilder()
                .addSegment(new YearSegment())
                .addSegment(new MonthSegment())
                .addSegment(new DayOfMonthSegment())
                .setSeparator("-")
                .build();
        for (int i = 0; i < 100; i++) {
            System.out.println(segmentIdGenerator.next());
        }
    }

    @Test
    public void sequenceSegment(){

        SequenceSegment sequenceSegment = new SequenceSegmentBuilder()
                .addSeqElement(new NumericSeqElement("numericSeqElement", 2, 4, '0'))
                .addSeqElement(new LowerCaseSeqElement("lowerCaseSeqElement", 4, 4, '#'))
                .enterConfigOriginValue()
                .addValue("numericSeqElement", "1")
                .addValue("lowerCaseSeqElement", "")
                .originValueConfigCompleted()
                .build();

        SegmentIdGenerator segmentIdGenerator = new SegmentIdGeneratorBuilder()
                .addSegment(new YearSegment())
                .addSegment(new MonthSegment())
                .addSegment(new DayOfMonthSegment())
                .addSegment(sequenceSegment)
                .build();
        for (int i = 0; i < 10000; i++) {
            System.out.println(segmentIdGenerator.next());
        }
    }

}
