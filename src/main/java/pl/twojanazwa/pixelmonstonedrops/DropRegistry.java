
package pl.twojanazwa.pixelmonstonedrops;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class DropRegistry {

    private static final Map<Item, Integer> DROPS = new HashMap<>();
    private static final Random RANDOM = new Random();

    public static void init() {
        ForgeRegistries.ITEMS.getValues().forEach(item -> {
            String id = ForgeRegistries.ITEMS.getKey(item).toString();
            if (id.contains("pixelmon:")) {
                if (id.contains("platinum")) DROPS.put(item, 1);
                else if (id.contains("ore")) DROPS.put(item, 5);
                else if (id.contains("shard")) DROPS.put(item, 10);
                else if (id.contains("evolution")) DROPS.put(item, 3);
                else if (id.contains("pokeball")) DROPS.put(item, 8);
            }
        });
    }

    public static Item getRandomDrop(int fortune) {
        List<Item> pool = new ArrayList<>();
        DROPS.forEach((item, weight) -> {
            int finalWeight = weight + fortune * 2;
            for (int i = 0; i < finalWeight; i++) pool.add(item);
        });
        return pool.get(RANDOM.nextInt(pool.size()));
    }
}
