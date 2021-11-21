package io.github.realguyman.steel.registries;

import io.github.realguyman.steel.Initializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    public static final Item STEEL_INGOT = new Item(
        new Item.Settings().group(Initializer.ITEM_GROUP)
    );

    public static void register() {
        Registry.register(
            Registry.ITEM,
            new Identifier(Initializer.MOD_ID, "steel_ingot"),
            STEEL_INGOT
        );
    }
}