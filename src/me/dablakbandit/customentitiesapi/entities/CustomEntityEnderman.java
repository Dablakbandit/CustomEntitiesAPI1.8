package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityEnderman extends CustomEntityMonster {

	public CustomEntityEnderman() {
		super("CustomEntityEnderman");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityEnderman(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityEnderman(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityEnderman(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityEndermanClass() {
		try {
			return Class.forName("temp.CustomEntityEnderman");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityEnderman");
			helper = Class.forName("temp.CustomEntityEndermanHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityEnderman");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityEndermanHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityEndermanHelper",
								"temp.CustomEntityEndermanHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntityEnderman = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityEnderman");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityEnderman");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityEnderman);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityEndermanHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityEndermanHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityEndermanHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityEnderman",
					58, customentity);
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
