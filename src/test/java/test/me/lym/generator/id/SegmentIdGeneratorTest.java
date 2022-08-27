package test.me.lym.generator.id;

import me.lym.generator.id.segment.*;
import me.lym.generator.id.segment.adapter.YearSegment2SeqElementAdapter;
import me.lym.generator.id.segment.segment.SequenceSegment;
import me.lym.generator.id.segment.seqelement.LowerCaseSeqElement;
import me.lym.generator.id.segment.seqelement.NumericSeqElement;
import org.junit.jupiter.api.Test;

public class SegmentIdGeneratorTest {

    @Test
    public void test(){
        NumericSeqElement numericSeqElement = new NumericSeqElement("k1",4,4,'0');
        LowerCaseSeqElement lowerCaseSeqElement = new LowerCaseSeqElement("k2",4,4,'*');

        SequenceSegment sequenceSegment = new SequenceSegmentBuilder()
                .addSeqElement(numericSeqElement)
                .addSeqElement(lowerCaseSeqElement)
                .enterConfigOriginValue()
                .addValue("k1","1")
                .addValue("k2","")
                .originValueConfigCompleted()
                .build();
        SegmentIdGenerator segmentIdGenerator = new SegmentIdGeneratorBuilder()
                .addSegment(sequenceSegment)
                .build();
        for (int i = 0; i < 10000; i++) {
            System.out.println(segmentIdGenerator.next());
        }
    }

    @Test
    public void testSequenceSegment(){
        NumericSeqElement numericSeqElement = new NumericSeqElement("k1",4,4,' ');
        LowerCaseSeqElement lowerCaseSeqElement = new LowerCaseSeqElement("k2",4,4,'*');

        YearSegment2SeqElementAdapter yearSegment2SeqElementAdapter = new YearSegment2SeqElementAdapter("yearSegment2SeqElementAdapter");
        yearSegment2SeqElementAdapter.registerListener((oldValue, newValue) -> numericSeqElement.reset());
        SequenceSegment sequenceSegment = new SequenceSegmentBuilder()
                .addSeqElement(numericSeqElement)
                .addSeqElement(yearSegment2SeqElementAdapter)
                .build();
        for (int i = 0; i < 100; i++) {
            System.out.println(sequenceSegment.generate());
        }
    }

    @Test
    public void testJava(){
        NumericSeqElement numericSeqElement = new NumericSeqElement("k1",4,4,' ');
        LowerCaseSeqElement lowerCaseSeqElement = new LowerCaseSeqElement("k2",4,4,'*');

    }
}
