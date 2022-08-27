package sample;

import me.lym.generator.id.snowflake.SnowflakeIdGenerator;
import me.lym.generator.id.snowflake.SnowflakeIdGeneratorBuilder;
import org.junit.jupiter.api.Test;

public class SnowflakeIdGeneratorSample {

    @Test
    public void basic(){
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGeneratorBuilder()
                .build();

        for (int i = 0; i < 1000; i++) {
            System.out.println(snowflakeIdGenerator.next());
        }
    }
}
