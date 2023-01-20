package me.daimariad.aliceborderlandmod.events;

import me.daimariad.aliceborderlandmod.gui.inventory.AliceBorderlandMenu;
import me.daimariad.aliceborderlandmod.item.ModItems;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CommonEvents {

    public static void playerLoggedIn(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {
        ServerPlayerEntity player = handler.getPlayer();
        player.getInventory().setStack(0, new ItemStack(ModItems.ALICE_BORDERLAND_COMPASS));
    }

    public static TypedActionResult<ItemStack> onItemUse(PlayerEntity player, World world, Hand hand) {
        if (!world.isClient && player.getStackInHand(hand).getItem().equals(ModItems.ALICE_BORDERLAND_COMPASS)) {
            try {
                player.openHandledScreen(new NamedScreenHandlerFactory() {
                    @Override
                    public Text getDisplayName() {
                        return Text.literal("Alice Borderland Games");
                    }

                    @Override
                    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        return new AliceBorderlandMenu(syncId, playerInventory, ScreenHandlerContext.create(world, player.getBlockPos()));
                    }
                });
                return TypedActionResult.success(player.getStackInHand(hand));
            } catch (Exception e) {
                System.out.println("AliceBorderlandCompass Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return TypedActionResult.pass(ItemStack.EMPTY);
    }
}
