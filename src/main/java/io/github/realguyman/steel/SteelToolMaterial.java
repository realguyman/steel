package io.github.realguyman.steel;

import io.github.realguyman.steel.registry.ItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SteelToolMaterial implements ToolMaterial {
    public static final SteelToolMaterial INSTANCE = new SteelToolMaterial();

    @Override
    public int getDurability() {
        return Configuration.toolDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return Configuration.toolMiningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return Configuration.baseAttackDamage;
    }

    @Override
    public int getMiningLevel() {
        return Configuration.toolMiningLevel;
    }

    @Override
    public int getEnchantability() {
        return Configuration.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.STEEL_INGOT);
    }
}