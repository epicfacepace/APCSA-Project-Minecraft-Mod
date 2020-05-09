package apcsa;

import apcsa.block.TransporiteOre;
import apcsa.item.*;
import apcsa.world.gen.TransporiteOreGen;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import apcsa.block.ModBlock;
import apcsa.block.TransporiteBlock;

@Mod("apcsa")
public class Apcsa {

    public Apcsa() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
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
            Item.Properties building_blocks = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
            event.getRegistry().register(new BlockItem(ModBlock.TRANSPORITE_BLOCK, building_blocks).setRegistryName("transporite_block"));
            event.getRegistry().register(new BlockItem(ModBlock.TRANSPORITE_ORE, building_blocks).setRegistryName("transporite_ore"));
            event.getRegistry().register(new TransporiteShards());
            event.getRegistry().register(new TransporitePlates());
            event.getRegistry().register(new WrenchItem());
            event.getRegistry().register(new TransporiteMagnet());
            event.getRegistry().register(new SwordItem(ModItemTier.TRANSPORITE, 3, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName("transporite_sword"));
            event.getRegistry().register(new PickaxeItem(ModItemTier.TRANSPORITE, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName("transporite_pickaxe"));
            event.getRegistry().register(new ShovelItem(ModItemTier.TRANSPORITE, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName("transporite_shovel"));
            event.getRegistry().register(new AxeItem(ModItemTier.TRANSPORITE, 5.0F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName("transporite_axe"));
            event.getRegistry().register(new HoeItem(ModItemTier.TRANSPORITE, 0.0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName("transporite_hoe"));
            event.getRegistry().register(new ArmorItem(ModArmorMaterial.TRANSPORITE, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName("transporite_helmet"));
            event.getRegistry().register(new ArmorItem(ModArmorMaterial.TRANSPORITE, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName("transporite_chestplate"));
            event.getRegistry().register(new ArmorItem(ModArmorMaterial.TRANSPORITE, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName("transporite_leggings"));
            event.getRegistry().register(new ArmorItem(ModArmorMaterial.TRANSPORITE, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName("transporite_boots"));
        }

        @SubscribeEvent
        public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
            TransporiteOreGen.generateOre();
        }
    }
}
