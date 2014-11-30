package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityTameableAnimal extends CustomEntityAnimal {

	public CustomEntityTameableAnimal(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityTameableAnimalHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityTameableAnimalHelper",
								"temp.CustomEntityTameableAnimalHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
