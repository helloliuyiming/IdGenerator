package me.lym.generator.id.segment;

import me.lym.generator.id.segment.segment.SequenceSegment;
import me.lym.generator.id.segment.seqelement.SeqElement;
import me.lym.generator.id.segment.store.InMemoryStore;
import me.lym.generator.id.segment.store.Store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SequenceSegmentBuilder {

    private final List<SeqElement> seqElements;
    private Store store;
    private final Map<String,String> originValueMap;
    private final SequenceOriginValueConfigBuilder sequenceOriginValueConfigBuilder;

    public SequenceSegmentBuilder(){
        seqElements = new LinkedList<>();
        originValueMap = new HashMap<>();
        sequenceOriginValueConfigBuilder = new SequenceOriginValueConfigBuilder();
    }

    public SequenceSegmentBuilder addSeqElement(SeqElement seqElement) {
        this.seqElements.add(seqElement);
        return this;
    }

    public SequenceOriginValueConfigBuilder enterConfigOriginValue(){
        return this.sequenceOriginValueConfigBuilder;
    }

    public SequenceSegmentBuilder setStore(Store store) {
        this.store = store;
        return this;
    }

    public SequenceSegment build(){
        if (store == null) {
            store = new InMemoryStore();
        }
        if (seqElements.isEmpty()) {
            throw new IllegalStateException("seqElement can't be null");
        }
        return new SequenceSegment(store,seqElements,originValueMap);
    }


    public class SequenceOriginValueConfigBuilder{
        public SequenceOriginValueConfigBuilder addValue(String key, String value) {
            originValueMap.put(key, value);
            return this;
        }
        public SequenceSegmentBuilder originValueConfigCompleted(){
            return SequenceSegmentBuilder.this;
        }
    }

}
