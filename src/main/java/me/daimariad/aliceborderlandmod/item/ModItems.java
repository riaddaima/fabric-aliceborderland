package me.daimariad.aliceborderlandmod.item;

import me.daimariad.aliceborderlandmod.AliceBorderlandMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item ALICE_BORDERLAND_COMPASS = registerItem("alice_borderland_compass",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AliceBorderlandMod.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}
