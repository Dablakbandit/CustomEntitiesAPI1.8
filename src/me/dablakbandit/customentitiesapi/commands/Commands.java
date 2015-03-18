package me.dablakbandit.customentitiesapi.commands;

import me.dablakbandit.customentitiesapi.entities.*;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String Label, String[] args) {
		if(s instanceof Player){			
			/*Skeleton s1 = (Skeleton) Bukkit.getWorlds().get(0).spawnEntity(((Player)s).getLocation(), EntityType.SKELETON);
			s1.getEquipment().setItemInHand(new ItemStack(Material.BOW));
			CustomEntitySkeleton s2 = CustomEntities.getCustomEntitySkeleton(s1);
			s2.removeGoalSelectorPathfinderGoalAll();
			s2.setGoalSelectorDefaultPathfinderGoals();
			s2.setDamageable(false);*/
			//Player player = (Player)s;
			
			
			Location location = ((Player)s).getLocation();
			CustomEntityRabbit cer = CustomEntities.getNewCustomEntityRabbit(location);
			cer.setUnableToMove();
			cer.setUnpushable();
			
			
			/*CustomEntityZombie cez = CustomEntities.getNewCustomEntityZombie(location);
	        cez.removeGoalSelectorPathfinderGoalAll();
	        cez.newGoalSelectorPathfinderGoalRandomLookaroundDefault();
	        cez.setUnpushable();
	        cez.setUnableToMove();
	        cez.setUndamageable();

	        Zombie zombie = (Zombie)cez.getBukkitEntity();
	        zombie.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Test");
	        zombie.setCustomNameVisible(true);
	        zombie.setMaxHealth(1000.0D);
	        zombie.setHealth(1000.0D);
	        zombie.setCanPickupItems(false);
	        zombie.setBaby(false);
	        zombie.setVillager(false);
	        zombie.setRemoveWhenFarAway(false);
	        zombie.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
	        zombie.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
	        zombie.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
	        zombie.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));*/
	        
		}
		return false;
	}

}
