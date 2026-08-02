package uk.lightman210567.mainframe.Blocks.Entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import uk.lightman210567.mainframe.Blocks.ModBlockEntities;

import static uk.lightman210567.mainframe.Blocks.ModBlockEntities.SERVER_BLOCK_ENTITY;

public class ServerBlockEntity extends BlockEntity {
    public ServerBlockEntity(BlockPos pos, BlockState state) {
        super(SERVER_BLOCK_ENTITY.get(), pos, state);
    }
}
