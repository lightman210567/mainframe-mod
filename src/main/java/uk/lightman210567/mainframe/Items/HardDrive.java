package uk.lightman210567.mainframe.Items;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import uk.lightman210567.mainframe.Utility.ItemStackContainer;

public class HardDrive extends Item {
    public HardDrive(Properties properties) {
        super(properties);
    }

    public static final int SIZE = 1;

    // Gets a list of all item stacks in the container
    // Takes the drive's ItemStack as an argument
    // UNTESTED
    public NonNullList<ItemStack> getItems(ItemStack drive) {
        ItemStackContainer container = new ItemStackContainer(drive, SIZE);
        NonNullList<ItemStack> items = container.getItems();
        return items;
    }

    // A method to store the given item stack into the hard drive item
    // stack is the stack to store into the drive
    // drive is the ItemStack of the hard drive to store into
    // UNTESTED
    public void store(ItemStack stack, ItemStack drive) {
        ItemStackContainer container = new ItemStackContainer(drive, SIZE);
        container.addItem(stack);
        container.setChanged();
    }

    // A method to extract an item from the drive at a given index
    // drive is the ItemStack of the hard drive
    // index is the index to remove the item at in the drive (similar to an address)
    // UNTESTED
    public ItemStack extract(ItemStack drive, int index) {
        ItemStackContainer container = new ItemStackContainer(drive, SIZE);
        ItemStack extracted = container.getItem(index);
        container.removeItem(index, 1);
        return extracted;
    }

    // Find some clever way of defining size

    // When you want to interact with the hard drive, create a method for that interaction
    // This method will create an instance of the ItemStackContainer class
    // Allowing you to interact with the container
    // Call setChanged() to save the changes you made to the container
    // You will need an individual method for each interaction

    // ItemStack stack will be passed as a parameter into the method
    // ItemStackContainer container = new ItemStackContainer(stack, size)
}
