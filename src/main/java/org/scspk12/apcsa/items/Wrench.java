package org.scspk12.apcsa.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Wrench extends Item {
    public Wrench() {
        super(new Item.Properties()
                .group(ItemGroup.TOOLS)
                .maxStackSize(1)
        );
        setRegistryName("wrench");
    }
}
