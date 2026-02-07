
package pl.twojanazwa.pixelmonstonedrops;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StoneBreakHandler {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new StoneBreakHandler());
    }

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() != Blocks.STONE) return;

        Player player = event.getPlayer();
        if (player == null || player.level().isClientSide()) return;

        ItemStack tool = player.getMainHandItem();
        int fortune = tool.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE);
        boolean silk = tool.getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0;

        if (silk && !Config.SILK_TOUCH_ENABLED.get()) return;

        event.setCanceled(true);
        event.getLevel().removeBlock(event.getPos(), false);

        ItemStack drop = new ItemStack(DropRegistry.getRandomDrop(fortune));
        player.spawnAtLocation(drop);

        int xp = Config.XP_MIN.get() + player.getRandom().nextInt(Config.XP_MAX.get());
        player.giveExperiencePoints(xp);
    }
}
