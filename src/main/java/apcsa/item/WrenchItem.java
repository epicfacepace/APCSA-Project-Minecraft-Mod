package apcsa.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class WrenchItem extends Item {
    public WrenchItem(Item.Properties builder) { super(builder); }

    public static final Direction[] DIRECTIONS = { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN };

    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        Direction direction = context.getFace();
        int x = blockpos.getX();
        int y = blockpos.getY();
        int z = blockpos.getZ();
        ItemStack itemstack = context.getItem();
        BlockState blockstate = world.getBlockState(blockpos);
        if (isValidBlock(world.getBlockState(blockpos), world, blockpos)) {
            // TODO Rotate the block
            // world.setBlockState(blockpos, );
            // TODO Damage the wrench
            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.FAIL;
        }
    }

    public static boolean isValidBlock(BlockState blockstate, IWorld world, BlockPos blockpos) {
        // TODO Check if block is rotatable by wrench
        return blockstate.isValidPosition(world, blockpos);
    }
}
