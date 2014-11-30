package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityEnderDragon extends CustomEntityInsentient {

	public CustomEntityEnderDragon() {
		super("CustomEntityEnderDragon");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityEnderDragon(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityEnderDragon(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityEnderDragon(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityEnderDragonClass() {
		try {
			return Class.forName("temp.CustomEntityEnderDragon");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityEnderDragon");
			helper = Class.forName("temp.CustomEntityEnderDragonHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityEnderDragon");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityEnderDragonHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityEnderDragonHelper",
								"temp.CustomEntityEnderDragonHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityInsentientHelper"));
				ces.toClass();
				CtClass EntityEnderDragon = cp
						.getCtClass("net.minecraft.server."
								+ NMSUtils.getVersion() + "EntityEnderDragon");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityEnderDragon");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityInsentient");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityEnderDragon);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityEnderDragonHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityEnderDragonHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityEnderDragonHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityEnderDragon",
					63, customentity);
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
