package apcsa;

import apcsa.block.TransporiteOre;
import apcsa.inventory.container.InfuserContainer;
import apcsa.tileentity.InfuserTileEntity;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import apcsa.block.Infuser;
import apcsa.block.ModBlock;
import apcsa.block.TransporiteBlock;
import apcsa.item.TransporiteMagnet;
import apcsa.item.TransporitePlates;
import apcsa.item.TransporiteShards;
import apcsa.item.Wrench;

@Mod("apcsa")
public class Apcsa {

    private static final Logger LOGGER = LogManager.getLogger();

    public Apcsa() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new TransporiteBlock());
            event.getRegistry().register(new TransporiteOre());
            event.getRegistry().register(new Infuser());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties building_blocks = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
            Item.Properties decorations = new Item.Properties().group(ItemGroup.DECORATIONS);
            event.getRegistry().register(new BlockItem(ModBlock.TRANSPORITE_BLOCK, building_blocks).setRegistryName("transporite_block"));
            event.getRegistry().register(new BlockItem(ModBlock.TRANSPORITE_ORE, building_blocks).setRegistryName("transporite_ore"));
            event.getRegistry().register(new BlockItem(ModBlock.INFUSER, decorations).setRegistryName("infuser"));
            event.getRegistry().register(new TransporiteShards());
            event.getRegistry().register(new TransporitePlates());
            event.getRegistry().register(new Wrench());
            event.getRegistry().register(new TransporiteMagnet());
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(InfuserTileEntity::new, ModBlock.INFUSER).build(null).setRegistryName("infuser"));
        }

        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                return new InfuserContainer(windowId, inv);
            }).setRegistryName("infuser"));
        }
    }
}
