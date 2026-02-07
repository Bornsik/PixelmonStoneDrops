
package pl.twojanazwa.pixelmonstonedrops;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec.IntValue XP_MIN;
    public static ForgeConfigSpec.IntValue XP_MAX;
    public static ForgeConfigSpec.BooleanValue SILK_TOUCH_ENABLED;

    public static void init() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        XP_MIN = builder.defineInRange("xpMin", 5, 0, 100);
        XP_MAX = builder.defineInRange("xpMax", 15, 0, 100);
        SILK_TOUCH_ENABLED = builder.define("silkTouchBypass", false);
        new ForgeConfigSpec(builder.build());
    }
}
