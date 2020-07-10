package plugin.main;

import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChunkInfo implements CommandExecutor {
    private FirstPlugin plugin;
    public ChunkInfo(FirstPlugin firstPlugin) {
        this.plugin = firstPlugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        Chunk Ch = p.getLocation().getChunk();
        String townname;
        try {
            townname = FirstPlugin.TownBlock.get(Ch).getName();
        } catch (NullPointerException e) {
            p.sendMessage("Пустой чанк");
            return true;
        }

        int x = Ch.getX();
        int z = Ch.getZ();
        p.sendMessage("Чанк с координатами X=" +x + " Z=" + z + "находится под владением города" + townname +"." );
        return true;
    }
}
