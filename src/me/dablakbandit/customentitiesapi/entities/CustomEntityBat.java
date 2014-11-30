package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityBat extends CustomEntityAmbient {

	public CustomEntityBat() {
		super("CustomEntityBat");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityBat(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityBat(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityBat(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityBatClass() {
		try {
			return Class.forName("temp.CustomEntityBat");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityBat");
			helper = Class.forName("temp.CustomEntityBatHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityBat");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityBatHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityBatHelper",
								"temp.CustomEntityBatHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAmbientHelper"));
				ces.toClass();
				CtClass EntityBat = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityBat");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityBat");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityAmbient");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityBat);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityBatHelper.setUnableToMove(this);" + "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityBatHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityBatHelper.setAbleToMove(this, d);" + "}");
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityBat", 65,
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
