package me.daimariad.aliceborderlandmod;

import me.daimariad.aliceborderlandmod.events.CommonEvents;
import me.daimariad.aliceborderlandmod.gui.inventory.AliceBorderlandMenu;
import me.daimariad.aliceborderlandmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;

public class AliceBorderlandMod implements ModInitializer {

    public static String MOD_ID = "aliceborderlandmod";
    public static ScreenHandlerType SCREEN_HANDLER_TYPE;

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ServerPlayConnectionEvents.JOIN.register(CommonEvents::playerLoggedIn);
        SCREEN_HANDLER_TYPE = Registry.register(Registry.SCREEN_HANDLER, MOD_ID, new ScreenHandlerType<>((syncId, inventory) -> new AliceBorderlandMenu(syncId, inventory, ScreenHandlerContext.EMPTY)));
        UseItemCallback.EVENT.register(CommonEvents::onItemUse);
    }
}
