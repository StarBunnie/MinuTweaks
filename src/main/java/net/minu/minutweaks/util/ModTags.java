package net.minu.minutweaks.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minu.minutweaks.MinuTweaks;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ZEPHYRITE_BLOCKS = tag("zephyrite_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MinuTweaks.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ZEPHYRITE_ITEMS = tag("zephyrite_items");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MinuTweaks.MOD_ID, name));
        }
    }
}
