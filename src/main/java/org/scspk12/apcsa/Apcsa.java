package org.scspk12.apcsa;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.scspk12.apcsa.blocks.ModBlocks;
import org.scspk12.apcsa.blocks.TransporiteBlock;
import org.scspk12.apcsa.blocks.TransporiteOre;
import org.scspk12.apcsa.items.TransporiteMagnet;
import org.scspk12.apcsa.items.TransporitePlates;
import org.scspk12.apcsa.items.TransporiteShards;
import org.scspk12.apcsa.items.Wrench;
import org.scspk12.apcsa.setup.ModSetup;

import java.util.stream.Collectors;

@Mod("apcsa")
public class Apcsa {
    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public Apcsa() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new TransporiteBlock());
            event.getRegistry().register(new TransporiteOre());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
            event.getRegistry().register(new BlockItem(ModBlocks.TRANSPORITE_BLOCK, properties).setRegistryName("transporite_block"));
            event.getRegistry().register(new BlockItem(ModBlocks.TRANSPORITE_ORE, properties).setRegistryName("transporite_ore"));
            event.getRegistry().register(new TransporiteShards());
            event.getRegistry().register(new TransporitePlates());
            event.getRegistry().register(new Wrench());
            event.getRegistry().register(new TransporiteMagnet());
        }
    }
}
