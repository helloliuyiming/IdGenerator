package me.lym.generator.id.segment;

import com.google.gson.Gson;
import me.lym.generator.id.segment.store.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceSegment extends AbstractSegment{

    private Store store;
    private List<SeqElement> seqElements;

    public SequenceSegment(Store store,List<SeqElement> seqElements) {
        this.store = store;
        this.seqElements = seqElements;
    }

    public Map<String,String> getOriginValue(){
        Map<String,String> map = new HashMap<>();
        map.put("k1", "1");
        map.put("k2", "a");
        return map;
    }

    @Override
    public String generate() {
        Map<String,String> oldValueMap;
        String oldValue = store.getValue();
        if (oldValue != null) {
            oldValueMap = deserialize(oldValue);
        }else {
            oldValueMap = getOriginValue();
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
            AbstractSeqElement seqElement = (AbstractSeqElement) seqElements.get(i);
            map.put(seqElement.getKey(), seqElement.getRealValue());
        }
        store.setValue(serialize(map));
    }

    private void restore(Map<String,String> valueMap){
        for (int i = 0; i < seqElements.size(); i++) {
            AbstractSeqElement seqElement = (AbstractSeqElement) seqElements.get(i);
            seqElement.setValue(valueMap.get(seqElement.getKey()));
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
