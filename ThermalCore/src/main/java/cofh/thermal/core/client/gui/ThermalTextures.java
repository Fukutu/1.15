package cofh.thermal.core.client.gui;

import cofh.thermal.core.client.renderer.model.MachineBakedModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.Constants.ID_THERMAL;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ID_THERMAL, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalTextures {

    private ThermalTextures() {

    }

    private static final String BLOCK_ATLAS = "minecraft:textures/atlas/blocks.png";

    @SubscribeEvent
    public static void preStitch(TextureStitchEvent.Pre event) {

        if (!event.getMap().getTextureLocation().toString().equals(BLOCK_ATLAS)) {
            return;
        }
        event.addSprite(MACHINE_CONFIG_NONE_LOC);
        event.addSprite(MACHINE_CONFIG_INPUT_LOC);
        event.addSprite(MACHINE_CONFIG_OUTPUT_LOC);
        event.addSprite(MACHINE_CONFIG_BOTH_LOC);
        event.addSprite(MACHINE_CONFIG_ACCESSIBLE_LOC);
    }

    @SubscribeEvent
    public static void postStitch(TextureStitchEvent.Post event) {

        if (!event.getMap().getTextureLocation().toString().equals(BLOCK_ATLAS)) {
            return;
        }
        MachineBakedModel.clearCache();

        AtlasTexture map = event.getMap();
        MACHINE_CONFIG_NONE = map.getSprite(MACHINE_CONFIG_NONE_LOC);
        MACHINE_CONFIG_INPUT = map.getSprite(MACHINE_CONFIG_INPUT_LOC);
        MACHINE_CONFIG_OUTPUT = map.getSprite(MACHINE_CONFIG_OUTPUT_LOC);
        MACHINE_CONFIG_BOTH = map.getSprite(MACHINE_CONFIG_BOTH_LOC);
        MACHINE_CONFIG_ACCESSIBLE = map.getSprite(MACHINE_CONFIG_ACCESSIBLE_LOC);
    }

    // region CONFIG
    private static final String CONFIG_ = ID_THERMAL + ":block/config/";

    public static ResourceLocation MACHINE_CONFIG_NONE_LOC = new ResourceLocation(CONFIG_ + "machine_config_none");
    public static ResourceLocation MACHINE_CONFIG_INPUT_LOC = new ResourceLocation(CONFIG_ + "machine_config_input");
    public static ResourceLocation MACHINE_CONFIG_OUTPUT_LOC = new ResourceLocation(CONFIG_ + "machine_config_output");
    public static ResourceLocation MACHINE_CONFIG_BOTH_LOC = new ResourceLocation(CONFIG_ + "machine_config_both");
    public static ResourceLocation MACHINE_CONFIG_ACCESSIBLE_LOC = new ResourceLocation(CONFIG_ + "machine_config_accessible");

    public static TextureAtlasSprite MACHINE_CONFIG_NONE;
    public static TextureAtlasSprite MACHINE_CONFIG_INPUT;
    public static TextureAtlasSprite MACHINE_CONFIG_OUTPUT;
    public static TextureAtlasSprite MACHINE_CONFIG_BOTH;
    public static TextureAtlasSprite MACHINE_CONFIG_ACCESSIBLE;
    // endregion
}
