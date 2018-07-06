package git.jackwisdom.pangufarming.blocks;

import cn.mccraft.pangu.core.loader.AutoWired;
import cn.mccraft.pangu.core.loader.Registering;
import cn.mccraft.pangu.core.loader.annotation.RegBlock;

import cn.mccraft.pangu.core.loader.creativetabs.SharedCreativeTab;
import git.jackwisdom.pangufarming.PanguFarming;
import git.jackwisdom.pangufarming.blocks.crop.Millet;
import git.jackwisdom.pangufarming.blocks.crop.Paddy;
import git.jackwisdom.pangufarming.blocks.crop.SoyBean;
import git.jackwisdom.pangufarming.items.seed.MilletSeed;
import git.jackwisdom.pangufarming.items.seed.PaddySeed;
import git.jackwisdom.pangufarming.items.seed.SoyBeanSeed;

@AutoWired
@Registering(PanguFarming.MODID)
@SharedCreativeTab("tools")
public interface Blocks {
    @RegBlock(itemClass = PaddySeed.class)
    public static final Paddy paddy =new Paddy();
    @RegBlock(itemClass = MilletSeed.class)
    public static final Millet millet=new Millet();
    @RegBlock(itemClass = SoyBeanSeed.class)
    public static final SoyBean soybean=new SoyBean();
}
