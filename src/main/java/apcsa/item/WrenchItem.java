package apcsa.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import static net.minecraft.util.Direction.*;

public class WrenchItem extends Item {

    public WrenchItem() {
        super(new Item.Properties()
                .group(ItemGroup.TOOLS)
                .maxStackSize(1)
                .maxDamage(256)
        );
        setRegistryName("wrench");
    }

    public static final Direction[] DIRECTIONS = { NORTH, EAST, Direction.SOUTH, WEST, Direction.UP, Direction.DOWN };

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        PlayerEntity playerentity = context.getPlayer();
        int x = blockpos.getX();
        int y = blockpos.getY();
        int z = blockpos.getZ();
        try {
            BlockState blockState = world.getBlockState(new BlockPos(x, y, z));
            world.setBlockState(new BlockPos(x, y, z),
                    blockState.with((DirectionProperty) blockState.getBlock().getStateContainer().getProperty("facing"), (wrenchRotate(new Object() {
                        public Direction getDirection(BlockPos pos) {
                            try {
                                BlockState blockState1 = world.getBlockState(pos);
                                DirectionProperty property = (DirectionProperty) blockState1.getBlock().getStateContainer().getProperty("facing");
                                return blockState1.get(property);
                            } catch (Exception e) {
                                return NORTH;
                            }
                        }
                    }.getDirection(new BlockPos(x, y, z))))), 3);
            context.getItem().damageItem(1, playerentity, (p_219999_1_) -> {
                p_219999_1_.sendBreakAnimation(context.getHand());
            });
        } catch (Exception e) {
        }
        return ActionResultType.SUCCESS;
    }

    public Direction wrenchRotate(Direction direction) {
        switch(direction) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            default:
                throw new IllegalStateException("Unable to get wrench-rotated facing of " + this);
        }
    }
}