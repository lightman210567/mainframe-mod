package uk.lightman210567.mainframe.Menu;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.lightman210567.mainframe.Mainframe;

public class ModMenus {
    // Define the MenuType registry
    public static final DeferredRegister<MenuType<?>> MOD_MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, Mainframe.MODID);

    // Register Menu Types here
    // END MENU TYPE REGISTRY

    public static void registerMenus(IEventBus modEventBus) {
        MOD_MENU_TYPES.register(modEventBus);
    }
}
