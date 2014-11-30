package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public class CustomEntityGolem extends CustomEntityCreature {

	public CustomEntityGolem(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityGolemHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityGolemHelper",
								"temp.CustomEntityGolemHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityCreatureHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
