package plugin.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commander implements CommandExecutor {
    private FirstPlugin plugin;
    public Commander(FirstPlugin firstPlugin) {
        this.plugin = firstPlugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;

        FirstPlugin.TownBlock.put(p.getLocation().getChunk(),new Town(p.getName()));
        return true;
    }
}
