package me.lym.generator.id.segment.adapter;

import me.lym.generator.id.segment.AbstractSegment;
import me.lym.generator.id.uuid.UUIDIdGenerator;

public class UUIDSegment2SeqElementAdapter extends AbstractSegment {

    public UUIDIdGenerator uuidIdGenerator;

    public UUIDSegment2SeqElementAdapter(UUIDIdGenerator uuidIdGenerator){
        this.uuidIdGenerator = uuidIdGenerator;
    }

    @Override
    public String generate() {
        return uuidIdGenerator.next();
    }
}
