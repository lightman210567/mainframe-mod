package uk.lightman210567.mainframe.Items;

import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.lightman210567.mainframe.Blocks.ModBlocks;
import uk.lightman210567.mainframe.Mainframe;

public class ModItems {
    // Define the items registry
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mainframe.MODID);

    // Register items here!
    // END ITEM REGISTER

    // Register block items here!
    public static final DeferredItem<BlockItem> SERVER_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("server_block", ModBlocks.SERVER_BLOCK);
    // END BLOCK ITEM REGISTER

    // Finalise item registration
    public static void registerItems(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
