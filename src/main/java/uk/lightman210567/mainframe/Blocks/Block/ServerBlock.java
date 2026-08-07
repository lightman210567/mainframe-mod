package uk.lightman210567.mainframe.Blocks.Block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.logging.log4j.core.jmx.Server;
import uk.lightman210567.mainframe.Blocks.Entity.ServerBlockEntity;
import uk.lightman210567.mainframe.Items.ModItems;
import uk.lightman210567.mainframe.Mainframe;

public class ServerBlock extends Block implements EntityBlock {
    public ServerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public BlockPos entityPos;

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        entityPos = pos; // Set the position variable when the BlockEntity is created on the block
        return new ServerBlockEntity(pos, state);
    }

    // This method gets a list of disks in the server
    // It takes the position of the server block and the level as parameters
    // level should come from a player interaction further upstream
    public ItemStack[] getDisksInServer(BlockPos pos, Level level) {
        // Check that the block is really has an instance of the server block entity
        if (level.getBlockEntity(pos) instanceof ServerBlockEntity serverBlockEntity) {
            ItemStack[] drives = new ItemStack[ServerBlockEntity.SLOT_COUNT];

            // Loop through every stack in the inventory, and add its drive to the drives array
            for (int i = 0; i < ServerBlockEntity.SLOT_COUNT; i++) {
                ItemStack drive = serverBlockEntity.inventory.getStackInSlot(i);
                drives[i] = drive;
            }
            return drives;
        } else {
            // if the block isn't an instance of the server block entity
            // return null
            return null;
        }
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                           Player player, InteractionHand hand, BlockHitResult hitResult) {
        // Check that the block has an instance of the ServerBlockEntity block entity
        if (level.getBlockEntity(pos) instanceof ServerBlockEntity serverBlockEntity) {
            // Check that the item the player is holding is a hard drive
            if (stack.getItem() == ModItems.HARD_DRIVE.asItem()) {
                // the insertDrive method returns a boolean; true for success; false for failure
                // This if statement checks that the insertion was a success before decrementing the stack
                if (serverBlockEntity.insertDrive(stack)) {
                    stack.shrink(1);
                }
            // Or, if the player hand is empty, extract a drive
            } else if (stack.isEmpty()) {
                // loop through each slot, starting with the last
                // the idea being I want to extract the last drive in the server each time
                // this also checks if the slot is NOT empty
                for (int i = (ServerBlockEntity.SLOT_COUNT - 1); i >= 0; i--) {
                    if (!serverBlockEntity.inventory.getStackInSlot(i).isEmpty()) {
                        ItemStack extractedStack = serverBlockEntity.inventory.extractItem(i, 1, false);
                        player.setItemInHand(InteractionHand.MAIN_HAND, extractedStack);
                    }
                }
            }
        }
        return ItemInteractionResult.SUCCESS;
    }

    // You are going to need to write a method that checks all slots for disks
    // When the server is asked for a list of items:
    // check over all slots in the server
    // create a ItemStackContainer for each disk
    
    // Source: "evil Curle" - discord - take with a grain of salt
    // you mentioned you have some sort of disk server that holds your disks
    // so what would happen is that, when your disk server is asked for a list of itemstacks
    // you go over all the slots of your disk server
    // and for each of the itemstacks in those slots,
    // you'd then create an ItemStackContainer and get a list of all items stored in an itemstack from the container
}
