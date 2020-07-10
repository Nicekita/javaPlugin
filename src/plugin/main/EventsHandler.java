package plugin.main;


import io.netty.util.Mapping;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class EventsHandler implements Listener {
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage("На сервер зашел игрок под ником "+p.getName());
    }
    @EventHandler
    public void BreakBlock(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if (isBlockPrivate(p, b.getLocation())){
            e.setCancelled(true);

            p.sendMessage("Вы не можете ломать блоки на этой территории!");
        }



    }
    @EventHandler
    public void PlaceBlock(BlockPlaceEvent e){
        Block b = e.getBlock();

        if (b.getBlockData().getMaterial().equals(Material.ANVIL)){

            e.getPlayer().sendMessage("Suck");

            FirstPlugin.TownBlock.put(b.getChunk(),new Town(e.getPlayer().getName()));
        }
    }
    private boolean isBlockPrivate(Player p, Location loc){
        if (FirstPlugin.TownBlock.get(loc.getChunk())==null)  return false;
            if(FirstPlugin.TownBlock.get(loc.getChunk()).getName().equals(p.getName())) {
            p.sendMessage("Suck2"); return false;}
        return true;

    }
}
