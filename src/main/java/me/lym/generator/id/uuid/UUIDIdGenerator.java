package me.lym.generator.id.uuid;

import me.lym.generator.id.IdGenerator;

import java.util.UUID;

public class UUIDIdGenerator implements IdGenerator {

    private UUIDConfig uuidConfig;

    protected UUIDIdGenerator(UUIDConfig uuidConfig) {
        this.uuidConfig = uuidConfig;
    }

    @Override
    public String next() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        if (uuidConfig.isFastModeEnable()) {
            uuidStr = uuidStr.replace("-", "");
        }
        return uuidStr;
    }

}
