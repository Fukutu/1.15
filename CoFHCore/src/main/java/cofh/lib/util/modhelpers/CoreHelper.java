package cofh.lib.util.modhelpers;

import net.minecraft.block.Block;
import net.minecraft.potion.Effect;
import net.minecraftforge.registries.ObjectHolder;

import static cofh.lib.util.constants.Constants.ID_COFH_CORE;

public class CoreHelper {

    private CoreHelper() {

    }

    // region BLOCKS
    public static final String ID_COOLED_MAGMA = ID_COFH_CORE + ":cooled_magma";

    @ObjectHolder(ID_COOLED_MAGMA)
    public static final Block COOLED_MAGMA = null;
    // endregion

    // region EFFECTS
    public static final String ID_ENDERFERENCE = ID_COFH_CORE + ":enderference";

    @ObjectHolder(ID_ENDERFERENCE)
    public static final Effect ENDERFERENCE = null;
    // endregion
}