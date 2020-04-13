package apcsa.client.gui.screen.inventory;

import apcsa.inventory.container.AbstractInfuserContainer;
import net.minecraft.client.gui.recipebook.BlastFurnaceRecipeGui;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class InfuserScreen extends AbstractInfuserScreen<AbstractInfuserContainer> {
    private static final ResourceLocation field_214092_l = new ResourceLocation("textures/gui/container/blast_furnace.png");

    public InfuserScreen(AbstractInfuserContainer p_i51101_1_, PlayerInventory p_i51101_2_, ITextComponent p_i51101_3_) {
        super(p_i51101_1_, p_i51101_2_, p_i51101_3_, field_214092_l);
    }
}
