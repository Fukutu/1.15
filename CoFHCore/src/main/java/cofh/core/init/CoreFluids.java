package cofh.core.init;

import cofh.core.fluid.ExperienceFluid;
import cofh.core.fluid.PotionFluid;

public class CoreFluids {

    private CoreFluids() {

    }

    public static void register() {

        ExperienceFluid.create();
        PotionFluid.create();
    }

}