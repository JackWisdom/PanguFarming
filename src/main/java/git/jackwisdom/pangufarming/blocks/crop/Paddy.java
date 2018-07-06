package git.jackwisdom.pangufarming.blocks.crop;

import git.jackwisdom.pangufarming.items.Items;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;

import net.minecraft.block.BlockFarmland;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Paddy extends BlockCarrot {
    public Paddy(){

    }
    @Override
    public Item getSeed(){
     return Item.getItemFromBlock(this);
 }
    @Override
    public Item getCrop(){
        return Item.getItemFromBlock(this);
    }
    @Override
    public int getMaxAge()
    {
        return 3;
    }


}
