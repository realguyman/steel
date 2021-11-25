package io.github.realguyman.steel;

import io.github.realguyman.steel.registry.ItemRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class SteelArmorMaterial implements ArmorMaterial {
    private static final int[] DURABILITY = {13, 15, 16, 11};
    private static final int[] PROTECTION = {2, 5, 7, 2};
    
    public static final SteelArmorMaterial INSTANCE = new SteelArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return DURABILITY[slot.getEntitySlotId()] * 25;
    }
    
    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
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
        return 1;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}