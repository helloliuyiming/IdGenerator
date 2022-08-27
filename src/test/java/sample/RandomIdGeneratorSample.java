package sample;

import me.lym.generator.id.random.RandomIdGenerator;
import me.lym.generator.id.random.RandomIdGeneratorBuilder;
import me.lym.generator.id.random.element.*;
import org.junit.jupiter.api.Test;

public class RandomIdGeneratorSample {

    @Test
    public void basic(){
        RandomIdGenerator randomIdGenerator = new RandomIdGeneratorBuilder()
                .addCharacterElement(new NumericRandomSeedElement(10))
                .addCharacterElement(new LowerCaseRandomSeedElement(26))
                .addCharacterElement(new FinalCharacterAsteriskRandomSeedElement(1))
                .addCharacterElement(new FinalCharacterAmpersandRandomSeedElement(1))
                .setMinLength(10)
                .setMaxLength(12)
                .build();

        for (int i = 0; i < 100; i++) {
            System.out.println(randomIdGenerator.next());
        }
    }

    @Test
    public void extendRandomSeedElement(){
        RandomIdGenerator randomIdGenerator = new RandomIdGeneratorBuilder()
                .setMinLength(10)
                .setMaxLength(10)
                .addCharacterElement(new MyRandomSeedElement(1))
                .build();
        for (int i = 0; i < 100; i++) {
            System.out.println(randomIdGenerator.next());
        }
    }

    class MyRandomSeedElement extends AbstractRandomSeedElement{

        public MyRandomSeedElement(Integer weight) {
            super(weight);
        }

        @Override
        public char generate() {
            return 'm';
        }
    }
}
