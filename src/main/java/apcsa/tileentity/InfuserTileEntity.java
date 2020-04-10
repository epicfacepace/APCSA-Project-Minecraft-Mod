package apcsa.tileentity;

import apcsa.inventory.container.InfuserContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import static apcsa.block.ModBlock.INFUSER_TILE;

public class InfuserTileEntity extends AbstractFurnaceTileEntity {

    public InfuserTileEntity() {
        super(INFUSER_TILE, IRecipeType.BLASTING);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.infuser");
    }

    protected int getBurnTime(ItemStack p_213997_1_) {
        return super.getBurnTime(p_213997_1_) / 2;
    }

    protected Container createMenu(int id, PlayerInventory player) {
        return new InfuserContainer(id, player, this, this.furnaceData);
    }
}
