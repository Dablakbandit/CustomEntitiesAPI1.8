package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;
import ja.CtConstructor;
import ja.CtField;
import ja.CtNewConstructor;
import ja.CtNewMethod;
import ja.CtPrimitiveType;
import ja.LoaderClassPath;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityVillager extends CustomEntityAgeable {

	public CustomEntityVillager() {
		super("CustomEntityVillager");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityVillager(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityVillager(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {

		}
	}

	public CustomEntityVillager(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityVillagerClass() {
		try {
			return Class.forName("temp.CustomEntityVillager");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityVillager");
			helper = Class.forName("temp.CustomEntityVillagerHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityVillager");
		} catch (Exception e1) {
			try {
				cp.appendClassPath(new LoaderClassPath(
						CustomEntityVillager.class.getClassLoader()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityVillagerHelper",
								"temp.CustomEntityVillagerHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAgeableHelper"));
				ces.toClass();
				CtClass EntityVillager = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityVillager");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityVillager");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityLiving");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "ItemStack");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityHuman");
				cp.importPackage("temp");
				fields.add(new CtField(CtClass.booleanType, "tradeable",
						ctClass));
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityVillager);
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "NBTTagCompound");
				methods.remove("public void b(NBTTagCompound nbt){"
						+ "super.a(nbt);"
						+ "nbt.setBoolean(\"pushable\", this.pushable);" + "}");
				methods.remove("public void a(NBTTagCompound nbt){"
						+ "super.a(nbt);" + "if(nbt.hasKey(\"pushable\")){"
						+ "this.pushable = nbt.getBoolean(\"pushable\");"
						+ "}else{" + "this.pushable = true;" + "}" + "}");
				methods.add("public void b(NBTTagCompound nbt){"
						+ "super.a(nbt);"
						+ "nbt.setBoolean(\"tradeable\", this.tradeable);"
						+ "nbt.setBoolean(\"pushable\", this.pushable);" + "}");
				methods.add("public void a(NBTTagCompound nbt){"
						+ "super.a(nbt);" + "if(nbt.hasKey(\"tradeable\")){"
						+ "this.tradeable= nbt.getBoolean(\"tradeable\");"
						+ "}else{" + "this.tradeable = true;" + "}"
						+ "if(nbt.hasKey(\"pushable\")){"
						+ "this.pushable = nbt.getBoolean(\"pushable\");"
						+ "}else{" + "this.pushable = true;" + "}" + "}");
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityVillagerHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityVillagerHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityVillagerHelper.setAbleToMove(this, d);"
						+ "}");
				methods.add("public boolean a(EntityHuman paramEntityHuman){"
						+ "if(!this.tradeable)return false;"
						+ "return super.a(paramEntityHuman);" + "}");
				for (String m : methods) {
					ctClass.addMethod(CtNewMethod.make(m, ctClass));
				}
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "World");
				CtConstructor con = CtNewConstructor.make(
						new CtClass[] {
								cp.get("net.minecraft.server."
										+ NMSUtils.getVersion() + "World"),
								CtPrimitiveType.intType }, null, ctClass);
				con.insertAfter("this.tradeable = true;");
				ctClass.addConstructor(con);
				con = CtNewConstructor.make(
						new CtClass[] { cp.get("net.minecraft.server."
								+ NMSUtils.getVersion() + "World") }, null,
						ctClass);
				ctClass.addConstructor(con);
				con.insertAfter("this.tradeable = true;");
				methods.clear();
				customentity = ctClass.toClass();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (customentity != null)
			CustomEntitiesAPI.getInstance().registerEntity("EntityVillager",
					120, customentity);
	}

	public void setGoalSelectorDefaultPathfinderGoals() {
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalAvoidPlayerDefault() {
		newGoalSelectorPathfinderGoalAvoidPlayer(EntityName.ENTITYZOMBIE, 8.0F,
				0.6D, 0.6D);
	}

	public void newGoalSelectorPathfinderGoalTradeWithPlayerDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalTradeWithPlayer",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalTradeWithPlayer() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalTradeWithPlayer",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalLookAtTradingPlayerDefault() {
		try {
			helper.getMethod(
					"newGoalSelectorPathfinderGoalLookAtTradingPlayer",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalLookAtTradingPlayer() {
		try {
			helper.getMethod(
					"removeGoalSelectorPathfinderGoalLookAtTradingPlayer",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalOpenDoorDefault() {
		newGoalSelectorPathfinderGoalOpenDoor(true);
	}

	public void newGoalSelectorPathfinderGoalMoveTowardsRestrictionDefault() {
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(0.6D);
	}

	public void newGoalSelectorPathfinderGoalMakeLoveDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMakeLove",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMakeLove() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalMakeLove",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalTakeFlowerDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalTakeFlower",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalTakeFlower() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalTakeFlower",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalPlay(double d) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalPlay", Object.class,
					double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalPlayDefault() {
		newGoalSelectorPathfinderGoalPlay(0.32D);
	}

	public void removeGoalSelectorPathfinderGoalPlay() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalPlay",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalInteractDefault() {
		newGoalSelectorPathfinderGoalInteract(EntityName.ENTITYHUMAN, 3.0F,
				1.0F);
	}

	public void newGoalSelectorPathfinderGoalInteractVillagersDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalInteractVillagers",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalRandomStrollDefault() {
		newGoalSelectorPathfinderGoalRandomStroll(0.6D);
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault() {
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYINSENTIENT,
				8.0F);
	}

	public int getProfession() {
		try {
			return (int) entity.getClass().getMethod("getProfession")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void setProfession(int i) {
		try {
			entity.getClass().getMethod("setProfession", int.class)
					.invoke(entity, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void setTradeable() {
		try {
			helper.getMethod("setTradeable", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void setTradeable(boolean value) {
		if (value) {
			setTradeable();
		} else {
			setUntradeable();
		}
	}

	public final void setUntradeable() {
		try {
			helper.getMethod("setUntradeable", Object.class).invoke(null,
					entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void setUntradeable(boolean value) {
		if (value) {
			setUntradeable();
		} else {
			setTradeable();
		}
	}

}
