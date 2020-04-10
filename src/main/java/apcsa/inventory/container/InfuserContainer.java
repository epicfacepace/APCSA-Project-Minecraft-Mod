package apcsa.inventory.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;

import static apcsa.block.ModBlock.INFUSER_CONTAINER;

public class InfuserContainer extends AbstractFurnaceContainer {
    public InfuserContainer(int p_i50097_1_, PlayerInventory p_i50097_2_) {
        super(INFUSER_CONTAINER, IRecipeType.BLASTING, p_i50097_1_, p_i50097_2_);
    }

    public InfuserContainer(int p_i50098_1_, PlayerInventory p_i50098_2_, IInventory p_i50098_3_, IIntArray p_i50098_4_) {
        super(INFUSER_CONTAINER, IRecipeType.BLASTING, p_i50098_1_, p_i50098_2_, p_i50098_3_, p_i50098_4_);
    }
}
