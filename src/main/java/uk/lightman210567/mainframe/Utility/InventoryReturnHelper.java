package uk.lightman210567.mainframe.Utility;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;

public class InventoryReturnHelper {
    public final NonNullList<ItemStack> inventory;
    public final LinkedHashMap<Integer, Integer> map; // Maps inventory slot to drive ID
    public final LinkedHashMap<Integer, Integer> driveAddresses; // Maps driveID to start address

    public InventoryReturnHelper(NonNullList<ItemStack> inventory, LinkedHashMap<Integer, Integer> map, LinkedHashMap<Integer, Integer> driveAddresses) {
        this.inventory = inventory;
        this.map = map;
        this.driveAddresses = driveAddresses;
    }
}
