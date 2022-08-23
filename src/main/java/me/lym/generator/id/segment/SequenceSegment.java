package me.lym.generator.id.segment;

import me.lym.generator.id.segment.store.InMemoryStore;
import me.lym.generator.id.segment.store.Store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SequenceSegment implements Segment{

    private Store store;
    private List<SeqElement> seqElements;

    public SequenceSegment(){
        this(new InMemoryStore());
    }

    public SequenceSegment(Store store) {
        this.store = store;
        seqElements = new LinkedList<>();
    }

    public SequenceSegment addSeqElement(SeqElement seqElement) {
        this.seqElements.add(0,seqElement);
        return this;
    }
    public SequenceSegment clearSeqElement(){
        this.seqElements.clear();
        return this;
    }
    @Override
    public String generate() {
        return null;
    }

    private void store(){
        Map<String,String> map = new HashMap<>();

    }

    private void restore(){

    }
}
