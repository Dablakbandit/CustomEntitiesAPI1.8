package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityChicken extends CustomEntityAnimal {

	public CustomEntityChicken() {
		super("CustomEntityChicken");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityChicken(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityChicken(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityChicken(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityChickenClass() {
		try {
			return Class.forName("temp.CustomEntityChicken");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityChicken");
			helper = Class.forName("temp.CustomEntityChickenHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityChicken");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityChickenHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityChickenHelper",
								"temp.CustomEntityChickenHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
				CtClass EntityChicken = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityChicken");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityChicken");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityAnimal");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityChicken);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityChickenHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityChickenHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityChickenHelper.setAbleToMove(this, d);"
						+ "}");
				for (String m : methods) {
					ctClass.addMethod(CtNewMethod.make(m, ctClass));
				}
				methods.clear();
				customentity = ctClass.toClass();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (customentity != null)
			CustomEntitiesAPI.getInstance().registerEntity("EntityChicken", 93,
					customentity);
	}

	public void setGoalSelectorDefaultPathfinderGoals() {
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
