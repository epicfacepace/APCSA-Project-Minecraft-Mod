package apcsa;

import apcsa.block.TransporiteOre;
import apcsa.inventory.container.AbstractInfuserContainer;
import apcsa.inventory.container.InfuserContainer;
import apcsa.item.*;
import apcsa.item.crafting.InfuserRecipe;
import apcsa.item.crafting.ModCookingRecipeSerializer;
import apcsa.setup.ClientProxy;
import apcsa.setup.ModSetup;
import apcsa.tileentity.InfuserTileEntity;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import apcsa.block.Infuser;
import apcsa.block.ModBlock;
import apcsa.block.TransporiteBlock;

@Mod("apcsa")
public class Apcsa {

    public static ModSetup setup = new ModSetup();
    public static ClientProxy proxy = new ClientProxy();

    public Apcsa() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

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
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(InfuserTileEntity::new, ModBlock.INFUSER).build(null).setRegistryName("infuser"));
        }

        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                return new InfuserContainer(windowId, inv);
            }).setRegistryName("infuser"));
        }

        @SubscribeEvent
        public static void onRecipeRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            event.getRegistry().register(new ModCookingRecipeSerializer<>(InfuserRecipe::new, 200).setRegistryName("infusing"));
        }
    }
}
