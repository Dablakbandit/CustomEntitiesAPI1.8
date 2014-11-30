package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityMonster extends CustomEntityCreature {

	public CustomEntityMonster(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityMonsterHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityMonsterHelper",
								"temp.CustomEntityMonsterHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityCreatureHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
