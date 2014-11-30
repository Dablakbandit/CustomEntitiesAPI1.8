package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

public class CustomEntitySheepHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object sheep) {
		removeGoalSelectorPathfinderGoalAll(sheep);
	}

	public static void setAbleToMove(Object sheep) {
		newGoalSelectorPathfinderGoalRandomStroll(sheep, 1D);
	}

	public static void setAbleToMove(Object sheep, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(sheep, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object sheep) {
		removeGoalSelectorPathfinderGoalAll(sheep);
		newGoalSelectorPathfinderGoalFloat(sheep);
		newGoalSelectorPathfinderGoalPanic(sheep, 1.25D);
		newGoalSelectorPathfinderGoalBreed(sheep, 1.0D);
		newGoalSelectorPathfinderGoalTempt(sheep, 1.1D, "WHEAT", false);
		newGoalSelectorPathfinderGoalFollowParent(sheep, 1.1D);
		newGoalSelectorPathfinderGoalEatTile(sheep);
		newGoalSelectorPathfinderGoalRandomStroll(sheep, 1.D);
		newGoalSelectorPathfinderGoalLookAtPlayer(sheep, 6.0F, 0.02F);
		newGoalSelectorPathfinderGoalRandomLookaround(sheep);
	}

	public static Object getInventoryCrafting(Object sheep) {
		try {
			Class<?> entitysheep = getNMSClass("EntitySheep");
			Field f = entitysheep.getDeclaredField("bk");
			f.setAccessible(true);
			return f.get(sheep);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
