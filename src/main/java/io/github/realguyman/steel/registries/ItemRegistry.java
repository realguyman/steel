package io.github.realguyman.steel.registries;

import io.github.realguyman.steel.Initializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemRegistry {
    public static void register() {
        Registry.register(
            Registry.ITEM,
            new ResourceLocation(Initializer.MOD_ID, "steel_ingot"),
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC))
        );
    }
}