package cofh.thermal.core.fluid;

import cofh.thermal.core.init.ThermalItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

import static cofh.thermal.core.ThermalCore.*;

public class ThermalFluid {

    protected ForgeFlowingFluid.Properties properties;

    public static ThermalFluid create(String key, String stillTexture, String flowTexture) {

        return new ThermalFluid(key, stillTexture, flowTexture);
    }

    private ThermalFluid(String key, String stillTexture, String flowTexture) {

        RegistryObject<FlowingFluid> stillFluid = FLUIDS.register(key, () -> new ForgeFlowingFluid.Source(properties));
        RegistryObject<FlowingFluid> flowingFluid = FLUIDS.register(flowing(key), () -> new ForgeFlowingFluid.Flowing(properties));

        RegistryObject<FlowingFluidBlock> block = BLOCKS.register(key, () -> new FlowingFluidBlock(stillFluid, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
        RegistryObject<Item> bucket = ITEMS.register(bucket(key), () -> new BucketItem(stillFluid, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ThermalItemGroups.THERMAL_TOOLS)));

        properties = new ForgeFlowingFluid.Properties(stillFluid, flowingFluid, FluidAttributes.builder(new ResourceLocation(stillTexture), new ResourceLocation(flowTexture))).bucket(bucket).block(block);
    }

    // region HELPERS
    public static String flowing(String fluid) {

        return fluid + "_flowing";
    }

    public static String bucket(String fluid) {

        return fluid + "_bucket";
    }
    // endregion

}