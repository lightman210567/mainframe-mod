package uk.lightman210567.mainframe.Blocks.Entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ServerBlockEntity extends BlockEntity {
    public ServerBlockEntity(BlockPos pos, BlockState state) {
        // REPLACE type WITH A REFERENCE TO THE REGISTERED BLOCK ENTITY
        super(type, pos, state);
    }
}
