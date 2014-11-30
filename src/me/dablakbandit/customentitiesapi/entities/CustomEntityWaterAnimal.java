package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityWaterAnimal extends CustomEntityAnimal {

	public CustomEntityWaterAnimal(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityWaterAnimalHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityWaterAnimalHelper",
								"temp.CustomEntityWaterAnimalHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
