package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityAgeable extends CustomEntityCreature {

	public CustomEntityAgeable(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityAgeableHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityAgeableHelper",
								"temp.CustomEntityAgeableHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityCreatureHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getAge() {
		try {
			return (int) entity.getClass().getMethod("getAge").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void setAge(int i) {
		try {
			entity.getClass().getMethod("setAge", int.class).invoke(entity, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
