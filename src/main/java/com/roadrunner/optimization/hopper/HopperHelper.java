package com.roadrunner.optimization.hopper;

/**
 * Placeholder helpers for hopper / inventory transfer optimizations.
 * In a full port these would contain the fast-path logic used by mixins
 * targeting TileEntityHopper and related classes.
 */
public final class HopperHelper {

    private HopperHelper() {}

    /**
     * Example helper that could be called from a mixin to short-circuit
     * empty or full inventories more quickly.
     */
    public static boolean isInventoryEmpty(net.minecraft.inventory.IInventory inv) {
        if (inv == null) return true;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (!inv.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInventoryFull(net.minecraft.inventory.IInventory inv) {
        if (inv == null) return true;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            net.minecraft.item.ItemStack stack = inv.getStackInSlot(i);
            if (stack.isEmpty() || stack.getCount() < stack.getMaxStackSize()) {
                return false;
            }
        }
        return true;
    }
}
