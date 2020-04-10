package apcsa.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class TransporiteMagnet extends Item {
    public TransporiteMagnet() {
        super(new Properties()
                .group(ItemGroup.TOOLS)
                .maxStackSize(1)
        );
        setRegistryName("transporite_magnet");
    }
}
