package cofh.thermal.core.data;

import cofh.lib.util.references.CoFHTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.data.ItemTagsProvider;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.init.TCoreReferences.*;

public class TCoreTags {

    public static class Block extends BlockTagsProvider {

        public Block(DataGenerator dataGeneratorIn) {

            super(dataGeneratorIn);
        }

        @Override
        public String getName() {

            return "Thermal Core: Block Tags";
        }

        @Override
        protected void registerTags() {

            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_CHARCOAL).add(BLOCKS.get(ID_CHARCOAL_BLOCK));
            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_BAMBOO).add(BLOCKS.get(ID_BAMBOO_BLOCK));
            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE).add(BLOCKS.get(ID_SUGAR_CANE_BLOCK));

            getBuilder(CoFHTags.Blocks.ORES_APATITE).add(BLOCKS.get(ID_APATITE_ORE));
            getBuilder(CoFHTags.Blocks.ORES_CINNABAR).add(BLOCKS.get(ID_CINNABAR_ORE));
            getBuilder(CoFHTags.Blocks.ORES_NITER).add(BLOCKS.get(ID_NITER_ORE));
            getBuilder(CoFHTags.Blocks.ORES_SULFUR).add(BLOCKS.get(ID_SULFUR_ORE));

            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_APATITE).add(BLOCKS.get(ID_APATITE_BLOCK));
            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_CINNABAR).add(BLOCKS.get(ID_CINNABAR_BLOCK));
            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_NITER).add(BLOCKS.get(ID_NITER_BLOCK));
            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_SULFUR).add(BLOCKS.get(ID_SULFUR_BLOCK));

            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_SIGNALUM).add(BLOCKS.get(ID_SIGNALUM_BLOCK));
            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_LUMIUM).add(BLOCKS.get(ID_LUMIUM_BLOCK));
            getBuilder(CoFHTags.Blocks.STORAGE_BLOCKS_ENDERIUM).add(BLOCKS.get(ID_ENDERIUM_BLOCK));
        }

    }

    public static class Item extends ItemTagsProvider {

        public Item(DataGenerator dataGeneratorIn) {

            super(dataGeneratorIn);
        }

        @Override
        public String getName() {

            return "Thermal Core: Item Tags";
        }

        @Override
        protected void registerTags() {

            copy(CoFHTags.Blocks.STORAGE_BLOCKS_CHARCOAL, CoFHTags.Items.STORAGE_BLOCKS_CHARCOAL);
            copy(CoFHTags.Blocks.STORAGE_BLOCKS_BAMBOO, CoFHTags.Items.STORAGE_BLOCKS_BAMBOO);
            copy(CoFHTags.Blocks.STORAGE_BLOCKS_SUGAR_CANE, CoFHTags.Items.STORAGE_BLOCKS_SUGAR_CANE);

            copy(CoFHTags.Blocks.ORES_APATITE, CoFHTags.Items.ORES_APATITE);
            copy(CoFHTags.Blocks.ORES_CINNABAR, CoFHTags.Items.ORES_CINNABAR);
            copy(CoFHTags.Blocks.ORES_NITER, CoFHTags.Items.ORES_NITER);
            copy(CoFHTags.Blocks.ORES_SULFUR, CoFHTags.Items.ORES_SULFUR);

            copy(CoFHTags.Blocks.STORAGE_BLOCKS_APATITE, CoFHTags.Items.STORAGE_BLOCKS_APATITE);
            copy(CoFHTags.Blocks.STORAGE_BLOCKS_CINNABAR, CoFHTags.Items.STORAGE_BLOCKS_CINNABAR);
            copy(CoFHTags.Blocks.STORAGE_BLOCKS_NITER, CoFHTags.Items.STORAGE_BLOCKS_NITER);
            copy(CoFHTags.Blocks.STORAGE_BLOCKS_SULFUR, CoFHTags.Items.STORAGE_BLOCKS_SULFUR);

            copy(CoFHTags.Blocks.STORAGE_BLOCKS_SIGNALUM, CoFHTags.Items.STORAGE_BLOCKS_SIGNALUM);
            copy(CoFHTags.Blocks.STORAGE_BLOCKS_LUMIUM, CoFHTags.Items.STORAGE_BLOCKS_LUMIUM);
            copy(CoFHTags.Blocks.STORAGE_BLOCKS_ENDERIUM, CoFHTags.Items.STORAGE_BLOCKS_ENDERIUM);

            getBuilder(CoFHTags.Items.COINS_IRON).add(ITEMS.get("iron_coin"));
            getBuilder(CoFHTags.Items.COINS_GOLD).add(ITEMS.get("gold_coin"));

            getBuilder(CoFHTags.Items.DUSTS_IRON).add(ITEMS.get("iron_dust"));
            getBuilder(CoFHTags.Items.DUSTS_GOLD).add(ITEMS.get("gold_dust"));

            getBuilder(CoFHTags.Items.GEARS_IRON).add(ITEMS.get("iron_gear"));
            getBuilder(CoFHTags.Items.GEARS_GOLD).add(ITEMS.get("gold_gear"));

            getBuilder(CoFHTags.Items.PLATES_IRON).add(ITEMS.get("iron_plate"));
            getBuilder(CoFHTags.Items.PLATES_GOLD).add(ITEMS.get("gold_plate"));

            getBuilder(CoFHTags.Items.COINS_SIGNALUM).add(ITEMS.get("signalum_coin"));
            getBuilder(CoFHTags.Items.COINS_LUMIUM).add(ITEMS.get("lumium_coin"));
            getBuilder(CoFHTags.Items.COINS_ENDERIUM).add(ITEMS.get("enderium_coin"));

            getBuilder(CoFHTags.Items.DUSTS_SIGNALUM).add(ITEMS.get("signalum_dust"));
            getBuilder(CoFHTags.Items.DUSTS_LUMIUM).add(ITEMS.get("lumium_dust"));
            getBuilder(CoFHTags.Items.DUSTS_ENDERIUM).add(ITEMS.get("enderium_dust"));

            getBuilder(CoFHTags.Items.GEARS_SIGNALUM).add(ITEMS.get("signalum_gear"));
            getBuilder(CoFHTags.Items.GEARS_LUMIUM).add(ITEMS.get("lumium_gear"));
            getBuilder(CoFHTags.Items.GEARS_ENDERIUM).add(ITEMS.get("enderium_gear"));

            getBuilder(CoFHTags.Items.INGOTS_SIGNALUM).add(ITEMS.get("signalum_ingot"));
            getBuilder(CoFHTags.Items.INGOTS_LUMIUM).add(ITEMS.get("lumium_ingot"));
            getBuilder(CoFHTags.Items.INGOTS_ENDERIUM).add(ITEMS.get("enderium_ingot"));

            getBuilder(CoFHTags.Items.NUGGETS_SIGNALUM).add(ITEMS.get("signalum_nugget"));
            getBuilder(CoFHTags.Items.NUGGETS_LUMIUM).add(ITEMS.get("lumium_nugget"));
            getBuilder(CoFHTags.Items.NUGGETS_ENDERIUM).add(ITEMS.get("enderium_nugget"));

            getBuilder(CoFHTags.Items.PLATES_SIGNALUM).add(ITEMS.get("signalum_plate"));
            getBuilder(CoFHTags.Items.PLATES_LUMIUM).add(ITEMS.get("lumium_plate"));
            getBuilder(CoFHTags.Items.PLATES_ENDERIUM).add(ITEMS.get("enderium_plate"));

            getBuilder(CoFHTags.Items.TOOLS_WRENCH).add(ITEMS.get("wrench"));
        }

    }

    public static class Fluid extends FluidTagsProvider {

        public Fluid(DataGenerator dataGeneratorIn) {

            super(dataGeneratorIn);
        }

        @Override
        public String getName() {

            return "Thermal Core: Fluid Tags";
        }

        @Override
        protected void registerTags() {

        }

    }

}
