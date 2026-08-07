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

}
