package cofh.core.network.packet.client;

import cofh.core.CoFHCore;
import cofh.lib.network.packet.IPacketClient;
import cofh.lib.network.packet.PacketBase;
import cofh.lib.tileentity.TileCoFH;
import cofh.lib.util.Utils;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static cofh.lib.util.constants.Constants.NETWORK_UPDATE_DISTANCE;
import static cofh.lib.util.constants.Constants.PACKET_REDSTONE;

public class TileRedstonePacket extends PacketBase implements IPacketClient {

    protected BlockPos pos;
    protected PacketBuffer buffer;

    public TileRedstonePacket() {

        super(PACKET_REDSTONE, CoFHCore.PACKET_HANDLER);
    }

    @Override
    public void handleClient() {

        World world = CoFHCore.PROXY.getClientWorld();
        if (world == null) {
            CoFHCore.LOG.error("Client world is null! (Is this being called on the server?)");
            return;
        }
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileCoFH) {
            ((TileCoFH) tile).handleRedstonePacket(buffer);
        }
    }

    @Override
    public void write(PacketBuffer buf) {

        buf.writeBlockPos(pos);
        buf.writeBytes(buffer);
    }

    @Override
    public void read(PacketBuffer buf) {

        buffer = buf;
        pos = buffer.readBlockPos();
    }

    public static void sendToClient(TileCoFH tile) {

        if (Utils.isClientWorld(tile.world())) {
            return;
        }
        TileRedstonePacket packet = new TileRedstonePacket();
        packet.pos = tile.pos();
        packet.buffer = tile.getRedstonePacket(new PacketBuffer(Unpooled.buffer()));
        packet.sendToAllAround(packet.pos, NETWORK_UPDATE_DISTANCE, tile.world().getDimension().getType());
    }

}
