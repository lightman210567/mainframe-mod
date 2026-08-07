package uk.lightman210567.mainframe.Utility;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;

public class ItemStackContainer extends SimpleContainer {
    protected final ItemStack stack;

    // the stack argument should be the ItemStack of the item the container is attached to
    // e.g. if the container is for a disk item, you would pass the disk's ItemStack in
    // the slotCount argument is the size of the container, measured in slots
    public ItemStackContainer(ItemStack stack, int slotCount) {
        super(slotCount);
        this.stack = stack;
        ItemContainerContents contents = stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        contents.copyInto(this.getItems());
    }

    @Override
    public void setChanged() {
        super.setChanged();
        this.stack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }
}
