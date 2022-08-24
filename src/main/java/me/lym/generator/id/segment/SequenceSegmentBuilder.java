package me.lym.generator.id.segment;

import me.lym.generator.id.segment.store.InMemoryStore;
import me.lym.generator.id.segment.store.Store;

import java.util.LinkedList;
import java.util.List;

public class SequenceSegmentBuilder {

    private List<SeqElement> seqElements;
    private Store store;

    public SequenceSegmentBuilder(){
        store = new InMemoryStore();
        seqElements = new LinkedList<>();
    }

    public SequenceSegmentBuilder addSeqElement(SeqElement seqElement) {
        this.seqElements.add(seqElement);
        return this;
    }

    public SequenceSegment build(){
        return new SequenceSegment(store,seqElements);
    }
}
