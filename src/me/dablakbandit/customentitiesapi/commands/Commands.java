package me.dablakbandit.customentitiesapi.commands;

import me.dablakbandit.customentitiesapi.entities.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
			CustomEntityRabbit cer = CustomEntities.getNewCustomEntityRabbit(((Player)s).getLocation());
			cer.setUnableToMove();
			cer.setUnpushable();
		}
		return false;
	}

}
