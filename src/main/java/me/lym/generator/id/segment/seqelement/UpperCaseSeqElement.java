package me.lym.generator.id.segment.seqelement;

import me.lym.generator.id.segment.AbstractSeqElement;

public class UpperCaseSeqElement extends AbstractSeqElement implements SeqElementStorable{

    private String key;
    public UpperCaseSeqElement(String key) {
        this.key = key;
    }

    @Override
    public String increase() {
        return null;
    }

    @Override
    public void reset() {
        setValue("");
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
