
package pl.twojanazwa.pixelmonstonedrops;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod("pixelmonstonedrops")
public class PixelmonStoneDrops {

    public PixelmonStoneDrops() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        Config.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        DropRegistry.init();
        StoneBreakHandler.register();
    }
}
