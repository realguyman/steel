package io.github.realguyman.steel;

import io.github.realguyman.steel.registries.BlockRegistry;
import io.github.realguyman.steel.registries.ItemRegistry;
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

        Identifier chestLootTableIdentifiers[] = new Identifier[CHEST_LOOT_TABLES.length];

        for (int i = 0; i < CHEST_LOOT_TABLES.length; i++) {
            chestLootTableIdentifiers[i] = new Identifier("minecraft:chests/" + CHEST_LOOT_TABLES[i]);
        }

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            for (Identifier chestLootTableIdentifier : chestLootTableIdentifiers) {
                if (chestLootTableIdentifier.equals(id)) {
                    table.withPool(
                        FabricLootPoolBuilder.builder()
                        .withRolls(UniformLootTableRange.between(0, 2))
                        .withEntry(
                            ItemEntry.builder(ItemRegistry.STEEL_INGOT)
                            .withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1, 3)))
                        ).withEntry(
                            ItemEntry.builder(ItemRegistry.STEEL_NUGGET)
                            .withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(3, 9)))
                        )
                    );
                }
            }
        });
    }
}