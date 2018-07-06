package git.jackwisdom.pangufarming.blocks.crop;

import net.minecraft.item.Item;

public class SoyBean extends  Paddy{
    @Override
    public Item getSeed(){
        return Item.getItemFromBlock(this);
    }
    @Override
    public Item getCrop(){
        return Item.getItemFromBlock(this);
    }
}
