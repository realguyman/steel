package io.github.realguyman.steel;

import io.github.realguyman.steel.registry.ItemRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class SteelArmorMaterial implements ArmorMaterial {
    private static final int[] DURABILITY = {13, 15, 16, 11};
    private static final int[] PROTECTION = {
            Configuration.helmetArmorRating,
            Configuration.leggingsArmorRating,
            Configuration.chestplateArmorRating,
            Configuration.bootsArmorRating
    };

    public static final SteelArmorMaterial INSTANCE = new SteelArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return DURABILITY[slot.getEntitySlotId()] * Configuration.armorBaseDurabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return Configuration.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.STEEL_INGOT);
    }

    @Override
    public String getName() {
        return "steel";
    }

    @Override
    public float getToughness() {
        return Configuration.armorToughness;
    }

    @Override
    public float getKnockbackResistance() {
        return Configuration.armorKnockbackResistance;
    }
}