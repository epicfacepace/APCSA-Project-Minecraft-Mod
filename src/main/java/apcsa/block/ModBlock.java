package apcsa.block;

import apcsa.inventory.container.InfuserContainer;
import apcsa.tileentity.InfuserTileEntity;
import net.minecraft.inventory.container.ContainerType;
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
}
