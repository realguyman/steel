package io.github.realguyman.steel.registries;

import io.github.realguyman.steel.Initializer;
import io.github.realguyman.steel.items.SteelIngotItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class ItemRegistry {
    public static void register() {
        Registry.register(
            Registry.ITEM,
            new ResourceLocation(Initializer.MOD_ID, "steel_ingot"),
            new SteelIngotItem(
                new FabricItemSettings().tab(CreativeModeTab.TAB_MISC)
            )
        );
    }
}