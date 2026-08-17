package uk.lightman210567.mainframe.Blocks.Block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
import uk.lightman210567.mainframe.Items.HardDrive;
import uk.lightman210567.mainframe.Items.ModItems;
import uk.lightman210567.mainframe.Mainframe;
import uk.lightman210567.mainframe.Utility.InventoryReturnHelper;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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
    public ArrayList<ItemStack> getDisksInServer(BlockPos pos, Level level) {
        // Check that the block is really has an instance of the server block entity
        if (level.getBlockEntity(pos) instanceof ServerBlockEntity serverBlockEntity) {
            ArrayList<ItemStack> drives = new ArrayList<>(ServerBlockEntity.SLOT_COUNT);

            // Loop through every stack in the inventory, and add its drive to the drives array
            for (int i = 0; i < ServerBlockEntity.SLOT_COUNT; i++) {
                ItemStack drive = serverBlockEntity.inventory.getStackInSlot(i);
                drives.set(i, drive);
            }
            return drives;
        } else {
            // if the block isn't an instance of the server block entity
            // return null
            return null;
        }
    }

    // This method will get the combined inventory of the server
    // It takes the position of the server block and the level as parameters
    // these parameters should come from a player interaction further upstream
    public InventoryReturnHelper getServerInventory(BlockPos pos, Level level) {
        // Checks the block has an instance of the server block entity
        if (level.getBlockEntity(pos) instanceof ServerBlockEntity serverBlockEntity) {
            int combinedSize;

            LinkedHashMap<ItemStack, Integer> serverMap = new LinkedHashMap<>();
            NonNullList<ItemStack> serverInventory = NonNullList.withSize();

            // Loop through each drive in the server
            for (int i = 0; i < (ServerBlockEntity.SLOT_COUNT); i++) {
                // Gets the drive item and its methods/properties from the HardDrive class
                // Makes sure the item is an instance of HardDrive
                Item drive = serverBlockEntity.inventory.getStackInSlot(i).getItem();
                if (drive instanceof HardDrive hardDriveItem) {
                    
                }
            }
        }
        return null; // FOR DEBUG ONLY; DELETE THIS!!
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
                        break;
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

    // Here is how inventory access will work:
    // 1) the request for an inventory (from opening the interface)
    // 2) get a list of all servers
    // 3) request a list of items from each server:
    // 3a) the server will get a list of all disks within it
    // 3b) the server will query the inventory of each disk
    // 3c) the server will combine the inventories and return this to the interface
    // 4) the interface combines the inventories from each server into one inventory
    // 5) the interface uses this combined
    // THIS IS ONLY FOR GETTING THE INVENTORY
    // MODIFYING WILL NEED A WHOLE NEW PROCESS

    // Somehow, you will need to find a way of making sure each stored item
    // gets back to the correct disk
    // otherwise items will get duplicated

    // McPlan:
    // Each server will combine the inventories of its disks into one inventory
    // The server will generate an index
    // The index maps each item stack in the combined inventory into its disk and slot
    // The index will be stored in an array,
    // where the ID in the array is the slot in the combined inventory
    // and the entry contains a drive number and slot number

    // McPlan 2.0:
    //
    // GETTING SERVER INVENTORY
    //
    // 1)
    // Each server will determine its slot capacity
    // And use this to generate an "address range" of usable slots
    // 2)
    // The server will create an instance of InventoryReturnHelper
    // Containing the following:
    // - A map (type TBC) that maps ItemStack(s) to their drive object
    // - a NonNullList of type ItemStack (to act as an inventory)
    // - A start address and for the inventory
    // 3a)
    // The server will loop through each drive object it contains
    // 3b)
    // The server will loop through each item in the drive
    // Adding the ItemStack into the InventoryReturnHelper's inventory
    // Adding the driveID and the stack type to the map
    // 4)
    // The server will return the instance of the InventoryReturnHelper
    //
    // COMBINING SERVERS
    // TBC - TO PLAN

    // PLANNED REFACTORS
    //
    // - Remove the interface block
    //      It can be programmed in a later mod version
    //      However it is unnecessarily complex to do graph theory for an alpha
    // - Implement an interface item
    //      This interface item will be able to access the inventory of a server
    //      Eliminating the need for complex ways to detect servers on the network
    //      This will likely need a menu of some kind
}
