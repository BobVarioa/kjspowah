package com.bobvarioa.kubejspowah;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface EnergizingOrbRecipe {
    RecipeKey<List<Ingredient>> INPUTS = IngredientComponent.INGREDIENT.instance().asList().key("ingredients", ComponentRole.INPUT);
    RecipeKey<Long> ENERGY = NumberComponent.LONG.key("energy", ComponentRole.INPUT);
    RecipeKey<ItemStack> OUTPUT = ItemStackComponent.ITEM_STACK.key("result", ComponentRole.OUTPUT);

    RecipeSchema SCHEMA = new RecipeSchema(INPUTS, OUTPUT, ENERGY);
}
