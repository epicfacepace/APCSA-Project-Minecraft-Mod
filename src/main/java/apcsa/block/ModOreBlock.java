package apcsa.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class ModOreBlock extends Block {
    public ModOreBlock(Properties properties) {
        super(properties);
    }

    protected int func_220281_a(Random p_220281_1_) {
        if (this == ModBlock.TRANSPORITE_ORE) {
            return MathHelper.nextInt(p_220281_1_, 5, 10);
        } else {
            return 0;
        }
    }

    public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
    }

    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.func_220281_a(this.RANDOM) : 0;
    }
}