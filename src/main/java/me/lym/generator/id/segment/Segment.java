package me.lym.generator.id.segment;

public interface Segment {

    void init(SegmentIdGeneratorContext context);
    String generate();
    SegmentIdGeneratorContext getContext();
    void registerListener(OnValueChangeListener onValueChangeListener);

}
