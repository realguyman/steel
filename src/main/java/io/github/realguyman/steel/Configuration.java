package io.github.realguyman.steel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Configuration {
    private static final Path filePath = FabricLoader.getInstance().getConfigDir().resolve(Initializer.MOD_ID + ".json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static int helmetArmorRating = 2;
    public static int chestplateArmorRating = 6;
    public static int leggingsArmorRating = 5;
    public static int bootsArmorRating = 2;
    public static int armorBaseDurabilityMultiplier = 25;
    public static int armorToughness = 1;
    public static int armorKnockbackResistance = 0;
    public static int enchantability = 15;
    public static int toolDurability = 417;
    public static int toolMiningLevel = 2;
    public static float toolMiningSpeed = 6.5F;
    public static float baseAttackDamage = 2.0F;
    public static int swordAttackDamage = 3;
    public static float axeAttackDamage = 6.0F;

    public static void load() {
        if (filePath.toFile().exists()) {
            try {
                Reader reader = Files.newBufferedReader(filePath);
                Data data = gson.fromJson(reader, Data.class);

                helmetArmorRating = data.helmetArmorRating;
                chestplateArmorRating = data.chestplateArmorRating;
                leggingsArmorRating = data.leggingsArmorRating;
                bootsArmorRating = data.bootsArmorRating;
                armorBaseDurabilityMultiplier = data.armorBaseDurabilityMultiplier;
                armorToughness = data.armorToughness;
                armorKnockbackResistance = data.armorKnockbackResistance;
                enchantability = data.enchantability;
                toolDurability = data.toolDurability;
                toolMiningLevel = data.toolMiningLevel;
                toolMiningSpeed = data.toolMiningSpeed;
                baseAttackDamage = data.baseAttackDamage;
                swordAttackDamage = data.swordAttackDamage;
                axeAttackDamage = data.axeAttackDamage;

                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Could not read configuration file due to: " + e);
            }
        } else {
            save();
        }
    }

    public static void save() {
        try {
            Writer writer = Files.newBufferedWriter(filePath);
            gson.toJson(new Data(
                    2,
                    6,
                    5,
                    2,
                    25,
                    1,
                    0,
                    15,
                    417,
                    2,
                    6.5F,
                    2.0F,
                    3,
                    6.0F
            ), writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file due to: " + e);
        }
    }

    private static class Data {
        private final String helmetArmorRatingComment = "Armor points applied to steel helmet.";
        private final int helmetArmorRating;

        private final String chestplateArmorRatingComment = "Armor points applied to steel chestplate.";
        private final int chestplateArmorRating;

        private final String leggingsArmorRatingComment = "Armor points applied to steel leggings.";
        private final int leggingsArmorRating;

        private final String bootsArmorRatingComment = "Armor points applied to steel boots.";
        private final int bootsArmorRating;

        private final String armorBaseDurabilityMultiplierComment = "A multiplier to apply against the base durability of steel armor pieces. Must be a positive integer.";
        private final int armorBaseDurabilityMultiplier;

        private final String armorToughnessComment = "How much resistance against powerful one-hit attacks. Must be a positive integer.";
        private final int armorToughness;

        private final String armorKnockbackResistanceComment = "Must be a positive integer.";
        private final int armorKnockbackResistance;

        private final String enchantabilityComment = "Must be a positive integer.";
        private final int enchantability;

        private final String toolDurabilityComment = "Must be a positive integer.";
        private final int toolDurability;

        private final String toolMiningLevelComment = "For reference iron is 2. Must be a positive integer.";
        private final int toolMiningLevel;

        private final String toolMiningSpeedComment = "For reference iron is 6.0. Must be a float.";
        private final float toolMiningSpeed;

        private final String baseAttackDamageComment = "For reference iron is 2.0. Must be a float.";
        private final float baseAttackDamage;

        private final String swordAttackDamageComment = "For reference iron is 3. Must be a positive integer.";
        private final int swordAttackDamage;

        private final String axeAttackDamageComment = "For reference iron is 6.0. Must be a float.";
        private final float axeAttackDamage;

        private Data(int helmetArmorRating, int chestplateArmorRating, int leggingsArmorRating, int bootsArmorRating, int armorBaseDurabilityMultiplier, int armorToughness, int armorKnockbackResistance, int enchantability, int toolDurability, int toolMiningLevel, float toolMiningSpeed, float baseAttackDamage, int swordAttackDamage, float axeAttackDamage) {
            this.helmetArmorRating = helmetArmorRating;
            this.chestplateArmorRating = chestplateArmorRating;
            this.leggingsArmorRating = leggingsArmorRating;
            this.bootsArmorRating = bootsArmorRating;
            this.armorBaseDurabilityMultiplier = armorBaseDurabilityMultiplier;
            this.armorToughness = armorToughness;
            this.armorKnockbackResistance = armorKnockbackResistance;
            this.enchantability = enchantability;
            this.toolDurability = toolDurability;
            this.toolMiningLevel = toolMiningLevel;
            this.toolMiningSpeed = toolMiningSpeed;
            this.baseAttackDamage = baseAttackDamage;
            this.swordAttackDamage = swordAttackDamage;
            this.axeAttackDamage = axeAttackDamage;
        }
    }
}
