package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

public class CustomEntityCreatureHelper extends CustomEntityInsentientHelper {

	public static Object getPathfinderGoalMeleeAttackbGoalTarget(Object custom) {
		try {
			Class<?> c = getNMSClass("PathfinderGoalMeleeAttack");
			Field b = c.getDeclaredField("b");
			b.setAccessible(true);
			Object a = b.get(custom);
			Class<?> ei = getNMSClass("EntityInsentient");
			return ei.getDeclaredMethod("getGoalTarget").invoke(a);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void newGoalSelectorPathfinderGoalPanic(Object creature,
			double d) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalpanic = getNMSClass("PathfinderGoalPanic");
			Object o = pathfindergoalpanic.getConstructor(entitycreature,
					double.class).newInstance(entitycreature.cast(creature), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 1, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalPanic(Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalPanic");
	}

	public static void newGoalSelectorPathfinderGoalTempt(Object creature,
			double d, String item, boolean b) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);
			Class<?> items = Class.forName("net.minecraft.server."
					+ getVersion() + "Items");
			Class<?> itemclass = Class.forName("net.minecraft.server."
					+ getVersion() + "Item");
			Class<?> pathfindergoaltempt = getNMSClass("PathfinderGoalTempt");
			Object wheat = items.getField(item).get(null);
			Object o3 = pathfindergoaltempt.getConstructor(entitycreature,
					double.class, itemclass, boolean.class).newInstance(
					entitycreature.cast(creature), d, wheat, false);
			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalTempt(Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalTempt");
	}

	public static void newGoalSelectorPathfinderGoalRandomStroll(
			Object creature, double d) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalrandomstroll = getNMSClass("PathfinderGoalRandomStroll");
			Object o = pathfindergoalrandomstroll.getConstructor(
					entitycreature, double.class).newInstance(
					entitycreature.cast(creature), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 6, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalRandomStroll(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalRandomStroll");
	}

	public static void newGoalSelectorPathfinderGoalMeleeAttack(
			Object creature, String class0, double d, boolean value) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalmeleeattack = Class
					.forName("temp.CustomPathfinderGoalMeleeAttack");
			Object o = pathfindergoalmeleeattack.getConstructor(entitycreature,
					Class.class, double.class, boolean.class).newInstance(
					entitycreature.cast(creature), getNMSClass(class0), d,
					value);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 1, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void newGoalSelectorPathfinderGoalMeleeAttack(
			Object creature, double d, boolean value) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalmeleeattack = Class
					.forName("temp.CustomPathfinderGoalMeleeAttack");
			Object o = pathfindergoalmeleeattack.getConstructor(entitycreature,
					double.class, boolean.class).newInstance(
					entitycreature.cast(creature), d, value);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 1, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalMeleeAttack(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalMeleeAttack");
		removeGoalSelectorPathFinderGoal(creature,
				"CustomPathfinderGoalMeleeAttack");
	}

	public static void newGoalSelectorPathfinderGoalMoveTowardsRestriction(
			Object creature, double d) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalmovetowardsrestriction = getNMSClass("PathfinderGoalMoveTowardsRestriction");
			Object o = pathfindergoalmovetowardsrestriction.getConstructor(
					entitycreature, double.class).newInstance(
					entitycreature.cast(creature), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 4, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalMoveTowardsRestriction(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature,
				"PathfinderGoalMoveTowardsRestriction");
	}

	public static void newGoalSelectorPathfinderGoalMoveThroughVillage(
			Object creature, double d, boolean value) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalmovethroughvillage = getNMSClass("PathfinderGoalMoveThroughVillage");
			Object o = pathfindergoalmovethroughvillage.getConstructor(
					entitycreature, double.class, boolean.class).newInstance(
					entitycreature.cast(creature), d, value);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 4, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalMoveThroughVillage(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature,
				"PathfinderGoalMoveThroughVillage");
	}

	public static void newGoalSelectorPathfinderGoalMoveIndoors(Object creature) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalmoveindoors = getNMSClass("PathfinderGoalMoveIndoors");
			Object o = pathfindergoalmoveindoors.getConstructor(entitycreature)
					.newInstance(entitycreature.cast(creature));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 2, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalMoveIndoors(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalMoveIndoors");
	}

	public static void newGoalSelectorPathfinderGoalAvoidPlayer(
			Object creature, String class0, float f, double d, double d0) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalavoidplayer = getNMSClass("PathfinderGoalAvoidPlayer");
			Object o = pathfindergoalavoidplayer.getConstructor(entitycreature,
					Class.class, float.class, double.class, double.class)
					.newInstance(entitycreature.cast(creature),
							getNMSClass(class0), f, d, d0);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 1, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalAvoidPlayer(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalAvoidPlayer");
	}

	public static void newGoalSelectorPathfinderGoalRestrictOpenDoor(
			Object creature) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalrestrictopendoor = getNMSClass("PathfinderGoalRestrictOpenDoor");
			Object o = pathfindergoalrestrictopendoor.getConstructor(
					entitycreature).newInstance(entitycreature.cast(creature));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalRestrictOpenDoor(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature,
				"PathfinderGoalRestrictOpenDoor");
	}

	public static void newGoalSelectorPathfinderGoalMoveTowardsTarget(
			Object creature, double d, float f) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalmovetowardstarget = getNMSClass("PathfinderGoalMoveTowardsTarget");
			Object o = pathfindergoalmovetowardstarget.getConstructor(
					entitycreature, double.class, float.class).newInstance(
					entitycreature.cast(creature), d, f);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalMoveTowardsTarget(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature,
				"PathfinderGoalMoveTowardsTarget");
	}

	public static void newGoalSelectorPathfinderGoalRestrictSun(Object creature) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalrestrictsun = getNMSClass("PathfinderGoalRestrictSun");
			Object o = pathfindergoalrestrictsun.getConstructor(entitycreature)
					.newInstance(entitycreature.cast(creature));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalRestrictSun(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalRestrictSun");
	}

	public static void newGoalSelectorPathfinderGoalFleeSun(Object creature,
			double d) {
		try {
			Class<?> entitycreature = getNMSClass("EntityCreature");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creature);

			Class<?> pathfindergoalfleesun = getNMSClass("PathfinderGoalFleeSun");
			Object o = pathfindergoalfleesun.getConstructor(entitycreature,
					double.class).newInstance(entitycreature.cast(creature), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalFleeSun(Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalFleeSun");
	}

}
