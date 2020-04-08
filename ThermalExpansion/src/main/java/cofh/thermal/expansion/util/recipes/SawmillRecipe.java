package cofh.thermal.expansion.util.recipes;

import cofh.thermal.core.util.recipes.ThermalRecipe;
import cofh.thermal.expansion.init.TExpRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;

import static cofh.thermal.core.ThermalCore.RECIPE_SERIALIZERS;
import static cofh.thermal.expansion.init.TExpReferences.ID_RECIPE_SAWMILL;
import static cofh.thermal.expansion.init.TExpReferences.MACHINE_SAWMILL_BLOCK;

public class SawmillRecipe extends ThermalRecipe {

    public SawmillRecipe(ResourceLocation recipeId, int energy, float experience, List<Ingredient> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> outputItemChances, List<FluidStack> outputFluids) {

        super(recipeId, energy, experience, inputItems, inputFluids, outputItems, outputItemChances, outputFluids);
    }

    @Nonnull
    @Override
    public IRecipeSerializer<?> getSerializer() {

        return RECIPE_SERIALIZERS.get(ID_RECIPE_SAWMILL);
    }

    @Nonnull
    @Override
    public IRecipeType<?> getType() {

        return TExpRecipes.RECIPE_SAWMILL;
    }

    @Nonnull
    @Override
    public String getGroup() {

        return MACHINE_SAWMILL_BLOCK.getTranslationKey();
    }

    @Nonnull
    @Override
    public ItemStack getIcon() {

        return new ItemStack(MACHINE_SAWMILL_BLOCK);
    }

}