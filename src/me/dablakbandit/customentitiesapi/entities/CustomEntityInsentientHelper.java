package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("rawtypes")
public class CustomEntityInsentientHelper extends CustomEntityLivingHelper {

	public static void removeGoalSelectorPathfinderGoalAll(Object insentient) {
		try {

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalselector = goalselector.getClass();

			Field f = pathfindergoalselector.getDeclaredField("a");
			if (f.getType().getSimpleName().equals("List")) {
				f.setAccessible(true);

				List b = (List) f.get(goalselector);

				Iterator iterator = b.iterator();
				while (iterator.hasNext()) {
					iterator.next();
					iterator.remove();
				}
			} else {
				f = pathfindergoalselector.getDeclaredField("b");
				f.setAccessible(true);

				List b = (List) f.get(goalselector);

				Iterator iterator = b.iterator();
				while (iterator.hasNext()) {
					iterator.next();
					iterator.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void newGoalSelectorPathfinderGoalEatTile(Object insentient) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoaleattile = getNMSClass("PathfinderGoalEatTile");
			Object o = pathfindergoaleattile.getConstructor(entityinsentient)
					.newInstance(entityinsentient.cast(insentient));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 5, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalEatTile(Object insentient) {
		removeGoalSelectorPathFinderGoal(insentient, "PathfinderGoalEatTile");
	}

	public static Object getGoalSelector(Object insentient) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");

			Field goal = entityinsentient.getDeclaredField("goalSelector");
			goal.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(goal, goal.getModifiers() & ~Modifier.FINAL);

			Object goalselector = goal.get(entityinsentient.cast(insentient));
			return goalselector;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void newGoalSelectorPathfinderGoalRandomLookaround(
			Object insentient) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalrandomlookaround = getNMSClass("PathfinderGoalRandomLookaround");
			Object o = pathfindergoalrandomlookaround.getConstructor(
					entityinsentient).newInstance(
					entityinsentient.cast(insentient));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 8, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalRandomLookaround(
			Object insentient) {
		removeGoalSelectorPathFinderGoal(insentient,
				"PathfinderGoalRandomLookaround");
	}

	public static void newGoalSelectorPathfinderGoalFloat(Object insentient) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalfloat = getNMSClass("PathfinderGoalFloat");
			Object o = pathfindergoalfloat.getConstructor(entityinsentient)
					.newInstance(entityinsentient.cast(insentient));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 0, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalFloat(Object insentient) {
		removeGoalSelectorPathFinderGoal(insentient, "PathfinderGoalFloat");
	}

	public static void removeGoalSelectorPathFinderGoal(Object insentient,
			String string) {
		try {
			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalselector = goalselector.getClass();

			Field f = pathfindergoalselector.getDeclaredField("b");
			f.setAccessible(true);

			List b = (List) f.get(goalselector);

			Class<?> pathfindergoalselectoritem = getNMSClass("PathfinderGoalSelectorItem");
			Field f1 = pathfindergoalselectoritem.getDeclaredField("a");
			f1.setAccessible(true);

			Iterator iterator = b.iterator();
			while (iterator.hasNext()) {
				Object o = pathfindergoalselectoritem.cast(iterator.next());
				if (f1.get(o).getClass().getSimpleName().equals(string)) {
					iterator.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalselector = goalselector.getClass();

			Field f = pathfindergoalselector.getDeclaredField("a");
			if (f.getType().getSimpleName().equals("List")) {
				f.setAccessible(true);

				List b = (List) f.get(goalselector);

				Class<?> pathfindergoalselectoritem = getNMSClass("PathfinderGoalSelectorItem");
				Field f1 = pathfindergoalselectoritem.getDeclaredField("a");
				f1.setAccessible(true);

				Iterator iterator = b.iterator();
				while (iterator.hasNext()) {
					Object o = pathfindergoalselectoritem.cast(iterator.next());
					if (f1.get(o).getClass().getSimpleName().equals(string)) {
						iterator.remove();
					}
				}
			} else {
				f = pathfindergoalselector.getDeclaredField("b");
				f.setAccessible(true);

				List b = (List) f.get(goalselector);

				Class<?> pathfindergoalselectoritem = getNMSClass("PathfinderGoalSelectorItem");
				Field f1 = pathfindergoalselectoritem.getDeclaredField("a");
				f1.setAccessible(true);

				Iterator iterator = b.iterator();
				while (iterator.hasNext()) {
					Object o = pathfindergoalselectoritem.cast(iterator.next());
					if (f1.get(o).getClass().getSimpleName().equals(string)) {
						iterator.remove();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void newGoalSelectorPathfinderGoalLookAtPlayer(
			Object insentient, String class0, float f, float f2) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoallookatplayer = getNMSClass("PathfinderGoalLookAtPlayer");
			Class<?> entity = getNMSClass(class0);
			Object o = pathfindergoallookatplayer.getConstructor(
					entityinsentient, Class.class, float.class, float.class)
					.newInstance(entityinsentient.cast(insentient), entity, f,
							f2);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 7, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void newGoalSelectorPathfinderGoalLookAtPlayer(
			Object insentient, float f, float f2) {
		newGoalSelectorPathfinderGoalLookAtPlayer(insentient, "EntityHuman", f,
				f2);
	}

	public static void newGoalSelectorPathfinderGoalLookAtPlayer(
			Object insentient, String class0, float f) {
		newGoalSelectorPathfinderGoalLookAtPlayer(insentient, f, 0.02F);
	}

	public static void newGoalSelectorPathfinderGoalLookAtPlayer(
			Object insentient, float f) {
		newGoalSelectorPathfinderGoalLookAtPlayer(insentient, f, 0.02F);
	}

	public static void removeGoalSelectorPathfinderGoalLookAtPlayer(
			Object insentient) {
		removeGoalSelectorPathFinderGoal(insentient,
				"PathfinderGoalLookAtPlayer");
	}

	public static void newGoalSelectorPathfinderGoalBreakDoor(Object insentient) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalbreakdoor = getNMSClass("PathfinderGoalBreakDoor");
			Object o = pathfindergoalbreakdoor.getConstructor(entityinsentient)
					.newInstance(entityinsentient.cast(insentient));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 2, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalBreakDoor(
			Object insentient) {
		removeGoalSelectorPathFinderGoal(insentient, "PathfinderGoalBreakDoor");
	}

	public static void newGoalSelectorPathfinderGoalOpenDoor(Object insentient,
			boolean b) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalopendoor = getNMSClass("PathfinderGoalOpenDoor");
			Object o = pathfindergoalopendoor.getConstructor(entityinsentient,
					boolean.class).newInstance(
					entityinsentient.cast(insentient), b);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalOpenDoor(
			Object insentient) {
		removeGoalSelectorPathFinderGoal(insentient, "PathfinderGoalOpenDoor");
	}

	public static void newGoalSelectorPathfinderGoalInteract(Object insentient,
			String class0, float f, float f2) {
		try {
			Class<?> entityinsentient = getNMSClass("EntityInsentient");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(insentient);

			Class<?> pathfindergoalinteract = getNMSClass("PathfinderGoalInteract");
			Class<?> entity = getNMSClass(class0);
			Object o = pathfindergoalinteract.getConstructor(entityinsentient,
					Class.class, float.class, float.class).newInstance(
					entityinsentient.cast(insentient), entity, f, f2);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 9, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void newGoalSelectorPathfinderGoalInteract(Object insentient,
			float f, float f2) {
		newGoalSelectorPathfinderGoalInteract(insentient, "EntityHuman", f, f2);
	}

	public static void newGoalSelectorPathfinderGoalInteract(Object insentient,
			float f) {
		newGoalSelectorPathfinderGoalInteract(insentient, f, 0.02F);
	}

	public static void removeGoalSelectorPathfinderGoalInteract(
			Object insentient) {
		removeGoalSelectorPathFinderGoal(insentient, "PathfinderGoalInteract");
	}
}
