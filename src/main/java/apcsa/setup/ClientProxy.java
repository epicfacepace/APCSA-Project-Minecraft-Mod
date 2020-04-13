package apcsa.setup;

import apcsa.block.ModBlock;
import apcsa.client.gui.screen.inventory.InfuserScreen;
import apcsa.item.crafting.InfuserRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.world.World;

public class ClientProxy {
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }

    public static void init() {
        ScreenManager.registerFactory(ModBlock.INFUSER_CONTAINER, InfuserScreen::new);
    }
}
