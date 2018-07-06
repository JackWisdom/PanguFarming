package git.jackwisdom.pangufarming.blocks;

import cn.mccraft.pangu.core.loader.AutoWired;
import cn.mccraft.pangu.core.loader.Registering;
import cn.mccraft.pangu.core.loader.annotation.RegBlock;

import cn.mccraft.pangu.core.loader.creativetabs.SharedCreativeTab;
import git.jackwisdom.pangufarming.PanguFarming;
import git.jackwisdom.pangufarming.items.seed.PaddySeed;

@AutoWired
@Registering(PanguFarming.MODID)
@SharedCreativeTab("tools")
public interface Blocks {

    @RegBlock(value = "paddy",itemClass = PaddySeed.class)
    public static final Paddy paddy =new Paddy();
}
