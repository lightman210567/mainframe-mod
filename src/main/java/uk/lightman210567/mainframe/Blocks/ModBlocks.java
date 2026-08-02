package uk.lightman210567.mainframe.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.lightman210567.mainframe.Blocks.Block.ServerBlock;
import uk.lightman210567.mainframe.Mainframe;

public class ModBlocks {
    // Define the block registry
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Mainframe.MODID);

    // Register blocks here!
    public static final DeferredBlock<ServerBlock> SERVER_BLOCK = BLOCKS.register(
            "server_block",
            () -> new ServerBlock(BlockBehaviour.Properties.of())

    );
    // END BLOCK REGISTER

    // Finalise block registration
    public static void registerBlocks(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
