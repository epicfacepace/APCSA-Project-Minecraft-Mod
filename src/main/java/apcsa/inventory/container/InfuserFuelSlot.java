package apcsa.inventory.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class InfuserFuelSlot extends Slot {
    private final AbstractInfuserContainer abstractInfuserContainer;

    public InfuserFuelSlot(AbstractInfuserContainer abstractInfuserContainerIn, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        this.abstractInfuserContainer = abstractInfuserContainerIn;
    }

    /**
     * Check if the stack is allowed to be placed in this slot.
     */
    public boolean isItemValid(ItemStack stack) {

        return this.abstractInfuserContainer.isFuel(stack);
    }

    public int getItemStackLimit(ItemStack stack) {

        return super.getItemStackLimit(stack);
    }
}
