package me.dablakbandit.customentitiesapi;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.dablakbandit.customentitiesapi.commands.Commands;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomEntitiesAPI extends JavaPlugin{

	private static CustomEntitiesAPI main;

	public void onEnable(){
		getCommand("customentitiesapi").setExecutor(new Commands());
	}

	public void onLoad(){
		main = this;
		registerEntities();
	}

	public static CustomEntitiesAPI getInstance(){
		return main;
	}

	private void registerEntities(){
		me.dablakbandit.customentitiesapi.entities.CustomEntities.createClasses();
	}

	public void registerEntity(String name, int id, Class<?> test) {
		try {
			Class<?> class1 = (Class<?>) NMSUtils.getNMSClass("EntityTypes").getDeclaredMethod("a", int.class).invoke(null, id);
			List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
			for (Field f : NMSUtils.getNMSClass("EntityTypes").getDeclaredFields()) {
				if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
					f.setAccessible(true);
					dataMaps.add((Map<?, ?>) f.get(null));
				}
			}
			if (dataMaps.get(2).containsKey(id)) {
				dataMaps.get(0).remove(name);
				dataMaps.get(2).remove(id);
			}
			Method method = NMSUtils.getNMSClass("EntityTypes").getDeclaredMethod("a", Class.class, String.class, int.class);
			method.setAccessible(true);
			method.invoke(null, test, name, id);
			Class<?> biomebase = NMSUtils.getNMSClass("BiomeBase");
			Class<?> biomemeta;
			try{
				biomemeta = Class.forName("net.minecraft.server." + NMSUtils.getVersion() + "BiomeMeta");
			}catch(Exception e){
				biomemeta = NMSUtils.getInnerClass(biomebase, "BiomeMeta");
			}
			for (Field f : biomebase.getDeclaredFields()) {
				if (f.getType().getSimpleName().equals(biomebase.getSimpleName())) {
					if (f.get(null) != null) {
						for (Field list : biomebase.getDeclaredFields()) {
							if (list.getType().getSimpleName().equals(List.class.getSimpleName())) {
								list.setAccessible(true);
								List<?> metaList = (List<?>) list.get(f.get(null));
								for (Object meta : metaList) {
									Field clazz = biomemeta.cast(meta).getClass().getDeclaredFields()[0];
									if (clazz.get(meta).equals(class1)) {
										clazz.set(meta, test);
									}
								}
							}
						}

					}
				}
			}
			System.out.print("Overridden entity " + name + " with " + test.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
