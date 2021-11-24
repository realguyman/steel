package io.github.realguyman.steel;

import io.github.realguyman.steel.registry.BlockRegistry;
import io.github.realguyman.steel.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.TradeOffers.Factory;

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
        new Identifier(MOD_ID, "general"),
        () -> new ItemStack(ItemRegistry.STEEL_INGOT)
    );

    @Override
    public void onInitialize() {
        ItemRegistry.register();
        BlockRegistry.register();

        Factory steelNuggetTrade = (entity, random) -> new TradeOffer(new ItemStack(ItemRegistry.STEEL_NUGGET, 11),
                new ItemStack(Items.EMERALD), 12, 10, 0.10F);

        Factory steelIngotTrade = (entity, random) -> new TradeOffer(new ItemStack(ItemRegistry.STEEL_INGOT, 4),
                new ItemStack(Items.EMERALD, 3), 12, 30, 0.15F);

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.add(steelNuggetTrade);

            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.STEEL_LEGGINGS), 6, 30, 0.2F));

            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 9),
                    new ItemStack(ItemRegistry.STEEL_BOOTS), 6, 30, 0.2F));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> {
            factories.add(steelIngotTrade);

            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ItemRegistry.STEEL_HELMET), 6, 30, 0.2F));

            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ItemRegistry.STEEL_CHESTPLATE), 6, 30, 0.2F));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2,
                factories -> factories.add(steelNuggetTrade));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> {
            factories.add(steelIngotTrade);

            factories.add((entity, random) -> {
                int i = 5 + random.nextInt(15);
                return new TradeOffer(new ItemStack(Items.EMERALD, Math.min(13 + i, 64)), EnchantmentHelper.enchant(
                        random, new ItemStack(ItemRegistry.STEEL_SHOVEL), 5 + random.nextInt(15), false), 3, 40, 0.2F);
            });

            factories.add((entity, random) -> {
                int i = 5 + random.nextInt(15);
                return new TradeOffer(new ItemStack(Items.EMERALD, Math.min(14 + i, 64)), EnchantmentHelper.enchant(
                        random, new ItemStack(ItemRegistry.STEEL_PICKAXE), 5 + random.nextInt(15), false), 3, 40, 0.2F);
            });

            factories.add((entity, random) -> {
                int i = 5 + random.nextInt(15);
                return new TradeOffer(new ItemStack(Items.EMERALD, Math.min(12 + i, 64)), EnchantmentHelper.enchant(
                        random, new ItemStack(ItemRegistry.STEEL_AXE), 5 + random.nextInt(15), false), 3, 40, 0.2F);
            });

            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ItemRegistry.STEEL_HOE), 3, 30, 0.2F));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
            factories.add(steelNuggetTrade);

            factories.add((entity, random) -> {
                int i = 5 + random.nextInt(15);
                return new TradeOffer(new ItemStack(Items.EMERALD, Math.min(13 + i, 64)), EnchantmentHelper.enchant(
                        random, new ItemStack(ItemRegistry.STEEL_SWORD), 5 + random.nextInt(15), false), 3, 40, 0.2F);
            });
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3,
                factories -> factories.add(steelIngotTrade));

        Identifier[] lootTables = new Identifier[CHEST_LOOT_TABLES.length];
        
        for (int i = 0; i < CHEST_LOOT_TABLES.length; i++) {
            lootTables[i] = new Identifier("minecraft", "chests/" + CHEST_LOOT_TABLES[i]);
        }

        LootTableLoadingCallback.EVENT.register((resourceManager, loot, id, table, setter) -> {
            if (id.equals(lootTables[3])) {
                table.withPool(
                    FabricLootPoolBuilder.builder().withRolls(
                        UniformLootTableRange.between(0, 3)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_SHOVEL)
                        .setWeight(3)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_PICKAXE)
                        .setWeight(3)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_AXE)
                        .setWeight(3)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_HOE)
                        .setWeight(3)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_SWORD)
                        .setWeight(3)
                        .withFunction (EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_HELMET)
                        .setWeight(2)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_CHESTPLATE)
                        .setWeight(1)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_LEGGINGS)
                        .setWeight(1)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_BOOTS)
                        .setWeight(2)
                        .withFunction(EnchantRandomlyLootFunction.builder())
                    )
                );
            }

            for (Identifier lootTable : lootTables) {
                if (lootTable.equals(id)) {
                    table.withPool(FabricLootPoolBuilder.builder()
                    .withRolls(UniformLootTableRange.between(0, 3))
                    .withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_NUGGET)
                        .setWeight(10)
                        .withFunction(SetCountLootFunction.builder(
                            UniformLootTableRange.between(4, 12)
                        ))
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_INGOT)
                        .setWeight(10)
                        .withFunction(SetCountLootFunction.builder(
                            UniformLootTableRange.between(1, 3)
                        ))
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_SHOVEL).setWeight(3)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_PICKAXE).setWeight(3)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_AXE).setWeight(3)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_HOE).setWeight(3)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_SWORD).setWeight(3)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_HELMET).setWeight(2)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_CHESTPLATE).setWeight(1)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_LEGGINGS).setWeight(1)
                    ).withEntry(
                        ItemEntry.builder(ItemRegistry.STEEL_BOOTS).setWeight(2)
                    ));

                    break;
                }
            }
        });
    }
}