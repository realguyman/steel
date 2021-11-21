package io.github.realguyman.steel;

import io.github.realguyman.steel.registries.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Initializer implements ModInitializer {
    public static final String MOD_ID = "steel";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
        new Identifier(MOD_ID, "all"),
        () -> new ItemStack(ItemRegistry.STEEL_INGOT)
    );

    @Override
    public void onInitialize() {
        ItemRegistry.register();
    }
}