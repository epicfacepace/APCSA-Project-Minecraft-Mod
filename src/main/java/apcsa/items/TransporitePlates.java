package apcsa.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class TransporitePlates extends Item {

    public TransporitePlates() {
        super(new Item.Properties()
                .group(ItemGroup.MISC)
                .maxStackSize(64)
        );
        setRegistryName("transporite_plates");
    }
}
