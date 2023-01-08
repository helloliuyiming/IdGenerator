package sample;

import me.lym.generator.id.uuid.UUIDIdGenerator;
import me.lym.generator.id.uuid.UUIDIdGeneratorBuilder;
import org.junit.jupiter.api.Test;

public class UuidIdGeneratorSample {

    @Test
    public void basic(){
        UUIDIdGenerator uuidIdGenerator = new UUIDIdGeneratorBuilder()
                .setFastModeEnable(true)
                .build();
        uuidIdGenerator.next();
        System.out.println(uuidIdGenerator.next());
        for (int i = 0; i < 1000; i++) {
            System.out.println(uuidIdGenerator.next());
        }
    }

}
