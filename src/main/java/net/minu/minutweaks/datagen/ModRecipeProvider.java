package net.minu.minutweaks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minu.minutweaks.MinuTweaks;
import net.minu.minutweaks.block.ModBlocks;
import net.minu.minutweaks.item.ModItems;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> ZEPHYRITE_SMELTABLES = List.of(
            ModItems.ZEPHYRITE.get(),
            ModBlocks.ZEPHYRITE_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBlasting(consumer, ZEPHYRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ZEPHYRITE.get(), 0.75f, 200, "zephyrite");
        oreSmelting(consumer, ZEPHYRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ZEPHYRITE.get(), 0.75f, 300, "zephyrite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZEPHYRITE_ORE.get())
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .define('#', ModItems.ZEPHYRITE.get())
                .define('D', Items.DEEPSLATE)
                .unlockedBy(getHasName(ModItems.ZEPHYRITE.get()), has(ModItems.ZEPHYRITE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZEPHYRITE.get(), 999)
                .requires(ModBlocks.ZEPHYRITE_ORE.get())
                .unlockedBy(getHasName(ModBlocks.ZEPHYRITE_ORE.get()), has(ModBlocks.ZEPHYRITE_ORE.get()))
                .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, MinuTweaks.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
