package me.lym.generator.id.segment;

import java.util.ArrayList;
import java.util.List;

public class SegmentConfig {

    private String separator;
    private List<Segment> segmentList;

    public SegmentConfig(){
        segmentList = new ArrayList<>();
    }

    public void addSegment(Segment segment){
        this.segmentList.add(segment);
    }

    public void addAllSegment(List<Segment> segments){
        this.segmentList.addAll(segments);
    }

    public List<Segment> getSegments(){
        return this.segmentList;
    }

    public void removeSegment(Segment segment){

    }

    public void insertSegment(Integer index, Segment segment) {

    }

    public void replaceSegment(Integer index, Segment newSegment) {

    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
