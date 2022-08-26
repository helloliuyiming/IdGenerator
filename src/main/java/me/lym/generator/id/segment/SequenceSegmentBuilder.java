package me.lym.generator.id.segment;

import me.lym.generator.id.segment.seqelement.SeqElement;
import me.lym.generator.id.segment.store.InMemoryStore;
import me.lym.generator.id.segment.store.Store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SequenceSegmentBuilder {

    private final List<SeqElement> seqElements;
    private final Store store;
    private final Map<String,String> originValueMap;
    private final SequenceOriginValueConfigBuilder sequenceOriginValueConfigBuilder;

    public SequenceSegmentBuilder(){
        store = new InMemoryStore();
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

    public SequenceSegment build(){
        return new SequenceSegment(store,seqElements,originValueMap);
    }

    public class SequenceOriginValueConfigBuilder{
        public SequenceOriginValueConfigBuilder addValue(String key, String value) {
            originValueMap.put(key, value);
            return this;
        }
        public SequenceSegmentBuilder completed(){
            return SequenceSegmentBuilder.this;
        }
    }

}
