package git.jackwisdom.pangufarming.items.seed;

import net.minecraft.block.Block;

public class CornSeed extends PaddySeed {
    public CornSeed(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        //meta 0|corn
        //meta 1|sorghum
    }
}
