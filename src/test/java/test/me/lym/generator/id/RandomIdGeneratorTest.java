package test.me.lym.generator.id;

import me.lym.generator.id.IdGeneratorBuilder;
import me.lym.generator.id.random.RandomIdGenerator;
import me.lym.generator.id.random.element.CharacterAtElement;
import me.lym.generator.id.random.element.LowerCaseElement;
import me.lym.generator.id.random.element.NumericElement;
import me.lym.generator.id.random.element.UpperCaseElement;
import org.junit.jupiter.api.Test;

public class RandomIdGeneratorTest {

    @Test
    public void test(){
        RandomIdGenerator randomIdGenerator = IdGeneratorBuilder.enterBuildRandomIdGenerator()
                .addCharacterElement(new NumericElement(10))
                .addCharacterElement(new LowerCaseElement(26))
                .addCharacterElement(new UpperCaseElement(26))
                .addCharacterElement(new CharacterAtElement(1))
                .build();

        for (int i = 0; i < 100; i++) {
            System.out.println(randomIdGenerator.next());
        }
    }

}
