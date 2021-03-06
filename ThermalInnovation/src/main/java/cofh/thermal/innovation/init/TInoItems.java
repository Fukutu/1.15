package cofh.thermal.innovation.init;

import cofh.thermal.core.init.TCoreItems;
import cofh.thermal.innovation.item.PotionInfuserItem;
import cofh.thermal.innovation.item.RFCapacitorItem;
import cofh.thermal.innovation.item.RFMagnetItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import static cofh.thermal.core.common.ThermalItemGroups.THERMAL_TOOLS;
import static cofh.thermal.core.util.RegistrationHelper.registerItem;

public class TInoItems {

    private TInoItems() {

    }

    public static void register() {

        registerTools();
        registerArmor();
    }

    // region HELPERS
    private static void registerTools() {

        ItemGroup group = THERMAL_TOOLS;

        registerItem("flux_capacitor", () -> new RFCapacitorItem(new Item.Properties().maxStackSize(1).group(group), 200000, 1000));
        registerItem("flux_magnet", () -> new RFMagnetItem(new Item.Properties().maxStackSize(1).group(group), 20000, 1000));
        registerItem("potion_infuser", () -> new PotionInfuserItem(new Item.Properties().maxStackSize(1).group(group), 4000));
    }

    private static void registerArmor() {

        ItemGroup group = THERMAL_TOOLS;

        TCoreItems.registerHazmatArmor();
    }
    // endregion
}
