package me.lym.generator.id.snowflake;

public class SnowflakeIdGeneratorBuilder {

    private SnowflakeIdConfig snowflakeIdConfig;

    public SnowflakeIdGeneratorBuilder(){
        snowflakeIdConfig = new SnowflakeIdConfig();
    }

    public SnowflakeIdGenerator build(){
        return new SnowflakeIdGenerator(snowflakeIdConfig);
    }
}
