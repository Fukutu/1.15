package cofh.lib.item;

import cofh.lib.util.helpers.AugmentableHelper;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * A reasonably freeform interface used for handling Augmentation for ItemStack objects.
 */
public interface IAugmentableItem {

    default List<ItemStack> getAugments(ItemStack augmentable) {

        return AugmentableHelper.getAugments(augmentable);
    }

    /**
     * @param augmentable Stack representing the Augmentable item.
     * @return The *total* number of slots available for augmentation.
     */
    int getAugmentSlots(ItemStack augmentable);

    /**
     * Check to see if augment *can* be installed. This is the validator check for the augment slot in a GUI.
     *
     * @param augmentable Stack representing the Augmentable item.
     * @param augment     Stack representing the Augment item to be added.
     * @return TRUE if the augment is compatible.
     */
    boolean validAugment(ItemStack augmentable, ItemStack augment);

    /**
     * Writes the augments TO the ItemStack's NBT and performs any extra logic which may be required.
     *
     * @param augmentable Stack representing the Augmentable item.
     */
    default void setAugments(ItemStack augmentable, List<ItemStack> augments) {

        AugmentableHelper.writeAugmentsToItem(augmentable, augments);
    }

}