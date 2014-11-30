package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityFlying extends CustomEntityInsentient {

	public CustomEntityFlying(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityFlyingHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityFlyingHelper",
								"temp.CustomEntityFlyingHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityInsentientHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
