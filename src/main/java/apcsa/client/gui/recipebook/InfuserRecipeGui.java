package apcsa.client.gui.recipebook;

import net.minecraft.client.gui.recipebook.AbstractRecipeBookGui;
import net.minecraft.item.Item;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;

import java.util.Set;

public class InfuserRecipeGui extends AbstractRecipeBookGui {
    protected boolean func_212962_b() {
        return this.recipeBook.func_216761_f();
    }

    protected void func_212959_a(boolean p_212959_1_) {
        this.recipeBook.func_216756_f(p_212959_1_);
    }

    protected boolean func_212963_d() {
        return this.recipeBook.func_216758_e();
    }

    protected void func_212957_c(boolean p_212957_1_) {
        this.recipeBook.func_216755_e(p_212957_1_);
    }

    protected String func_212960_g() {
        return "gui.recipebook.toggleRecipes.blastable";
    }

    protected Set<Item> func_212958_h() {
        return AbstractFurnaceTileEntity.getBurnTimes().keySet();
    }
}
