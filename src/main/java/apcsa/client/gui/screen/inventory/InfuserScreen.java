package apcsa.client.gui.screen.inventory;

import apcsa.client.gui.recipebook.InfuserRecipeGui;
import apcsa.inventory.container.InfuserContainer;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class InfuserScreen extends AbstractFurnaceScreen<InfuserContainer> {
    private static final ResourceLocation field_214092_l = new ResourceLocation("textures/gui/container/blast_furnace.png");

    public InfuserScreen(InfuserContainer p_i51101_1_, PlayerInventory p_i51101_2_, ITextComponent p_i51101_3_) {
        super(p_i51101_1_, new InfuserRecipeGui(), p_i51101_2_, p_i51101_3_, field_214092_l);
    }
}
