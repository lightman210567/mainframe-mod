package uk.lightman210567.mainframe.Items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
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

// THIS IS IMPORTANT
// YOU HAVE TO IMPLEMENT A WAY TO LIMIT WHAT GOES INTO YOUR HARD DRIVES
// OTHERWISE THERE IS POTENTIAL FOR "BOOK BANNING"
// WHERE THE PACKET IS TOO BIG FOR THE CLIENT TO DESERIALIZE THE NBT
