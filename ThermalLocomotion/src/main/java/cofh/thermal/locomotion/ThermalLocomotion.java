package cofh.thermal.locomotion;

import cofh.thermal.core.client.renderer.entity.UnderwaterMinecartRenderer;
import cofh.thermal.locomotion.data.TLocItemModels;
import cofh.thermal.locomotion.data.TLocLootTables;
import cofh.thermal.locomotion.data.TLocRecipes;
import cofh.thermal.locomotion.data.TLocTags;
import cofh.thermal.locomotion.init.TLocBlocks;
import cofh.thermal.locomotion.init.TLocEntities;
import cofh.thermal.locomotion.init.TLocItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cofh.lib.util.constants.Constants.ID_THERMAL_LOCOMOTION;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.locomotion.init.TLocReferences.*;

@Mod(ID_THERMAL_LOCOMOTION)
public class ThermalLocomotion {

    public ThermalLocomotion() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::gatherData);

        TLocBlocks.register();
        TLocEntities.register();
        TLocItems.register();
    }

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

        RenderType cutout = RenderType.getCutout();

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_CROSSOVER_RAIL), cutout);

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_PRISMARINE_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_PRISMARINE_CROSSOVER_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_PRISMARINE_ACTIVATOR_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_PRISMARINE_DETECTOR_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_PRISMARINE_POWERED_RAIL), cutout);

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_LUMIUM_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_LUMIUM_CROSSOVER_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_LUMIUM_ACTIVATOR_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_LUMIUM_DETECTOR_RAIL), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_LUMIUM_POWERED_RAIL), cutout);

        RenderingRegistry.registerEntityRenderingHandler(UNDERWATER_CART_ENTITY, UnderwaterMinecartRenderer::new);
    }
    // endregion

    // region DATA
    private void gatherData(final GatherDataEvent event) {

        if (event.includeServer()) {
            registerServerProviders(event.getGenerator());
        }
        if (event.includeClient()) {
            registerClientProviders(event.getGenerator(), event);
        }
    }

    private void registerServerProviders(DataGenerator generator) {

        generator.addProvider(new TLocTags.Block(generator));
        generator.addProvider(new TLocTags.Item(generator));
        generator.addProvider(new TLocTags.Fluid(generator));

        generator.addProvider(new TLocLootTables(generator));
        generator.addProvider(new TLocRecipes(generator));
    }

    private void registerClientProviders(DataGenerator generator, GatherDataEvent event) {

        generator.addProvider(new TLocItemModels(generator, event.getExistingFileHelper()));
    }
    // endregion
}
