package io.github.realguyman.steel;

import io.github.realguyman.steel.registries.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class Initializer implements ModInitializer {
    public static final String MOD_ID = "steel";

    @Override
    public void onInitialize() {
        ItemRegistry.register();
    }
}