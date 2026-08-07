package uk.lightman210567.mainframe.Blocks.Entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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

    public static final int SLOT_COUNT = 4;
    public static final int STACK_SIZE = 1;

    // Create the ItemStackHandler
    public final ItemStackHandler inventory = new ItemStackHandler(SLOT_COUNT) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return STACK_SIZE;
        }
    };

    // Reusable function to insert a drive into the server
    // Assumes that the player's ability to insert the drive has already been checked
    // Takes stack as an argument, which is the drive ItemStack to insert
    // Returns true if insertion was successful, returns false if the insertion failed
    public boolean insertDrive(ItemStack stack) {
        // This will loop through each slot, and check if it is empty
        // If the slot is empty, you can insert a drive in it
        // If not, the drive can not be inserted
        for (int i = 0; i < SLOT_COUNT; i++) {
            if (inventory.getStackInSlot(i).isEmpty()) {
                // Insert
                inventory.setStackInSlot(i, stack.copyWithCount(1));
                return true;
            } else {
                continue;
            }
        }
        return false; // Defaults to returning false if the insertion fails
    }

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

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
