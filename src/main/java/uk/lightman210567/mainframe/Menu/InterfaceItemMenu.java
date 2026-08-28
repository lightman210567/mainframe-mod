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

// MESAGE FROM EVIL CURLE - DOCUMENTATION HELP
//This is code from one of my mods.
//Menu: https://github.com/MinecraftschurliMods/Ars-Magica-Legacy/blob/version/26.1/src/main/java/at/minecraftschurli/mods/arsmagicalegacy/menu/InscriptionTableMenu.java
//Block Entity: https://github.com/MinecraftschurliMods/Ars-Magica-Legacy/blob/version/26.1/src/main/java/at/minecraftschurli/mods/arsmagicalegacy/blockentity/InscriptionTableBlockEntity.java
//Block: https://github.com/MinecraftschurliMods/Ars-Magica-Legacy/blob/version/26.1/src/main/java/at/minecraftschurli/mods/arsmagicalegacy/block/InscriptionTableBlock.java
//The important parts are:
//The block entity implements MenuProvider and its #createMenu method, creating a new instance of the menu class.
//In the block's #useWithoutItem method, I call player.openMenu(blockEntity, pos);.
// That method accepts a MenuProvider (the block entity in this case) and the position.
// It forwards to another overload of openMenu which accepts the MenuProvider and a Consumer<FriendlyByteBuf> where we can write additional data
// (FriendlyByteBuf is basically a buffer for network data) and writes the position to that buffer.
// Then it sends a packet with that buffer to the client, telling it to open the menu.
//The menu then has two constructors. Both accept the containerId and the player's Inventory, but differ in their third parameter:
//The first one accepts the BlockEntity directly. This is the one called in MenuProvider#createMenu, here that's in our block entity.
//The second one accepts the FriendlyByteBuf received from the server. The job of this one is to get the block entity from the given position,
// and call the first constructor with the retrieved block entity. All the important setup happens in the first constructor, where the block entity is available.
//
//And the registered part of it is the MenuType, which is basically a way for the server to tell the client "hey, this is the menu I want opened".
// It is then the client's responsibility to open the corresponding Screen.
// The server doesn't care for the type of Screen shown, in fact the server doesn't even know what a Screen is (it doesn't have that class).
