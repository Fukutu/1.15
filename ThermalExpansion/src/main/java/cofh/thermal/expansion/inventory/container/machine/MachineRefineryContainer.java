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

import static cofh.thermal.expansion.init.TExpReferences.MACHINE_REFINERY_CONTAINER;

public class MachineRefineryContainer extends TileContainer {

    public final MachineTileBase tile;

    public MachineRefineryContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {

        super(MACHINE_REFINERY_CONTAINER, windowId, world, pos, inventory, player);
        this.tile = (MachineTileBase) world.getTileEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotRemoveOnly(tileInv, 0, 107, 35));

        addSlot(new SlotCoFH(tileInv, 1, 8, 53));

        bindAugmentSlots(tileInv, 2, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
