package me.daimariad.aliceborderlandmod.client;

import me.daimariad.aliceborderlandmod.AliceBorderlandMod;
import me.daimariad.aliceborderlandmod.gui.inventory.AliceBorderlandMenu;
import me.daimariad.aliceborderlandmod.gui.inventory.AliceBorderlandScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AliceBorderlandModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.<AliceBorderlandMenu, AliceBorderlandScreen>register(AliceBorderlandMod.SCREEN_HANDLER_TYPE, (gui, inventory, title) -> new AliceBorderlandScreen(gui, inventory.player, title));
    }
}
