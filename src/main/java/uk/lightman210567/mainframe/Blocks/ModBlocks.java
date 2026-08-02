package uk.lightman210567.mainframe.Blocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.lightman210567.mainframe.Mainframe;

public class ModBlocks {
    // Define the block registry
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Mainframe.MODID);

    // Register blocks here!


    // Finalise block registration
    public static void registerBlocks(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
