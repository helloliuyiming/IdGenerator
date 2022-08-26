package me.lym.generator.id.segment.adapter;

import me.lym.generator.id.segment.AbstractSeqElement;
import me.lym.generator.id.segment.YearSegment;

public class YearSegment2SeqElementAdapter extends AbstractSeqElement {
    YearSegment yearSegment;
    public YearSegment2SeqElementAdapter(String key) {

        yearSegment = new YearSegment();
    }

    public YearSegment2SeqElementAdapter(String key, YearSegment yearSegment) {

        this.yearSegment = yearSegment;
    }

    @Override
    public String increase() {
        return yearSegment.generate();
    }

    @Override
    public String getValue() {
        return yearSegment.generate();
    }

    @Override
    public void reset() {
        setValue("");
    }
}
