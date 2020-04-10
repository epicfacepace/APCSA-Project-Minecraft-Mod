package apcsa.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class TransporiteShards extends Item {

    public TransporiteShards() {
        super(new Item.Properties()
                .group(ItemGroup.MISC)
                .maxStackSize(64)
        );
        setRegistryName("transporite_shards");
    }
}
