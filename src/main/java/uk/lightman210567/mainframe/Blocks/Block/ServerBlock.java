package uk.lightman210567.mainframe.Blocks.Block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import uk.lightman210567.mainframe.Blocks.Entity.ServerBlockEntity;

public class ServerBlock extends Block implements EntityBlock {
    public ServerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ServerBlockEntity(pos, state);
    }

    // You are going to need to write a method that checks all slots for disks
    // When the server is asked for a list of items:
    // check over all slots in the server
    // create a ItemStackContainer for each disk
    
    // Source: "evil Curle" - discord - take with a grain of salt
    // you mentioned you have some sort of disk server that holds your disks
    // so what would happen is that, when your disk server is asked for a list of itemstacks
    // you go over all the slots of your disk server
    // and for each of the itemstacks in those slots,
    // you'd then create an ItemStackContainer and get a list of all items stored in an itemstack from the container
}
