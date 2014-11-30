package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;

public class CustomEntityHelper {

	public static Object createEntity(Object world0, Class<?> entity, double x,
			double y, double z, float yaw, float pitch) {
		try {
			Class<?> world = getNMSClass("World");
			Object world1 = world.cast(world0);
			Object entity1 = entity.getConstructor(world).newInstance(world1);
			entity1.getClass()
					.getMethod("setLocation", double.class, double.class,
							double.class, float.class, float.class)
					.invoke(entity1, x, y, z, yaw, pitch);
			return entity1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getVersion() {
		String name = Bukkit.getServer().getClass().getPackage().getName();
		String version = name.substring(name.lastIndexOf('.') + 1) + ".";
		return version;
	}

	public static Class<?> getNMSClass(String className) {
		String fullName = "net.minecraft.server." + getVersion() + className;
		Class<?> clazz = null;
		try {
			clazz = Class.forName(fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazz;
	}

	public static Class<?> getOBCClass(String className) {
		String fullName = "org.bukkit.craftbukkit." + getVersion() + className;
		Class<?> clazz = null;
		try {
			clazz = Class.forName(fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazz;
	}

	public static Object getHandle(Object obj) {
		try {
			return getMethod(obj.getClass(), "getHandle").invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Field getField(Class<?> clazz, String name) {
		try {
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			return field;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Method getMethod(Class<?> clazz, String name,
			Class<?>... args) {
		for (Method m : clazz.getMethods())
			if (m.getName().equals(name)
					&& (args.length == 0 || ClassListEqual(args,
							m.getParameterTypes()))) {
				m.setAccessible(true);
				return m;
			}
		return null;
	}

	public static boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
		boolean equal = true;
		if (l1.length != l2.length)
			return false;
		for (int i = 0; i < l1.length; i++)
			if (l1[i] != l2[i]) {
				equal = false;
				break;
			}
		return equal;
	}

	public static void setDamageable(Object entity) {
		try {
			Class<?> entityc = getNMSClass("Entity");
			Field f = entityc.getDeclaredField("invulnerable");
			f.setAccessible(true);
			f.set(entity, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setUndamageable(Object entity) {
		try {
			Class<?> entityc = getNMSClass("Entity");
			Field f = entityc.getDeclaredField("invulnerable");
			f.setAccessible(true);
			f.set(entity, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean getDamageable(Object entity) {
		try {
			Class<?> entityc = getNMSClass("Entity");
			Field f = entityc.getDeclaredField("invulnerable");
			f.setAccessible(true);
			return (boolean) f.get(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
}
