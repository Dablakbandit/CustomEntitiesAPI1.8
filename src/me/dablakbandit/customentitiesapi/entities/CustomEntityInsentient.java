package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityInsentient extends CustomEntityLiving {

	public CustomEntityInsentient(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityInsentientHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityInsentientHelper",
								"temp.CustomEntityInsentientHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityLivingHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalAll() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalAll",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalFloatDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalFloat", Object.class)
					.invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalFloat() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalFloat",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalEatTileDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalEatTile",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalEatTile() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalEatTile",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayer(float f, float f2) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalLookAtPlayer",
					Object.class, float.class, float.class).invoke(null,
					entity, f, f2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Deprecated
	public void newGoalSelectorPathfinderGoalLookAtPlayer(String class0,
			float f, float f2) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalLookAtPlayer",
					Object.class, String.class, float.class, float.class)
					.invoke(null, entity, class0, f, f2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayer(EntityName en,
			float f, float f2) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalLookAtPlayer",
					Object.class, String.class, float.class, float.class)
					.invoke(null, entity, en.getName(), f, f2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayer(float f) {
		newGoalSelectorPathfinderGoalLookAtPlayer(f, 0.02F);
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayer(EntityName en, float f) {
		newGoalSelectorPathfinderGoalLookAtPlayer(en, f, 0.02F);
	}

	public void removeGoalSelectorPathfinderGoalLookAtPlayer() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalLookAtPlayer",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalRandomLookaroundDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalRandomLookaround",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalRandomLookaround() {
		try {
			helper.getMethod(
					"removeGoalSelectorPathfinderGoalRandomLookaround",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalBreakDoorDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalBreakDoor",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalBreakDoor() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalBreakDoor",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalOpenDoor(boolean b) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalOpenDoor",
					Object.class, boolean.class).invoke(null, entity, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalOpenDoor() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalOpenDoor",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Deprecated
	public void newGoalSelectorPathfinderGoalInteract(String class0, float f,
			float f2) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalInteract",
					Object.class, String.class, float.class, float.class)
					.invoke(null, entity, class0, f, f2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalInteract(EntityName en, float f,
			float f2) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalInteract",
					Object.class, String.class, float.class, float.class)
					.invoke(null, entity, en.getName(), f, f2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalInteract(float f, float f2) {
		newGoalSelectorPathfinderGoalInteract(EntityName.ENTITYPLAYER, f, f2);
	}

	public void newGoalSelectorPathfinderGoalInteract(float f) {
		newGoalSelectorPathfinderGoalInteract(f, 0.02F);
	}

	public void removeGoalSelectorPathfinderGoalInteract(Object insentient) {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalInteract",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCustomName() {
		try {
			return (String) entity.getClass().getMethod("getCustomName")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean getCustomNameVisible() {
		try {
			return (Boolean) entity.getClass()
					.getMethod("getCustomNameVisible").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getName() {
		try {
			return (String) entity.getClass().getMethod("getName")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setCustomName(String s) {
		try {
			entity.getClass().getMethod("setCustomName", String.class)
					.invoke(entity, s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCustomNameVisible(boolean flag) {
		try {
			entity.getClass().getMethod("setCustomNameVisible", boolean.class)
					.invoke(entity, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasCustomName() {
		try {
			return (Boolean) entity.getClass().getMethod("hasCustomName")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
