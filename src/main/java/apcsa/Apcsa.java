package apcsa;

import apcsa.blocks.TransporiteOre;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import apcsa.blocks.Infuser;
import apcsa.blocks.ModBlocks;
import apcsa.blocks.TransporiteBlock;
import apcsa.items.TransporiteMagnet;
import apcsa.items.TransporitePlates;
import apcsa.items.TransporiteShards;
import apcsa.items.Wrench;

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
            event.getRegistry().register(new BlockItem(ModBlocks.TRANSPORITE_BLOCK, building_blocks).setRegistryName("transporite_block"));
            event.getRegistry().register(new BlockItem(ModBlocks.TRANSPORITE_ORE, building_blocks).setRegistryName("transporite_ore"));
            event.getRegistry().register(new BlockItem(ModBlocks.INFUSER, decorations).setRegistryName("infuser"));
            event.getRegistry().register(new TransporiteShards());
            event.getRegistry().register(new TransporitePlates());
            event.getRegistry().register(new Wrench());
            event.getRegistry().register(new TransporiteMagnet());
        }
    }
}
