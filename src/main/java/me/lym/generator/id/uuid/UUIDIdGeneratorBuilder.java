package me.lym.generator.id.uuid;

public class UUIDIdGeneratorBuilder {

    private UUIDConfig uuidConfig;

    public UUIDIdGeneratorBuilder(){
        uuidConfig = new UUIDConfig();
    }

    public UUIDIdGeneratorBuilder setFastModeEnable(Boolean fastModeEnable) {
        this.uuidConfig.setFastModeEnable(fastModeEnable);
        return this;
    }

    public UUIDIdGenerator build(){
        return new UUIDIdGenerator(uuidConfig);
    }

}
