package test.me.lym.generator.id;

import me.lym.generator.id.IdGeneratorBuilder;
import me.lym.generator.id.uuid.UUIDIdGenerator;
import org.junit.jupiter.api.Test;

public class UUIDIdGeneratorTest {

    @Test
    public void test(){
        UUIDIdGenerator uuidIdGenerator = IdGeneratorBuilder.buildUUIDIdGenerator()
                .build();

        for (int i = 0; i < 100; i++) {
            System.out.println(uuidIdGenerator.next());
        }
    }

}
