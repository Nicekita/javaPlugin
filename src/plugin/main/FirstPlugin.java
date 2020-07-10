package plugin.main;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public class FirstPlugin extends JavaPlugin {
    Logger log = Logger.getLogger("Minecraft");
    public static HashMap<Chunk,Town> TownBlock = new HashMap<Chunk,Town>();
    @Override
    public void onDisable() {
        getLogger().info("enabled!");
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventsHandler(),this);
        getLogger().info("disabled!");
        getCommand("setprivate").setExecutor(new Commander(this));
        getCommand("chunkinfo").setExecutor(new ChunkInfo(this));
    }
}
