package uk.lightman210567.mainframe.Blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.lightman210567.mainframe.Blocks.Entity.ServerBlockEntity;
import uk.lightman210567.mainframe.Mainframe;

import java.util.function.Supplier;

public class ModBlockEntities {
    // Define the register for block entities
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Mainframe.MODID);

    // Register block entities here

    public static final Supplier<BlockEntityType<ServerBlockEntity>> SERVER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "server_block_entity",
            () -> BlockEntityType.Builder.of(
                    ServerBlockEntity::new,
                    ModBlocks.SERVER_BLOCK.get()
            ).build(null)
    );

    // END BLOCK ENTITY REGISTER

    public static void registerBlockEntities(IEventBus modEventBus) {
        BLOCK_ENTITY_TYPES.register(modEventBus);
    }
}
