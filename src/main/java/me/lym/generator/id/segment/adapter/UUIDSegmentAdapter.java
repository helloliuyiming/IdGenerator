package me.lym.generator.id.segment.adapter;

import me.lym.generator.id.segment.Segment;
import me.lym.generator.id.uuid.UUIDIdGenerator;

public class UUIDSegmentAdapter implements Segment {

    public UUIDIdGenerator uuidIdGenerator;

    public UUIDSegmentAdapter(UUIDIdGenerator uuidIdGenerator){
        this.uuidIdGenerator = uuidIdGenerator;
    }

    @Override
    public String generate() {
        return uuidIdGenerator.next();
    }
}
