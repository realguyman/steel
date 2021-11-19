package io.github.realguyman.steel;

import net.fabricmc.api.ModInitializer;

import io.github.realguyman.steel.registries.ItemRegistry;

public class Initializer implements ModInitializer {
    public static final String MOD_ID = "steel";

    @Override
    public void onInitialize() {
        ItemRegistry.register();
    }
}