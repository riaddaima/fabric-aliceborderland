package me.daimariad.aliceborderlandmod.gui.inventory;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class AliceBorderlandScreen extends CottonInventoryScreen<AliceBorderlandMenu> {
    public AliceBorderlandScreen(AliceBorderlandMenu gui, PlayerEntity player, Text title) {
        super(gui, player, title);
    }
}
