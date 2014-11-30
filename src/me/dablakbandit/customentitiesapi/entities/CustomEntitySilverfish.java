package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntitySilverfish extends CustomEntityMonster {

	public CustomEntitySilverfish() {
		super("CustomEntitySilverfish");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntitySilverfish(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntitySilverfish(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntitySilverfish(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySilverfishClass() {
		try {
			return Class.forName("temp.CustomEntitySilverfish");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntitySilverfish");
			helper = Class.forName("temp.CustomEntitySilverfishHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntitySilverfish");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntitySilverfishHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntitySilverfishHelper",
								"temp.CustomEntitySilverfishHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntitySilverfish = cp
						.getCtClass("net.minecraft.server."
								+ NMSUtils.getVersion() + "EntitySilverfish");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySilverfish");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntitySilverfish);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySilverfishHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySilverfishHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySilverfishHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntitySilverfish",
					60, customentity);
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
