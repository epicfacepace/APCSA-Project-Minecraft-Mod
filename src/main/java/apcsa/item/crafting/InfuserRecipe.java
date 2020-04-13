package apcsa.item.crafting;

import apcsa.block.ModBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class InfuserRecipe extends AbstractModCookingRecipe {
    public InfuserRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
        super(IRecipeType.CRAFTING, idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
    }

    public ItemStack getIcon() {
        return new ItemStack(ModBlock.INFUSER);
    }

    public IRecipeSerializer<?> getSerializer() {
        return ModBlock.INFUSING;
    }
}
