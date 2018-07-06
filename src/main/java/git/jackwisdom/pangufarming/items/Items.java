package git.jackwisdom.pangufarming.items;

import cn.mccraft.pangu.core.loader.AutoWired;
import cn.mccraft.pangu.core.loader.Registering;
import cn.mccraft.pangu.core.loader.annotation.RegItem;

import cn.mccraft.pangu.core.loader.creativetabs.SharedCreativeTab;
import git.jackwisdom.pangufarming.PanguFarming;
import git.jackwisdom.pangufarming.blocks.Blocks;

import git.jackwisdom.pangufarming.items.food.Rice;
import git.jackwisdom.pangufarming.items.food.ToFu;
import git.jackwisdom.pangufarming.items.seed.PaddySeed;
import net.minecraft.item.Item;
@AutoWired
@Registering(PanguFarming.MODID)
@SharedCreativeTab("tools")
public interface Items {
    @RegItem
    public static final ToFu tofu=new ToFu();
    @RegItem
    public static final Rice rice=new Rice();

}
