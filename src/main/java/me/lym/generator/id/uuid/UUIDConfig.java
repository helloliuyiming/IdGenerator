package me.lym.generator.id.uuid;

import me.lym.generator.id.IdGeneratorConfig;

public class UUIDConfig extends IdGeneratorConfig {

    private boolean fastModeEnable = false;

    private boolean useV1 = false;

    public boolean isFastModeEnable() {
        return fastModeEnable;
    }

    public void setFastModeEnable(boolean fastModeEnable) {
        this.fastModeEnable = fastModeEnable;
    }
}
