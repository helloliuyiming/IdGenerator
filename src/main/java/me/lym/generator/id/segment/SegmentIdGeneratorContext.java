package me.lym.generator.id.segment;

import java.util.List;

public class SegmentIdGeneratorContext {
    private List<Segment> segments;

    public SegmentIdGeneratorContext(List<Segment> segments) {
        this.segments = segments;
    }

    public Segment getByKey(String key) {
        return null;
    }

    public Segment getPreSegment(){
        return null;
    }

    public Segment getNextSegment(){
        return null;
    }

    public List<Segment> getSegments(){
        return this.segments;
    }

}
