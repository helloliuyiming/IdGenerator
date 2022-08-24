package me.lym.generator.id.segment.seqelement;

import me.lym.generator.id.segment.AbstractSeqElement;

public class NumericSeqElement extends AbstractSeqElement {

    public NumericSeqElement(String key) {
        super(key);
        setOriginValue("0");
    }

    @Override
    public String increase() {
        char[] chars = getRealValue().toCharArray();
        StringBuilder stringBuilder = new StringBuilder(chars.length + 1);
        boolean increaseDone = false;
        for (int i = chars.length - 1; i > 0; i--) {
            char c = chars[i];
            int ascii = (int) c;
            if ((ascii < 48 || ascii > 57)) {
                throw new IllegalStateException();
            }
            if (increaseDone) {
                stringBuilder.insert(0,c);
                continue;
            }
            if (ascii > 48 && ascii < 57) {
                ascii++;
                c = (char) ascii;
                stringBuilder.insert(0,c);
                increaseDone = true;
                continue;
            }
            stringBuilder.insert(0, '0');
        }
        if (!increaseDone) {
            if (chars.length < getMaxLength()) {
                stringBuilder.insert(0, '1');
            }else {
                return null;
            }
        }
        setValue(stringBuilder.toString());
        return getValue();
    }

}
