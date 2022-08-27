package me.lym.generator.id.snowflake;

import me.lym.generator.id.IdGenerator;

public class SnowflakeIdGenerator implements IdGenerator {

    private SnowflakeIdConfig snowflakeIdConfig;
    private final Snowflake snowflake ;
    public SnowflakeIdGenerator(SnowflakeIdConfig snowflakeIdConfig) {
        this.snowflakeIdConfig = snowflakeIdConfig;
        snowflake = new Snowflake(snowflakeIdConfig.getNodeId());
    }

    @Override
    public String next() {
        return String.valueOf(snowflake.nextId());
    }
}
