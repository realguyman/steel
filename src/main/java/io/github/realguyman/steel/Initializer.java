package io.github.realguyman.steel;

import io.github.realguyman.steel.registry.BlockRegistry;
import io.github.realguyman.steel.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;

public class Initializer implements ModInitializer {
    public static final String MOD_ID = "steel";

    private static final String[] CHEST_LOOT_TABLES = {
        "abandoned_mineshaft",
        "buried_treasure",
        "desert_pyramid",
        "end_city_treasure",
        "jungle_temple",
        "nether_bridge",
        "pillager_outpost",
        "shipwreck_treasure",
        "simple_dungeon",
        "underwater_ruin_big",
        "underwater_ruin_small",
        "village/village_armorer",
        "village/village_toolsmith",
        "village/village_weaponsmith",
        "woodland_mansion"
    };

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
        new Identifier(MOD_ID, "all"),
        () -> new ItemStack(ItemRegistry.STEEL_INGOT)
    );

    @Override
    public void onInitialize() {
        ItemRegistry.register();
        BlockRegistry.register();

        Identifier[] lootTableIds = new Identifier[CHEST_LOOT_TABLES.length];

        for (int i = 0; i < CHEST_LOOT_TABLES.length; i++) {
            lootTableIds[i] = new Identifier("minecraft", "chests/" + CHEST_LOOT_TABLES[i]);
        }

        LootTableLoadingCallback.EVENT.register((resourceManager, loot, id, table, setter) -> {
                for (Identifier lootTableId : lootTableIds) {
                    if (lootTableId.equals(id)) {
                        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .withRolls(UniformLootTableRange.between(0, 2)).withEntry(
                            ItemEntry.builder(ItemRegistry.STEEL_NUGGET).setWeight(3)
                            .withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(6, 12)))
                        ).withEntry(
                            ItemEntry.builder(ItemRegistry.STEEL_INGOT).setWeight(1)
                            .withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1, 3)))
                        );

                        table.withPool(poolBuilder);
                    }
                }
            }
        );
    }
}