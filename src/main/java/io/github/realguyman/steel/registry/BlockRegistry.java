package io.github.realguyman.steel.registry;

import io.github.realguyman.steel.Initializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    public static final Block STEEL_BLOCK = new Block(
        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).breakByTool(FabricToolTags.PICKAXES, 2)
    );

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(Initializer.MOD_ID, "steel_block"), STEEL_BLOCK);
    }
}