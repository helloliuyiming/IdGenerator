package me.lym.generator.id.snowflake;

import me.lym.generator.id.IdGenerator;

public class SnowflakeIdGenerator implements IdGenerator {

    private SnowflakeIdConfig snowflakeIdConfig;
    public SnowflakeIdGenerator(SnowflakeIdConfig snowflakeIdConfig) {
        this.snowflakeIdConfig = snowflakeIdConfig;
    }

    @Override
    public String next() {
        return null;
    }
}
