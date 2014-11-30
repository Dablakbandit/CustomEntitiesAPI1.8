package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityAnimal extends CustomEntityAgeable {

	public CustomEntityAnimal(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityAnimalHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityAnimalHelper",
								"temp.CustomEntityAnimalHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAgeableHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalBreed(double d) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalBreed",
					Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalBreed() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalPanic",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalFollowParent(double d) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalFollowParent",
					Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalFollowParent() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalFollowParent",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
