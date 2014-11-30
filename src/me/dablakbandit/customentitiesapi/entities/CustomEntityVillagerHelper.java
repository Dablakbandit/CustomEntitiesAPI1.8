package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

public class CustomEntityVillagerHelper extends CustomEntityAgeableHelper {

	public static void setUnableToMove(Object villager) {
		removeGoalSelectorPathfinderGoalAll(villager);
	}

	public static void setAbleToMove(Object villager) {
		newGoalSelectorPathfinderGoalRandomStroll(villager, 1D);
	}

	public static void setAbleToMove(Object villager, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(villager, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object villager) {
		newGoalSelectorPathfinderGoalFloat(villager);
		newGoalSelectorPathfinderGoalAvoidPlayer(villager, "EntityZombie",
				8.0F, 0.6D, 0.6D);
		newGoalSelectorPathfinderGoalTradeWithPlayer(villager);
		newGoalSelectorPathfinderGoalLookAtTradingPlayer(villager);
		newGoalSelectorPathfinderGoalMoveIndoors(villager);
		newGoalSelectorPathfinderGoalRestrictOpenDoor(villager);
		newGoalSelectorPathfinderGoalOpenDoor(villager, true);
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(villager, 0.6D);
		newGoalSelectorPathfinderGoalMakeLove(villager);
		newGoalSelectorPathfinderGoalTakeFlower(villager);
		newGoalSelectorPathfinderGoalPlay(villager, 0.32D);
		newGoalSelectorPathfinderGoalInteract(villager, "EntityHuman", 3.0F,
				1.0F);
		newGoalSelectorPathfinderGoalInteractVillagers(villager);
		newGoalSelectorPathfinderGoalRandomStroll(villager, 0.6D);
		newGoalSelectorPathfinderGoalLookAtPlayer(villager, "EntityInsentient",
				8.0F);
	}

	public static void newGoalSelectorPathfinderGoalInteractVillagers(
			Object villager) {
		try {
			Class<?> entityvillager = getNMSClass("EntityVillager");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(villager);

			Class<?> pathfindergoalinteractvillagers = getNMSClass("PathfinderGoalInteractVillagers");
			Object o = pathfindergoalinteractvillagers.getConstructor(
					entityvillager).newInstance(entityvillager.cast(villager));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 6, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalInteractVillagers(
			Object villager) {
		removeGoalSelectorPathFinderGoal(villager,
				"PathfinderGoalInteractVillagers");
	}

	public static void newGoalSelectorPathfinderGoalTradeWithPlayer(
			Object villager) {
		try {
			Class<?> entityvillager = getNMSClass("EntityVillager");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(villager);

			Class<?> pathfindergoaltradewithplayer = getNMSClass("PathfinderGoalTradeWithPlayer");
			Object o = pathfindergoaltradewithplayer.getConstructor(
					entityvillager).newInstance(entityvillager.cast(villager));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 1, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalTradeWithPlayer(
			Object villager) {
		removeGoalSelectorPathFinderGoal(villager,
				"PathfinderGoalTradeWithPlayer");
	}

	public static void newGoalSelectorPathfinderGoalLookAtTradingPlayer(
			Object villager) {
		try {
			Class<?> entityvillager = getNMSClass("EntityVillager");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(villager);

			Class<?> pathfindergoallookattradingplayer = getNMSClass("PathfinderGoalLookAtTradingPlayer");
			Object o = pathfindergoallookattradingplayer.getConstructor(
					entityvillager).newInstance(entityvillager.cast(villager));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 1, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalLookAtTradingPlayer(
			Object villager) {
		removeGoalSelectorPathFinderGoal(villager,
				"PathfinderGoalLookAtTradingPlayer");
	}

	public static void newGoalSelectorPathfinderGoalMakeLove(Object villager) {
		try {
			Class<?> entityvillager = getNMSClass("EntityVillager");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(villager);

			Class<?> pathfindergoalmakelove = getNMSClass("PathfinderGoalMakeLove");
			Object o = pathfindergoalmakelove.getConstructor(entityvillager)
					.newInstance(entityvillager.cast(villager));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 6, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalMakeLove(Object villager) {
		removeGoalSelectorPathFinderGoal(villager, "PathfinderGoalMakeLove");
	}

	public static void newGoalSelectorPathfinderGoalTakeFlower(Object villager) {
		try {
			Class<?> entityvillager = getNMSClass("EntityVillager");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(villager);

			Class<?> pathfindergoaltakeflower = getNMSClass("PathfinderGoalTakeFlower");
			Object o = pathfindergoaltakeflower.getConstructor(entityvillager)
					.newInstance(entityvillager.cast(villager));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 6, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalTakeFlower(
			Object villager) {
		removeGoalSelectorPathFinderGoal(villager, "PathfinderGoalTakeFlower");
	}

	public static void newGoalSelectorPathfinderGoalPlay(Object villager,
			double d) {
		try {
			Class<?> entityvillager = getNMSClass("EntityVillager");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(villager);

			Class<?> pathfindergoalplay = getNMSClass("PathfinderGoalPlay");
			Object o = pathfindergoalplay.getConstructor(entityvillager,
					double.class).newInstance(entityvillager.cast(villager), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 6, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalPlay(Object villager) {
		removeGoalSelectorPathFinderGoal(villager, "PathfinderGoalPlay");
	}

	public static void setTradeable(Object villager) {
		try {
			Field f = villager.getClass().getDeclaredField("tradeable");
			f.setAccessible(true);
			f.set(villager, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setUntradeable(Object villager) {
		try {
			Field f = villager.getClass().getDeclaredField("tradeable");
			f.setAccessible(true);
			f.set(villager, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
