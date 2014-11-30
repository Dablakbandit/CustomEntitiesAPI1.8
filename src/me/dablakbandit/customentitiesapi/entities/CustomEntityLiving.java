package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityLiving extends CustomEntity {

	public CustomEntityLiving(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityLivingHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityLivingHelper",
								"temp.CustomEntityLivingHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getExpReward() {
		try {
			return (int) entity.getClass().getMethod("getExpReward")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public float getHeadHeight() {
		try {
			return (Float) entity.getClass().getMethod("getHeadHeight")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0F;
		}
	}

	public float getHeadRotation() {
		try {
			return (Float) entity.getClass().getMethod("getHeadRotation")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0F;
		}
	}

	public float getHealth() {
		try {
			return (Float) entity.getClass().getMethod("getHealth")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0F;
		}
	}

	public float getMaxHealth() {
		try {
			return (Float) entity.getClass().getMethod("getMaxHealth")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0F;
		}
	}

	public void setHealth(float arg0) {
		try {
			entity.getClass().getMethod("setHealth", float.class)
					.invoke(entity, arg0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSprinting(boolean flag) {
		try {
			entity.getClass().getMethod("setSprinting", boolean.class)
					.invoke(entity, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasEffect(int i) {
		try {
			return (Boolean) entity.getClass()
					.getMethod("hasEffect", int.class).invoke(entity, i);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void heal(float f) {
		try {
			entity.getClass().getMethod("heal", float.class).invoke(entity, f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setIAttribute(CustomIAttribute ia, double value) {
		try {
			helper.getMethod("setIAttribute", Object.class, String.class,
					double.class).invoke(null, entity, ia.name(), value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double getIAttribute(CustomIAttribute ia) {
		try {
			return (double) helper.getMethod("getIAttribute", Object.class,
					String.class).invoke(null, entity, ia.name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0D;
	}

}
