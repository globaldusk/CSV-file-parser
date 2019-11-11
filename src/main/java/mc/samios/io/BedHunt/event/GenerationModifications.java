package mc.samios.io.BedHunt.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class GenerationModifications implements Listener {
    @EventHandler
    public void loadChunk(ChunkLoadEvent e) {
        for (int y = 1; y <132; y++){
            for (int x = 0; x < 16; x++){
                for (int z = 0; z < 16; z++){
                    Block block = e.getChunk().getBlock(x, y, z);
                    if (block.getType().name().contains("_BED")){
                        block.setType(Material.STONE);
                    }
                }
            }
        }
    }
}
