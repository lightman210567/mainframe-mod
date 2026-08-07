package uk.lightman210567.mainframe.Blocks.Entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import uk.lightman210567.mainframe.Blocks.ModBlockEntities;

import static uk.lightman210567.mainframe.Blocks.ModBlockEntities.SERVER_BLOCK_ENTITY;

public class ServerBlockEntity extends BlockEntity {
    public ServerBlockEntity(BlockPos pos, BlockState state) {
        super(SERVER_BLOCK_ENTITY.get(), pos, state);
    }

    public static final int SLOT_COUNT = 1;
    public static final int STACK_SIZE = 1;

    // Create the ItemStackHandler
    public final ItemStackHandler inventory = new ItemStackHandler(SLOT_COUNT) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return STACK_SIZE;
        }
    };

    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
    }
}
