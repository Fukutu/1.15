package cofh.lib.util.helpers;

import cofh.lib.item.IAugmentableItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cofh.lib.util.constants.Constants.MAX_AUGMENTS;
import static cofh.lib.util.constants.NBTTags.TAG_AUGMENTS;
import static cofh.lib.util.constants.NBTTags.TAG_BLOCK_ENTITY;
import static net.minecraftforge.common.util.Constants.NBT.TAG_COMPOUND;

public class AugmentHelper {

    private AugmentHelper() {

    }

    public static List<ItemStack> getAugments(ItemStack stack) {

        ListNBT augmentTag = getAugmentNBT(stack);
        if (augmentTag.isEmpty()) {
            return Collections.emptyList();
        }
        return getAugments(augmentTag);
    }

    public static int getAugmentSlots(ItemStack stack) {

        return !isAugmentable(stack) ? 0 : MathHelper.clamp(((IAugmentableItem) stack.getItem()).getAugmentSlots(stack), 0, MAX_AUGMENTS);
    }

    public static boolean validAugment(ItemStack stack, ItemStack augment) {

        return isAugmentable(stack) && ((IAugmentableItem) stack.getItem()).validAugment(stack, augment);
    }

    public static void setAugments(ItemStack stack, List<ItemStack> augments) {

        if (!isAugmentable(stack)) {
            return;
        }
        ((IAugmentableItem) stack.getItem()).setAugments(stack, augments);
    }

    // region HELPERS
    public static boolean isAugmentable(ItemStack item) {

        return !item.isEmpty() && item.getItem() instanceof IAugmentableItem;
    }

    public static void writeAugmentsToItem(ItemStack stack, List<ItemStack> augments) {

        writeAugmentsToItem(stack, convertAugments(augments));
    }
    // endregion

    // region NBT MANIPULATION
    private static void writeAugmentsToItem(ItemStack stack, ListNBT list) {

        CompoundNBT blockTag = stack.getChildTag(TAG_BLOCK_ENTITY);
        if (blockTag != null) {
            blockTag.put(TAG_AUGMENTS, list);
            return;
        }
        if (stack.getItem() instanceof BlockItem) {
            blockTag = new CompoundNBT();
            blockTag.put(TAG_AUGMENTS, list);
            stack.setTagInfo(TAG_BLOCK_ENTITY, blockTag);
            return;
        }
        stack.setTagInfo(TAG_AUGMENTS, list);
    }

    private static List<ItemStack> getAugments(ListNBT list) {

        ArrayList<ItemStack> ret = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            ret.add(ItemStack.read(list.getCompound(i)));
        }
        return ret.isEmpty() ? Collections.emptyList() : ret;
    }

    private static ListNBT getAugmentNBT(ItemStack stack) {

        if (stack.getTag() == null) {
            return new ListNBT();
        }
        CompoundNBT blockTag = stack.getChildTag(TAG_BLOCK_ENTITY);
        if (blockTag != null) {
            return blockTag.contains(TAG_AUGMENTS) ? blockTag.getList(TAG_AUGMENTS, TAG_COMPOUND) : new ListNBT();
        }
        return stack.getTag().getList(TAG_AUGMENTS, TAG_COMPOUND);
    }

    private static ListNBT convertAugments(List<ItemStack> augments) {

        ListNBT list = new ListNBT();
        for (ItemStack augment : augments) {
            if (!augment.isEmpty()) {
                list.add(augment.write(new CompoundNBT()));
            }
        }
        return list;
    }
    // endregion
}
