package uk.lightman210567.mainframe.Items;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.lightman210567.mainframe.Mainframe;

public class ModItems {
    // Define the item registry
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mainframe.MODID);

    // Register items here!
    // END ITEM REGISTRY

    public static void registerItems(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
