package cofh.thermal.expansion.inventory.container.machine;

import cofh.lib.inventory.InvWrapperCoFH;
import cofh.lib.inventory.container.TileContainer;
import cofh.lib.inventory.container.slot.SlotCoFH;
import cofh.lib.inventory.container.slot.SlotRemoveOnly;
import cofh.thermal.core.tileentity.MachineTileBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static cofh.thermal.expansion.init.TExpReferences.MACHINE_INSOLATOR_CONTAINER;

public class MachineInsolatorContainer extends TileContainer {

    public final MachineTileBase tile;

    public MachineInsolatorContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {

        super(MACHINE_INSOLATOR_CONTAINER, windowId, world, pos, inventory, player);
        this.tile = (MachineTileBase) world.getTileEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotCoFH(tileInv, 0, 62, 17));

        addSlot(new SlotCoFH(tileInv, 1, 62, 53));

        addSlot(new SlotRemoveOnly(tileInv, 2, 116, 26));
        addSlot(new SlotRemoveOnly(tileInv, 3, 134, 26));
        addSlot(new SlotRemoveOnly(tileInv, 4, 116, 44));
        addSlot(new SlotRemoveOnly(tileInv, 5, 134, 44));

        addSlot(new SlotCoFH(tileInv, 6, 8, 53));

        bindAugmentSlots(tileInv, 7, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
