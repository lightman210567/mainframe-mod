package uk.lightman210567.mainframe.Items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import uk.lightman210567.mainframe.Utility.ItemStackContainer;

public class HardDrive extends Item {
    public HardDrive(Properties properties) {
        super(properties);
    }

    public static final int size = 1;

    // When you want to interact with the hard drive, create a method for that interaction
    // This method will create an instance of the ItemStackContainer class
    // Allowing you to interact with the container
    // Call setChanged() to save the changes you made to the container
    // You will need an individual method for each interaction

    // ItemStack stack will be passed as a parameter into the method
    // ItemStackContainer container = new ItemStackContainer(stack, size)
}
