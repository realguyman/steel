package io.github.realguyman.steel.registries;

import io.github.realguyman.steel.Initializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    public static final Block STEEL_BLOCK = new Block(
        FabricBlockSettings.of(Material.METAL)
        .strength(5, 6)
        .sounds(BlockSoundGroup.METAL)
        .breakByTool(FabricToolTags.PICKAXES, 2)
    );
    
    public static void register() {
        Registry.register(
            Registry.BLOCK,
            new Identifier(Initializer.MOD_ID, "steel_block"),
            STEEL_BLOCK
        );
    }
}