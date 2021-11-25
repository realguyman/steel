package io.github.realguyman.steel.registry;

import io.github.realguyman.steel.Initializer;
import io.github.realguyman.steel.SteelArmorMaterial;
import io.github.realguyman.steel.SteelToolMaterial;
import io.github.realguyman.steel.item.SteelAxeItem;
import io.github.realguyman.steel.item.SteelHoeItem;
import io.github.realguyman.steel.item.SteelPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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

    public static final Item STEEL_SHOVEL = new ShovelItem(SteelToolMaterial.INSTANCE, 1.5F, -3.0F,
            new FabricItemSettings().group(Initializer.ITEM_GROUP));

    public static final Item STEEL_PICKAXE = new SteelPickaxeItem(SteelToolMaterial.INSTANCE, 1, -2.8F,
            new FabricItemSettings().group(Initializer.ITEM_GROUP));

    public static final Item STEEL_AXE = new SteelAxeItem(SteelToolMaterial.INSTANCE, 6, -3.1F,
            new FabricItemSettings().group(Initializer.ITEM_GROUP));

    public static final Item STEEL_HOE = new SteelHoeItem(SteelToolMaterial.INSTANCE, -2, -1.0F,
            new FabricItemSettings().group(Initializer.ITEM_GROUP));

    public static final Item STEEL_SWORD = new SwordItem(SteelToolMaterial.INSTANCE, 3, -2.4F,
            new FabricItemSettings().group(Initializer.ITEM_GROUP));

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
        add("steel_shovel", STEEL_SHOVEL);
        add("steel_pickaxe", STEEL_PICKAXE);
        add("steel_axe", STEEL_AXE);
        add("steel_hoe", STEEL_HOE);
        add("steel_sword", STEEL_SWORD);
    }
}