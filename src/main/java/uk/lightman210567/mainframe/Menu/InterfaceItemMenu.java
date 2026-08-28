package uk.lightman210567.mainframe.Menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import uk.lightman210567.mainframe.Blocks.Entity.ServerBlockEntity;
import uk.lightman210567.mainframe.Items.InterfaceItem;

public class InterfaceItemMenu extends AbstractContainerMenu {

    // Server constructor
    // All important menu setup happens here
    public InterfaceItemMenu(int containerId, Inventory playerInventory, ServerBlockEntity serverBlockEntity) {
        super(ModMenus.INTERFACE_ITEM_MENU.get(), containerId);
    }

    // Client constructor
    // It's only job is to get the block entity and call the server constructor
    // Gets the block entity from the block position in the FriendlyByteBuf
    public InterfaceItemMenu(int containerId, Inventory playerInventory, FriendlyByteBuf byteBuf) {
        this(containerId, playerInventory, (ServerBlockEntity) playerInventory.player.level().getBlockEntity(byteBuf.readBlockPos()));
    }

    // TODO Implement the quickMoveStack method
    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    // TODO Implement the stillValid method
    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
