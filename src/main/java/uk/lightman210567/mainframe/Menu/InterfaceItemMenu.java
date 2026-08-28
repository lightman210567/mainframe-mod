package uk.lightman210567.mainframe.Menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class InterfaceItemMenu extends AbstractContainerMenu {

    protected InterfaceItemMenu(int containerId, Inventory playerInventory) {
        super(ModMenus.INTERFACE_ITEM_MENU.get(), containerId);
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
