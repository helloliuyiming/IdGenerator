package test.me.lym.generator.id;

import me.lym.generator.id.IdGeneratorBuilder;
import me.lym.generator.id.segment.*;
import me.lym.generator.id.segment.seqelement.LowerCaseSeqElement;
import me.lym.generator.id.segment.seqelement.NumericSeqElement;
import org.junit.jupiter.api.Test;

public class SegmentIdGeneratorTest {

    @Test
    public void test(){
        NumericSeqElement numericSeqElement = new NumericSeqElement("k1");
        numericSeqElement.setOriginValue("0");
        numericSeqElement.setMinLength(4);
        numericSeqElement.setMaxLength(4);
        numericSeqElement.setPlaceholder('0');
        LowerCaseSeqElement lowerCaseSeqElement = new LowerCaseSeqElement("k2");
        lowerCaseSeqElement.setMinLength(4);
        lowerCaseSeqElement.setMaxLength(4);
        lowerCaseSeqElement.setPlaceholder('*');
        SequenceSegment sequenceSegment = new SequenceSegmentBuilder()
                .addSeqElement(numericSeqElement)
                .addSeqElement(lowerCaseSeqElement)
                .build();
        SegmentIdGenerator segmentIdGenerator = new SegmentIdGeneratorBuilder()
                .addSegment(sequenceSegment)
                .build();
        for (int i = 0; i < 100; i++) {
            System.out.println(segmentIdGenerator.next());
        }
    }
}
