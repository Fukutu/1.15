package cofh.thermal.core.data;

import cofh.lib.data.BlockStateProviderCoFH;
import cofh.lib.registries.DeferredRegisterCoFH;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.init.TCoreReferences.*;

public class TCoreBlockStates extends BlockStateProviderCoFH {

    public TCoreBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {

        super(gen, ID_THERMAL, exFileHelper);
    }

    @Override
    public String getName() {

        return "Thermal Core: BlockStates";
    }

    @Override
    protected void registerStatesAndModels() {

        DeferredRegisterCoFH<Block> reg = BLOCKS;

        storageBlock(reg.getSup(ID_CHARCOAL_BLOCK));
        axisBlock(reg.getSup(ID_BAMBOO_BLOCK), "bamboo_block", STORAGE);
        axisBlock(reg.getSup(ID_SUGAR_CANE_BLOCK), "sugar_cane_block", STORAGE);
        storageBlock(reg.getSup(ID_GUNPOWDER_BLOCK));

        oreBlock(reg.getSup(ID_APATITE_ORE));
        oreBlock(reg.getSup(ID_CINNABAR_ORE));
        oreBlock(reg.getSup(ID_NITER_ORE));
        oreBlock(reg.getSup(ID_SULFUR_ORE));

        storageBlock(reg.getSup(ID_APATITE_BLOCK));
        storageBlock(reg.getSup(ID_CINNABAR_BLOCK));
        storageBlock(reg.getSup(ID_NITER_BLOCK));
        storageBlock(reg.getSup(ID_SULFUR_BLOCK));

        storageBlock(reg.getSup(ID_SIGNALUM_BLOCK));
        storageBlock(reg.getSup(ID_LUMIUM_BLOCK));
        storageBlock(reg.getSup(ID_ENDERIUM_BLOCK));

        glassBlock(reg.getSup(ID_SIGNALUM_GLASS));
        glassBlock(reg.getSup(ID_LUMIUM_GLASS));
        glassBlock(reg.getSup(ID_ENDERIUM_GLASS));
    }

}
