package uk.lightman210567.mainframe;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import uk.lightman210567.mainframe.Blocks.ModBlockEntities;
import uk.lightman210567.mainframe.Blocks.ModBlocks;
import uk.lightman210567.mainframe.Blocks.ModBlockItems;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Mainframe.MODID)
public class Mainframe {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "mainframe";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    // Call registration functions from here
    public Mainframe(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.registerBlocks(modEventBus);
        ModBlockItems.registerItems(modEventBus);
        ModBlockEntities.registerBlockEntities(modEventBus);
    }
}
