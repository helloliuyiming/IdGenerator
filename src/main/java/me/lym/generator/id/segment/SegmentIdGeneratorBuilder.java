package me.lym.generator.id.segment;

import java.util.List;

public class SegmentIdGeneratorBuilder {

    private SegmentConfig segmentConfig;

    public SegmentIdGeneratorBuilder(){
        segmentConfig = new SegmentConfig();
    }

    public SegmentIdGeneratorBuilder addSegment(Segment segment){
        segmentConfig.addSegment(segment);
        return this;
    }

    public SegmentIdGeneratorBuilder addAllSegment(List<Segment> segments){
        segmentConfig.addAllSegment(segments);
        return this;
    }

    public SegmentIdGeneratorBuilder insertSegment(Integer index, Segment segment){
        segmentConfig.insertSegment(index,segment);
        return this;
    }

    public SegmentIdGeneratorBuilder replaceSegment(Integer index, Segment newSegment){
        segmentConfig.replaceSegment(index, newSegment);
        return this;
    }

    public SegmentIdGenerator build(){
        return new SegmentIdGenerator(segmentConfig);
    }

}
