package me.lym.generator.id.segment;

import com.google.gson.Gson;
import me.lym.generator.id.segment.seqelement.SeqElement;
import me.lym.generator.id.segment.seqelement.SeqElementStorable;
import me.lym.generator.id.segment.store.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceSegment extends AbstractSegment{

    private Store store;
    private List<SeqElement> seqElements;
    private Map<String,String> originValueMap;
    public SequenceSegment(Store store,List<SeqElement> seqElements,Map<String,String> originValueMap) {
        this.store = store;
        this.seqElements = seqElements;
        this.originValueMap = originValueMap;
    }

    @Override
    public String generate() {
        Map<String,String> oldValueMap;
        String oldValue = store.getValue();
        if (oldValue != null) {
            oldValueMap = deserialize(oldValue);
        }else {
            oldValueMap = this.originValueMap;
        }
        restore(oldValueMap);
        StringBuilder stringBuilder = new StringBuilder();
        boolean addDone = false;
        for (int i = 0; i < seqElements.size(); i++) {
            SeqElement seqElement = seqElements.get(i);
            if (addDone) {
                stringBuilder.insert(0,seqElement.getValue());
                continue;
            }
            String string = seqElement.increase();
            if (string == null) {
                seqElement.reset();
                stringBuilder.insert(0,seqElement.getValue());
            }else {
                addDone = true;
                stringBuilder.insert(0,string);
            }
        }
        store();
        return stringBuilder.toString();
    }

    private void store(){
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < seqElements.size(); i++) {
            SeqElement seqElement = seqElements.get(i);

            if (seqElement instanceof SeqElementStorable) {
                SeqElementStorable seqElementStorable = (SeqElementStorable) seqElement;
                String value;
                if (seqElement instanceof AbstractSeqElement) {
                    value = ((AbstractSeqElement) seqElement).getRealValue();
                }else {
                    value = seqElement.getValue();
                }
                map.put(seqElementStorable.getKey(), value);
            }
        }
        store.setValue(serialize(map));
    }

    private void restore(Map<String,String> valueMap){
        for (SeqElement seqElement : seqElements) {
            if (seqElement instanceof SeqElementStorable) {
                String storedValue = valueMap.get(((SeqElementStorable) seqElement).getKey());
                seqElement.setValue(storedValue);
            }
        }
    }

    private Map<String, String> deserialize(String serializedStr) {
        Gson gson = new Gson();
        Map<String,String> map = gson.fromJson(serializedStr, Map.class);
        return map;
    }

    private String serialize(Map<String, String> valueMap) {
        Gson gson = new Gson();
        return gson.toJson(valueMap);
    }
}
