package me.daimariad.aliceborderlandmod.gui.inventory;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItem;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import me.daimariad.aliceborderlandmod.AliceBorderlandMod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.collection.DefaultedList;

public class AliceBorderlandMenu extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 9;

    public AliceBorderlandMenu(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(AliceBorderlandMod.SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setInsets(Insets.ROOT_PANEL);
        Inventory AliceBorderlandInv = new ImplementedInventory() {
            private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);
            @Override
            public DefaultedList<ItemStack> getItems() {
                return items;
            }
        };
        AliceBorderlandInv.setStack(0, new ItemStack(Items.DIAMOND));
        for (int y = 1; y <= 6; y++) {
            for (int x = 0; x < 9; x++) {
                root.add(new WItemSlot(AliceBorderlandInv, 1, 1, 1, false).setInsertingAllowed(false), x, y);
            }
        }
//        WItem widgetItem = new WItem(new ItemStack(Items.DIAMOND));
//        root.add(widgetItem, 0, 1);

        root.add(this.createPlayerInventoryPanel(), 0, 8);

        root.validate(this);
    }
}
