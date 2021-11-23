package io.github.realguyman.steel.registry;

import io.github.realguyman.steel.Initializer;
import io.github.realguyman.steel.SteelArmorMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {    
    public static final Item STEEL_NUGGET = new Item(
        new FabricItemSettings().group(Initializer.ITEM_GROUP)
    );
    
    public static final Item STEEL_INGOT = new Item(
        new FabricItemSettings().group(Initializer.ITEM_GROUP)
    );

    public static final Item STEEL_BLOCK = new BlockItem(
        BlockRegistry.STEEL_BLOCK,
        new FabricItemSettings().group(Initializer.ITEM_GROUP)
    );

    public static final Item STEEL_HELMET = new ArmorItem(
        SteelArmorMaterial.INSTANCE,
        EquipmentSlot.HEAD,
        new FabricItemSettings().group(Initializer.ITEM_GROUP)
    );

    public static final Item STEEL_CHESTPLATE = new ArmorItem(
        SteelArmorMaterial.INSTANCE,
        EquipmentSlot.CHEST,
        new FabricItemSettings().group(Initializer.ITEM_GROUP)
    );

    public static final Item STEEL_LEGGINGS = new ArmorItem(
        SteelArmorMaterial.INSTANCE,
        EquipmentSlot.LEGS,
        new FabricItemSettings().group(Initializer.ITEM_GROUP)
    );

    public static final Item STEEL_BOOTS = new ArmorItem(
        SteelArmorMaterial.INSTANCE,
        EquipmentSlot.FEET,
        new FabricItemSettings().group(Initializer.ITEM_GROUP)
    );

    private static void add(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(Initializer.MOD_ID, name), item);
    }

    public static void register() {
        add("steel_nugget", STEEL_NUGGET);
        add("steel_ingot", STEEL_INGOT);
        add("steel_block", STEEL_BLOCK);
        add("steel_helmet", STEEL_HELMET);
        add("steel_chestplate", STEEL_CHESTPLATE);
        add("steel_leggings", STEEL_LEGGINGS);
        add("steel_boots", STEEL_BOOTS);
    }
}