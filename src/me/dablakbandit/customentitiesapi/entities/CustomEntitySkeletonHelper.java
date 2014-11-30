package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class CustomEntitySkeletonHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object skeleton) {
		removeGoalSelectorPathfinderGoalAll(skeleton);
	}

	public static void setAbleToMove(Object skeleton) {
		newGoalSelectorPathfinderGoalRandomStroll(skeleton, 1D);
	}

	public static void setAbleToMove(Object skeleton, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(skeleton, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object skeleton) {
		newGoalSelectorPathfinderGoalFloat(skeleton);
		newGoalSelectorPathfinderGoalRestrictSun(skeleton);
		newGoalSelectorPathfinderGoalFleeSun(skeleton, 1.0D);
		newGoalSelectorPathfinderGoalRandomStroll(skeleton, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(skeleton, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(skeleton);
		// TODO
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");

			Field equipment = entityinsentient.getDeclaredField("equipment");
			equipment.setAccessible(true);
			Object item = equipment.get(entityinsentient.cast(skeleton));

			Object i = unpack(item)[0];
			try {
				Class<?> items = Class.forName("net.minecraft.server."
						+ getVersion() + "Items");
				try {
					if (i != null
							&& i.getClass().getMethod("getItem").invoke(i) == items
									.getDeclaredField("BOW").get(null)) {
						newGoalSelectorPathfinderGoalArrowAttack(skeleton,
								1.0D, 20, 60, 15.0F);
					} else {
						newGoalSelectorPathfinderGoalMeleeAttack(skeleton,
								"EntityHuman", 1.2D, false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				Class<?> items = Class.forName("net.minecraft.server."
						+ getVersion() + "Items");
				try {
					Object o = i.getClass().getMethod("getItem").invoke(i);
					Object bow = items.getDeclaredField("BOW").get(null);
					if (i != null
							&& o.getClass().getField("id").get(o) == bow
									.getClass().getField("id").get(bow)) {
						newGoalSelectorPathfinderGoalArrowAttack(skeleton,
								1.0D, 20, 60, 15.0F);
					} else {
						newGoalSelectorPathfinderGoalMeleeAttack(skeleton,
								"EntityHuman", 1.2D, false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Object[] unpack(Object array) {
		Object[] array2 = new Object[Array.getLength(array)];
		for (int i = 0; i < array2.length; i++)
			array2[i] = Array.get(array, i);
		return array2;
	}

	public static void newGoalSelectorPathfinderGoalArrowAttack(
			Object skeleton, double d, int i, int i1, float f) {
		try {
			Class<?> irangedentity = getNMSClass("IRangedEntity");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(skeleton);

			Class<?> pathfindergoalarrowattack = getNMSClass("PathfinderGoalArrowAttack");
			Object o = pathfindergoalarrowattack.getConstructor(irangedentity,
					double.class, int.class, int.class, float.class)
					.newInstance(irangedentity.cast(skeleton), d, i, i1, f);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalArrowAttack(
			Object creature) {
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalArrowAttack");
	}
}
