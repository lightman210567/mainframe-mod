package uk.lightman210567.mainframe;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegistrySetup {
    // Define registries here!
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Mainframe.MODID);

    // Register the registries here!
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
