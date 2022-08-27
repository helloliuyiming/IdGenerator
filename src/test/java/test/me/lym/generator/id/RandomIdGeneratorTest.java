package test.me.lym.generator.id;

import me.lym.generator.id.IdGeneratorBuilder;
import me.lym.generator.id.random.RandomIdGenerator;
import me.lym.generator.id.random.element.FinalCharacterAtRandomSeedElement;
import me.lym.generator.id.random.element.LowerCaseRandomSeedElement;
import me.lym.generator.id.random.element.NumericRandomSeedElement;
import me.lym.generator.id.random.element.UpperCaseElementRandomSeedElement;
import org.junit.jupiter.api.Test;

public class RandomIdGeneratorTest {

    @Test
    public void test(){
        RandomIdGenerator randomIdGenerator = IdGeneratorBuilder.enterBuildRandomIdGenerator()
                .addCharacterElement(new NumericRandomSeedElement(10))
                .addCharacterElement(new LowerCaseRandomSeedElement(26))
                .addCharacterElement(new UpperCaseElementRandomSeedElement(26))
                .addCharacterElement(new FinalCharacterAtRandomSeedElement(1))
                .build();

        for (int i = 0; i < 100; i++) {
            System.out.println(randomIdGenerator.next());
        }
    }

}
