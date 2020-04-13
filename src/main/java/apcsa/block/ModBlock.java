package apcsa.block;

import apcsa.inventory.container.AbstractInfuserContainer;
import apcsa.inventory.container.InfuserContainer;
import apcsa.item.crafting.InfuserRecipe;
import apcsa.item.crafting.ModCookingRecipeSerializer;
import apcsa.tileentity.InfuserTileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;


public class ModBlock {
    @ObjectHolder("apcsa:transporite_block")
    public static TransporiteBlock TRANSPORITE_BLOCK;
    @ObjectHolder("apcsa:transporite_ore")
    public static TransporiteOre TRANSPORITE_ORE;
    @ObjectHolder("apcsa:infuser")
    public static Infuser INFUSER;
    @ObjectHolder("apcsa:infuser")
    public static TileEntityType<InfuserTileEntity> INFUSER_TILE;
    @ObjectHolder("apcsa:infuser")
    public static ContainerType<InfuserContainer> INFUSER_CONTAINER;
    @ObjectHolder("apcsa:infuser")
    public static ModCookingRecipeSerializer<InfuserRecipe> INFUSING;
}
