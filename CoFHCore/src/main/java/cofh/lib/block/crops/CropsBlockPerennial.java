package cofh.lib.block.crops;

import cofh.lib.util.helpers.MathHelper;
import net.minecraft.state.IntegerProperty;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

import static cofh.lib.util.constants.Constants.AGE_PERENNIAL;

public class CropsBlockPerennial extends CropsBlockCoFH {

    public CropsBlockPerennial(Properties builder, PlantType type, int growLight, float growMod) {

        super(builder, type, growLight, growMod);
    }

    public CropsBlockPerennial(Properties builder, int growLight, float growMod) {

        super(builder, growLight, growMod);
    }

    public CropsBlockPerennial(Properties builder) {

        super(builder);
        growMod = 0.25F;
    }

    @Override
    public IntegerProperty getAgeProperty() {

        return AGE_PERENNIAL;
    }

    @Override
    protected int getMaximumAge() {

        return 10;
    }

    @Override
    protected int getPostHarvestAge() {

        return 8;
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {

        return MathHelper.nextInt(worldIn.rand, 1, 3);
    }

}
