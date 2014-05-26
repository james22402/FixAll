/**
 * @author james22402
 * @version 1.0
 */


package james22402.fixallmodification.FixAll;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class FixAll extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("§1[§bFixAll§1]§9 has been Activated!");
		Bukkit.broadcastMessage("§1[§bFixAll§1]§9 Is Enabled Successfully!");
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player player = (Player) sender;
		{
			if (cmd.getName().equalsIgnoreCase("fixall")) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("This command can only be run by a player.");
				}
				else {
					repairItems(player);
				}
			}
		}		return false;
	}
	
	public void repairItems(Player p) {
		ItemStack[] item = p.getInventory().getContents();
		for (ItemStack i : item) {
			if(i.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "[Emerald]") || i.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "[" + ChatColor.LIGHT_PURPLE + "Bedrock" + ChatColor.DARK_GREEN + "]"))
			{
				try {
					p.sendMessage("Success!");
					i.setDurability((short) 0);
				} catch (Exception e) {

				}
			}
		}
	}
}