package uk.lightman210567.mainframe.Blocks.Block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class InterfaceBlock extends Block {
    public InterfaceBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

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
