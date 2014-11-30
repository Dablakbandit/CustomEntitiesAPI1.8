package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityAmbient extends CustomEntityInsentient {

	public CustomEntityAmbient(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityAmbientHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityAmbientHelper",
								"temp.CustomEntityAmbientHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityInsentientHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
