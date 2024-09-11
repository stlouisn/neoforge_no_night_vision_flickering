package net.semperidem.easeoutnightvision.fabric;

import net.semperidem.easeoutnightvision.Easeoutnightvision;
import net.fabricmc.api.ModInitializer;

public class EaseoutnightvisionFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Easeoutnightvision.init();
    }
}