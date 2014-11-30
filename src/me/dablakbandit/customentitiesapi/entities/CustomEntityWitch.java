package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityWitch extends CustomEntityMonster {

	public CustomEntityWitch() {
		super("CustomEntityWitch");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityWitch(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityWitch(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityWitch(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityWitchClass() {
		try {
			return Class.forName("temp.CustomEntityWitch");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityWitch");
			helper = Class.forName("temp.CustomEntityWitchHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityWitch");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityWitchHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityWitchHelper",
								"temp.CustomEntityWitchHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntityWitch = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityWitch");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityWitch");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityWitch);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityWitchHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityWitchHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityWitchHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityWitch", 66,
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
