package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityCreeper extends CustomEntityMonster {

	public CustomEntityCreeper() {
		super("CustomEntityCreeper");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityCreeper(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityCreeper(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityCreeper(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityCreeperClass() {
		try {
			return Class.forName("temp.CustomEntityCreeper");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityCreeper");
			helper = Class.forName("temp.CustomEntityCreeperHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityCreeper");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityCreeperHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityCreeperHelper",
								"temp.CustomEntityCreeperHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntityCreeper = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityCreeper");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityCreeper");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityCreeper);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityCreeperHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityCreeperHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityCreeperHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityCreeper", 50,
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
