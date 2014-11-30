package me.dablakbandit.customentitiesapi.entities;

import ja.ClassPool;
import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntities {	

	private static ClassPool cp= new ClassPool(true);

	private static void clone(Object oold, Object onew){
		
		try{
			Class<?> entity = NMSUtils.getNMSClass("Entity");
			entity.getMethod("a", entity, boolean.class).invoke(entity.cast(onew), entity.cast(oold), true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Not working full clone resorted to a basic clone ^
		/*Map<Class<?>, Map<String, Object>> fields = new HashMap<Class<?>, Map<String, Object>>();
		Class<?> c = oold.getClass();
		for(int i = 0; i<6; i++){
			Map<String, Object> fs1 = new HashMap<String, Object>();
			for(Field f : c.getDeclaredFields()){
				f.setAccessible(true);
				if(!Modifier.isFinal(f.getModifiers())&&!f.getName().equals("dead")){
					try {
						fs1.put(f.getName(), f.get(oold));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			fields.put(c, fs1);
			c = c.getSuperclass();
		}
		for(Class<?> c1 : fields.keySet()){
			Map<String, Object> fs =fields.get(c1);
			for(String f : fs.keySet()){
				try {
					try{
						Field f1 = c1.getDeclaredField(f);
						f1.setAccessible(true);
						f1.set(c1.cast(onew), fs.get(f));
					}catch(Exception e1){

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Field[] fi = c.getDeclaredFields();
		for(int i = 0; i < fi.length; i++){
			Field f = fi[i];
			f.setAccessible(true);
		}*/
	}

	public static void createClasses(){
		try {
			new CustomEntityIronGolem();
			new CustomEntitySheep();
			new CustomEntitySkeleton();
			new CustomEntityVillager();
			new CustomEntityZombie();
			new CustomEntityCreeper();
			new CustomEntitySpider();
			new CustomEntityGiantZombie();
			new CustomEntitySlime();
			new CustomEntityGhast();
			new CustomEntityPigZombie();
			new CustomEntityEnderman();
			new CustomEntityCaveSpider();
			new CustomEntitySilverfish();
			new CustomEntityBlaze();
			new CustomEntityMagmaCube();
			new CustomEntityEnderDragon();
			new CustomEntityWither();
			new CustomEntityBat();
			new CustomEntityWitch();
			new CustomEntityEndermite();
			new CustomEntityGuardian();
			new CustomEntityPig();
			new CustomEntityCow();
			new CustomEntityChicken();
			new CustomEntitySquid();
			new CustomEntityWolf();
			new CustomEntityMushroomCow();
			new CustomEntitySnowman();
			new CustomEntityOcelot();
			new CustomEntityHorse();
			new CustomEntityRabbit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ClassPool getClassPool(){
		return cp;
	}
	/*
	 * =========================================================================================
	 * ==========================[Get instance of a CustomEntity]===============================
	 * =========================================================================================
	 */

	/***
	 * Gets the CustomEntityIronGolem or clones and gets rid of the Minecraft EntityIronGolem with a copy as a CustomEntityIronGolem
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntityIronGolem
	 * @see CustomEntityIronGolem
	 */
	public static CustomEntityIronGolem getCustomEntityIronGolem(Entity e){
		if(isCustomEntityIronGolem(e)){
			return new CustomEntityIronGolem(e);
		}else if(isNormalEntityIronGolem(e)){
			CustomEntityIronGolem ceig = new CustomEntityIronGolem(e.getLocation());
			clone(NMSUtils.getHandle(e), ceig.getEntity());
			e.remove();
			return ceig;
		}
		return null;
	}

	/***
	 * Gets the CustomEntitySheep or clones and gets rid of the Minecraft EntitySheep with a copy as a CustomEntitySheep
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntitySheep
	 * @see CustomEntitySheep
	 */
	public static CustomEntitySheep getCustomEntitySheep(Entity e){
		if(isCustomEntitySheep(e)){
			return new CustomEntitySheep(e);
		}else if(isNormalEntitySheep(e)){
			CustomEntitySheep ces = new CustomEntitySheep(e.getLocation());
			clone(NMSUtils.getHandle(e), ces.getEntity());
			e.remove();
			return ces;
		}
		return null;
	}

	/***
	 * Gets the CustomEntitySkeleton or clones and gets rid of the Minecraft EntitySkeleton with a copy as a CustomEntitySkeleton
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntitySkeleton
	 * @see CustomEntitySkeleton
	 */
	public static CustomEntitySkeleton getCustomEntitySkeleton(Entity e){
		if(isCustomEntitySkeleton(e)){
			return new CustomEntitySkeleton(e);
		}else if(isNormalEntitySkeleton(e)){
			CustomEntitySkeleton ces = new CustomEntitySkeleton(e.getLocation());
			clone(NMSUtils.getHandle(e), ces.getEntity());
			e.remove();
			return ces;
		}
		return null;
	}

	/***
	 * Gets the CustomEntityVillager or clones and gets rid of the Minecraft EntityVillager with a copy as a CustomEntityVillager
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntityVillager
	 * @see CustomEntityVillager
	 */
	public static CustomEntityVillager getCustomEntityVillager(Entity e){
		if(isCustomEntityVillager(e)){
			return new CustomEntityVillager(e);
		}else if(isNormalEntityVillager(e)){
			CustomEntityVillager cev = new CustomEntityVillager(e.getLocation());
			clone(NMSUtils.getHandle(e), cev.getEntity());
			e.remove();
			return cev;
		}
		return null;
	}

	/***
	 * Gets the CustomEntityZombie or clones and gets rid of the Minecraft EntityZombie with a copy as a CustomEntityZombie
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntityZombie
	 * @see CustomEntityZombie
	 */
	public static CustomEntityZombie getCustomEntityZombie(Entity e){
		if(isCustomEntityZombie(e)){
			return new CustomEntityZombie(e);
		}else if(isNormalEntityZombie(e)){
			CustomEntityZombie cez = new CustomEntityZombie(e.getLocation());
			clone(NMSUtils.getHandle(e), cez.getEntity());
			e.remove();
			return cez;
		}
		return null;
	}
	
	/***
	* Gets the CustomEntityCreeper or clones and gets rid of the Minecraft EntityCreeper with a copy as a CustomEntityCreeper
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityCreeper
	* @see CustomEntityCreeper
	*/
	public static CustomEntityCreeper getCustomEntityCreeper(Entity e){
	if(isCustomEntityCreeper(e)){
	return new CustomEntityCreeper(e);
	}else if(isNormalEntityCreeper(e)){
	CustomEntityCreeper cec = new CustomEntityCreeper(e.getLocation());
	clone(NMSUtils.getHandle(e), cec.getEntity());
	e.remove();
	return cec;
	}
	return null;
	}

	/***
	* Gets the CustomEntitySpider or clones and gets rid of the Minecraft EntitySpider with a copy as a CustomEntitySpider
	* @param e Bukkit Entity
	* @return Instance of a CustomEntitySpider
	* @see CustomEntitySpider
	*/
	public static CustomEntitySpider getCustomEntitySpider(Entity e){
	if(isCustomEntitySpider(e)){
	return new CustomEntitySpider(e);
	}else if(isNormalEntitySpider(e)){
	CustomEntitySpider ces = new CustomEntitySpider(e.getLocation());
	clone(NMSUtils.getHandle(e), ces.getEntity());
	e.remove();
	return ces;
	}
	return null;
	}

	/***
	* Gets the CustomEntityGiantZombie or clones and gets rid of the Minecraft EntityGiantZombie with a copy as a CustomEntityGiantZombie
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityGiantZombie
	* @see CustomEntityGiantZombie
	*/
	public static CustomEntityGiantZombie getCustomEntityGiantZombie(Entity e){
	if(isCustomEntityGiantZombie(e)){
	return new CustomEntityGiantZombie(e);
	}else if(isNormalEntityGiantZombie(e)){
	CustomEntityGiantZombie ceg = new CustomEntityGiantZombie(e.getLocation());
	clone(NMSUtils.getHandle(e), ceg.getEntity());
	e.remove();
	return ceg;
	}
	return null;
	}

	/***
	* Gets the CustomEntitySlime or clones and gets rid of the Minecraft EntitySlime with a copy as a CustomEntitySlime
	* @param e Bukkit Entity
	* @return Instance of a CustomEntitySlime
	* @see CustomEntitySlime
	*/
	public static CustomEntitySlime getCustomEntitySlime(Entity e){
	if(isCustomEntitySlime(e)){
	return new CustomEntitySlime(e);
	}else if(isNormalEntitySlime(e)){
	CustomEntitySlime ces = new CustomEntitySlime(e.getLocation());
	clone(NMSUtils.getHandle(e), ces.getEntity());
	e.remove();
	return ces;
	}
	return null;
	}

	/***
	* Gets the CustomEntityGhast or clones and gets rid of the Minecraft EntityGhast with a copy as a CustomEntityGhast
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityGhast
	* @see CustomEntityGhast
	*/
	public static CustomEntityGhast getCustomEntityGhast(Entity e){
	if(isCustomEntityGhast(e)){
	return new CustomEntityGhast(e);
	}else if(isNormalEntityGhast(e)){
	CustomEntityGhast ceg = new CustomEntityGhast(e.getLocation());
	clone(NMSUtils.getHandle(e), ceg.getEntity());
	e.remove();
	return ceg;
	}
	return null;
	}

	/***
	* Gets the CustomEntityPigZombie or clones and gets rid of the Minecraft EntityPigZombie with a copy as a CustomEntityPigZombie
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityPigZombie
	* @see CustomEntityPigZombie
	*/
	public static CustomEntityPigZombie getCustomEntityPigZombie(Entity e){
	if(isCustomEntityPigZombie(e)){
	return new CustomEntityPigZombie(e);
	}else if(isNormalEntityPigZombie(e)){
	CustomEntityPigZombie cep = new CustomEntityPigZombie(e.getLocation());
	clone(NMSUtils.getHandle(e), cep.getEntity());
	e.remove();
	return cep;
	}
	return null;
	}

	/***
	* Gets the CustomEntityEnderman or clones and gets rid of the Minecraft EntityEnderman with a copy as a CustomEntityEnderman
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityEnderman
	* @see CustomEntityEnderman
	*/
	public static CustomEntityEnderman getCustomEntityEnderman(Entity e){
	if(isCustomEntityEnderman(e)){
	return new CustomEntityEnderman(e);
	}else if(isNormalEntityEnderman(e)){
	CustomEntityEnderman cee = new CustomEntityEnderman(e.getLocation());
	clone(NMSUtils.getHandle(e), cee.getEntity());
	e.remove();
	return cee;
	}
	return null;
	}

	/***
	* Gets the CustomEntityCaveSpider or clones and gets rid of the Minecraft EntityCaveSpider with a copy as a CustomEntityCaveSpider
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityCaveSpider
	* @see CustomEntityCaveSpider
	*/
	public static CustomEntityCaveSpider getCustomEntityCaveSpider(Entity e){
	if(isCustomEntityCaveSpider(e)){
	return new CustomEntityCaveSpider(e);
	}else if(isNormalEntityCaveSpider(e)){
	CustomEntityCaveSpider cec = new CustomEntityCaveSpider(e.getLocation());
	clone(NMSUtils.getHandle(e), cec.getEntity());
	e.remove();
	return cec;
	}
	return null;
	}

	/***
	* Gets the CustomEntitySilverfish or clones and gets rid of the Minecraft EntitySilverfish with a copy as a CustomEntitySilverfish
	* @param e Bukkit Entity
	* @return Instance of a CustomEntitySilverfish
	* @see CustomEntitySilverfish
	*/
	public static CustomEntitySilverfish getCustomEntitySilverfish(Entity e){
	if(isCustomEntitySilverfish(e)){
	return new CustomEntitySilverfish(e);
	}else if(isNormalEntitySilverfish(e)){
	CustomEntitySilverfish ces = new CustomEntitySilverfish(e.getLocation());
	clone(NMSUtils.getHandle(e), ces.getEntity());
	e.remove();
	return ces;
	}
	return null;
	}

	/***
	* Gets the CustomEntityBlaze or clones and gets rid of the Minecraft EntityBlaze with a copy as a CustomEntityBlaze
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityBlaze
	* @see CustomEntityBlaze
	*/
	public static CustomEntityBlaze getCustomEntityBlaze(Entity e){
	if(isCustomEntityBlaze(e)){
	return new CustomEntityBlaze(e);
	}else if(isNormalEntityBlaze(e)){
	CustomEntityBlaze ceb = new CustomEntityBlaze(e.getLocation());
	clone(NMSUtils.getHandle(e), ceb.getEntity());
	e.remove();
	return ceb;
	}
	return null;
	}

	/***
	* Gets the CustomEntityMagmaCube or clones and gets rid of the Minecraft EntityMagmaCube with a copy as a CustomEntityMagmaCube
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityMagmaCube
	* @see CustomEntityMagmaCube
	*/
	public static CustomEntityMagmaCube getCustomEntityMagmaCube(Entity e){
	if(isCustomEntityMagmaCube(e)){
	return new CustomEntityMagmaCube(e);
	}else if(isNormalEntityMagmaCube(e)){
	CustomEntityMagmaCube cem = new CustomEntityMagmaCube(e.getLocation());
	clone(NMSUtils.getHandle(e), cem.getEntity());
	e.remove();
	return cem;
	}
	return null;
	}

	/***
	* Gets the CustomEntityEnderDragon or clones and gets rid of the Minecraft EntityEnderDragon with a copy as a CustomEntityEnderDragon
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityEnderDragon
	* @see CustomEntityEnderDragon
	*/
	public static CustomEntityEnderDragon getCustomEntityEnderDragon(Entity e){
	if(isCustomEntityEnderDragon(e)){
	return new CustomEntityEnderDragon(e);
	}else if(isNormalEntityEnderDragon(e)){
	CustomEntityEnderDragon cee = new CustomEntityEnderDragon(e.getLocation());
	clone(NMSUtils.getHandle(e), cee.getEntity());
	e.remove();
	return cee;
	}
	return null;
	}

	/***
	* Gets the CustomEntityWither or clones and gets rid of the Minecraft EntityWither with a copy as a CustomEntityWither
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityWither
	* @see CustomEntityWither
	*/
	public static CustomEntityWither getCustomEntityWither(Entity e){
	if(isCustomEntityWither(e)){
	return new CustomEntityWither(e);
	}else if(isNormalEntityWither(e)){
	CustomEntityWither cew = new CustomEntityWither(e.getLocation());
	clone(NMSUtils.getHandle(e), cew.getEntity());
	e.remove();
	return cew;
	}
	return null;
	}

	/***
	* Gets the CustomEntityBat or clones and gets rid of the Minecraft EntityBat with a copy as a CustomEntityBat
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityBat
	* @see CustomEntityBat
	*/
	public static CustomEntityBat getCustomEntityBat(Entity e){
	if(isCustomEntityBat(e)){
	return new CustomEntityBat(e);
	}else if(isNormalEntityBat(e)){
	CustomEntityBat ceb = new CustomEntityBat(e.getLocation());
	clone(NMSUtils.getHandle(e), ceb.getEntity());
	e.remove();
	return ceb;
	}
	return null;
	}

	/***
	* Gets the CustomEntityWitch or clones and gets rid of the Minecraft EntityWitch with a copy as a CustomEntityWitch
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityWitch
	* @see CustomEntityWitch
	*/
	public static CustomEntityWitch getCustomEntityWitch(Entity e){
	if(isCustomEntityWitch(e)){
	return new CustomEntityWitch(e);
	}else if(isNormalEntityWitch(e)){
	CustomEntityWitch cew = new CustomEntityWitch(e.getLocation());
	clone(NMSUtils.getHandle(e), cew.getEntity());
	e.remove();
	return cew;
	}
	return null;
	}

	/***
	* Gets the CustomEntityEndermite or clones and gets rid of the Minecraft EntityEndermite with a copy as a CustomEntityEndermite
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityEndermite
	* @see CustomEntityEndermite
	*/
	public static CustomEntityEndermite getCustomEntityEndermite(Entity e){
	if(isCustomEntityEndermite(e)){
	return new CustomEntityEndermite(e);
	}else if(isNormalEntityEndermite(e)){
	CustomEntityEndermite cee = new CustomEntityEndermite(e.getLocation());
	clone(NMSUtils.getHandle(e), cee.getEntity());
	e.remove();
	return cee;
	}
	return null;
	}

	/***
	* Gets the CustomEntityGuardian or clones and gets rid of the Minecraft EntityGuardian with a copy as a CustomEntityGuardian
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityGuardian
	* @see CustomEntityGuardian
	*/
	public static CustomEntityGuardian getCustomEntityGuardian(Entity e){
	if(isCustomEntityGuardian(e)){
	return new CustomEntityGuardian(e);
	}else if(isNormalEntityGuardian(e)){
	CustomEntityGuardian ceg = new CustomEntityGuardian(e.getLocation());
	clone(NMSUtils.getHandle(e), ceg.getEntity());
	e.remove();
	return ceg;
	}
	return null;
	}

	/***
	* Gets the CustomEntityPig or clones and gets rid of the Minecraft EntityPig with a copy as a CustomEntityPig
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityPig
	* @see CustomEntityPig
	*/
	public static CustomEntityPig getCustomEntityPig(Entity e){
	if(isCustomEntityPig(e)){
	return new CustomEntityPig(e);
	}else if(isNormalEntityPig(e)){
	CustomEntityPig cep = new CustomEntityPig(e.getLocation());
	clone(NMSUtils.getHandle(e), cep.getEntity());
	e.remove();
	return cep;
	}
	return null;
	}

	/***
	* Gets the CustomEntityCow or clones and gets rid of the Minecraft EntityCow with a copy as a CustomEntityCow
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityCow
	* @see CustomEntityCow
	*/
	public static CustomEntityCow getCustomEntityCow(Entity e){
	if(isCustomEntityCow(e)){
	return new CustomEntityCow(e);
	}else if(isNormalEntityCow(e)){
	CustomEntityCow cec = new CustomEntityCow(e.getLocation());
	clone(NMSUtils.getHandle(e), cec.getEntity());
	e.remove();
	return cec;
	}
	return null;
	}

	/***
	* Gets the CustomEntityChicken or clones and gets rid of the Minecraft EntityChicken with a copy as a CustomEntityChicken
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityChicken
	* @see CustomEntityChicken
	*/
	public static CustomEntityChicken getCustomEntityChicken(Entity e){
	if(isCustomEntityChicken(e)){
	return new CustomEntityChicken(e);
	}else if(isNormalEntityChicken(e)){
	CustomEntityChicken cec = new CustomEntityChicken(e.getLocation());
	clone(NMSUtils.getHandle(e), cec.getEntity());
	e.remove();
	return cec;
	}
	return null;
	}

	/***
	* Gets the CustomEntitySquid or clones and gets rid of the Minecraft EntitySquid with a copy as a CustomEntitySquid
	* @param e Bukkit Entity
	* @return Instance of a CustomEntitySquid
	* @see CustomEntitySquid
	*/
	public static CustomEntitySquid getCustomEntitySquid(Entity e){
	if(isCustomEntitySquid(e)){
	return new CustomEntitySquid(e);
	}else if(isNormalEntitySquid(e)){
	CustomEntitySquid ces = new CustomEntitySquid(e.getLocation());
	clone(NMSUtils.getHandle(e), ces.getEntity());
	e.remove();
	return ces;
	}
	return null;
	}

	/***
	* Gets the CustomEntityWolf or clones and gets rid of the Minecraft EntityWolf with a copy as a CustomEntityWolf
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityWolf
	* @see CustomEntityWolf
	*/
	public static CustomEntityWolf getCustomEntityWolf(Entity e){
	if(isCustomEntityWolf(e)){
	return new CustomEntityWolf(e);
	}else if(isNormalEntityWolf(e)){
	CustomEntityWolf cew = new CustomEntityWolf(e.getLocation());
	clone(NMSUtils.getHandle(e), cew.getEntity());
	e.remove();
	return cew;
	}
	return null;
	}

	/***
	* Gets the CustomEntityMushroomCow or clones and gets rid of the Minecraft EntityMushroomCow with a copy as a CustomEntityMushroomCow
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityMushroomCow
	* @see CustomEntityMushroomCow
	*/
	public static CustomEntityMushroomCow getCustomEntityMushroomCow(Entity e){
	if(isCustomEntityMushroomCow(e)){
	return new CustomEntityMushroomCow(e);
	}else if(isNormalEntityMushroomCow(e)){
	CustomEntityMushroomCow cem = new CustomEntityMushroomCow(e.getLocation());
	clone(NMSUtils.getHandle(e), cem.getEntity());
	e.remove();
	return cem;
	}
	return null;
	}

	/***
	* Gets the CustomEntitySnowman or clones and gets rid of the Minecraft EntitySnowman with a copy as a CustomEntitySnowman
	* @param e Bukkit Entity
	* @return Instance of a CustomEntitySnowman
	* @see CustomEntitySnowman
	*/
	public static CustomEntitySnowman getCustomEntitySnowman(Entity e){
	if(isCustomEntitySnowman(e)){
	return new CustomEntitySnowman(e);
	}else if(isNormalEntitySnowman(e)){
	CustomEntitySnowman ces = new CustomEntitySnowman(e.getLocation());
	clone(NMSUtils.getHandle(e), ces.getEntity());
	e.remove();
	return ces;
	}
	return null;
	}

	/***
	* Gets the CustomEntityOcelot or clones and gets rid of the Minecraft EntityOcelot with a copy as a CustomEntityOcelot
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityOcelot
	* @see CustomEntityOcelot
	*/
	public static CustomEntityOcelot getCustomEntityOcelot(Entity e){
	if(isCustomEntityOcelot(e)){
	return new CustomEntityOcelot(e);
	}else if(isNormalEntityOcelot(e)){
	CustomEntityOcelot ceo = new CustomEntityOcelot(e.getLocation());
	clone(NMSUtils.getHandle(e), ceo.getEntity());
	e.remove();
	return ceo;
	}
	return null;
	}

	/***
	* Gets the CustomEntityHorse or clones and gets rid of the Minecraft EntityHorse with a copy as a CustomEntityHorse
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityHorse
	* @see CustomEntityHorse
	*/
	public static CustomEntityHorse getCustomEntityHorse(Entity e){
	if(isCustomEntityHorse(e)){
	return new CustomEntityHorse(e);
	}else if(isNormalEntityHorse(e)){
	CustomEntityHorse ceh = new CustomEntityHorse(e.getLocation());
	clone(NMSUtils.getHandle(e), ceh.getEntity());
	e.remove();
	return ceh;
	}
	return null;
	}

	/***
	* Gets the CustomEntityRabbit or clones and gets rid of the Minecraft EntityRabbit with a copy as a CustomEntityRabbit
	* @param e Bukkit Entity
	* @return Instance of a CustomEntityRabbit
	* @see CustomEntityRabbit
	*/
	public static CustomEntityRabbit getCustomEntityRabbit(Entity e){
	if(isCustomEntityRabbit(e)){
	return new CustomEntityRabbit(e);
	}else if(isNormalEntityRabbit(e)){
	CustomEntityRabbit cer = new CustomEntityRabbit(e.getLocation());
	clone(NMSUtils.getHandle(e), cer.getEntity());
	e.remove();
	return cer;
	}
	return null;
	}



	/*
	 * =========================================================================================
	 * ========================[Get new instance of a CustomEntity]=============================
	 * =========================================================================================
	 */

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntityIronGolem
	 * @see CustomEntityIronGolem
	 */
	public static CustomEntityIronGolem getNewCustomEntityIronGolem(Location location){
		return new CustomEntityIronGolem(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntitySheep
	 * @see CustomEntitySheep
	 */
	public static CustomEntitySheep getNewCustomEntitySheep(Location location){
		return new CustomEntitySheep(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntitySkeleton
	 * @see CustomEntitySkeleton
	 */
	public static CustomEntitySkeleton getNewCustomEntitySkeleton(Location location){
		return new CustomEntitySkeleton(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntityVillager
	 * @see CustomEntityVillager
	 */
	public static CustomEntityVillager getNewCustomEntityVillager(Location location){
		return new CustomEntityVillager(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntityZombie
	 * @see CustomEntityZombie
	 */
	public static CustomEntityZombie getNewCustomEntityZombie(Location location){
		return new CustomEntityZombie(location);
	}
	
	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityCreeper
	* @see CustomEntityCreeper
	*/
	public static CustomEntityCreeper getNewCustomEntityCreeper(Location location){
	return new CustomEntityCreeper(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntitySpider
	* @see CustomEntitySpider
	*/
	public static CustomEntitySpider getNewCustomEntitySpider(Location location){
	return new CustomEntitySpider(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityGiantZombie
	* @see CustomEntityGiantZombie
	*/
	public static CustomEntityGiantZombie getNewCustomEntityGiantZombie(Location location){
	return new CustomEntityGiantZombie(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntitySlime
	* @see CustomEntitySlime
	*/
	public static CustomEntitySlime getNewCustomEntitySlime(Location location){
	return new CustomEntitySlime(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityGhast
	* @see CustomEntityGhast
	*/
	public static CustomEntityGhast getNewCustomEntityGhast(Location location){
	return new CustomEntityGhast(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityPigZombie
	* @see CustomEntityPigZombie
	*/
	public static CustomEntityPigZombie getNewCustomEntityPigZombie(Location location){
	return new CustomEntityPigZombie(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityEnderman
	* @see CustomEntityEnderman
	*/
	public static CustomEntityEnderman getNewCustomEntityEnderman(Location location){
	return new CustomEntityEnderman(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityCaveSpider
	* @see CustomEntityCaveSpider
	*/
	public static CustomEntityCaveSpider getNewCustomEntityCaveSpider(Location location){
	return new CustomEntityCaveSpider(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntitySilverfish
	* @see CustomEntitySilverfish
	*/
	public static CustomEntitySilverfish getNewCustomEntitySilverfish(Location location){
	return new CustomEntitySilverfish(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityBlaze
	* @see CustomEntityBlaze
	*/
	public static CustomEntityBlaze getNewCustomEntityBlaze(Location location){
	return new CustomEntityBlaze(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityMagmaCube
	* @see CustomEntityMagmaCube
	*/
	public static CustomEntityMagmaCube getNewCustomEntityMagmaCube(Location location){
	return new CustomEntityMagmaCube(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityEnderDragon
	* @see CustomEntityEnderDragon
	*/
	public static CustomEntityEnderDragon getNewCustomEntityEnderDragon(Location location){
	return new CustomEntityEnderDragon(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityWither
	* @see CustomEntityWither
	*/
	public static CustomEntityWither getNewCustomEntityWither(Location location){
	return new CustomEntityWither(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityBat
	* @see CustomEntityBat
	*/
	public static CustomEntityBat getNewCustomEntityBat(Location location){
	return new CustomEntityBat(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityWitch
	* @see CustomEntityWitch
	*/
	public static CustomEntityWitch getNewCustomEntityWitch(Location location){
	return new CustomEntityWitch(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityEndermite
	* @see CustomEntityEndermite
	*/
	public static CustomEntityEndermite getNewCustomEntityEndermite(Location location){
	return new CustomEntityEndermite(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityGuardian
	* @see CustomEntityGuardian
	*/
	public static CustomEntityGuardian getNewCustomEntityGuardian(Location location){
	return new CustomEntityGuardian(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityPig
	* @see CustomEntityPig
	*/
	public static CustomEntityPig getNewCustomEntityPig(Location location){
	return new CustomEntityPig(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityCow
	* @see CustomEntityCow
	*/
	public static CustomEntityCow getNewCustomEntityCow(Location location){
	return new CustomEntityCow(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityChicken
	* @see CustomEntityChicken
	*/
	public static CustomEntityChicken getNewCustomEntityChicken(Location location){
	return new CustomEntityChicken(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntitySquid
	* @see CustomEntitySquid
	*/
	public static CustomEntitySquid getNewCustomEntitySquid(Location location){
	return new CustomEntitySquid(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityWolf
	* @see CustomEntityWolf
	*/
	public static CustomEntityWolf getNewCustomEntityWolf(Location location){
	return new CustomEntityWolf(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityMushroomCow
	* @see CustomEntityMushroomCow
	*/
	public static CustomEntityMushroomCow getNewCustomEntityMushroomCow(Location location){
	return new CustomEntityMushroomCow(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntitySnowman
	* @see CustomEntitySnowman
	*/
	public static CustomEntitySnowman getNewCustomEntitySnowman(Location location){
	return new CustomEntitySnowman(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityOcelot
	* @see CustomEntityOcelot
	*/
	public static CustomEntityOcelot getNewCustomEntityOcelot(Location location){
	return new CustomEntityOcelot(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityHorse
	* @see CustomEntityHorse
	*/
	public static CustomEntityHorse getNewCustomEntityHorse(Location location){
	return new CustomEntityHorse(location);
	}

	/**
	*
	* @param location Bukkit Location
	* @return New instance of a CustomEntityRabbit
	* @see CustomEntityRabbit
	*/
	public static CustomEntityRabbit getNewCustomEntityRabbit(Location location){
	return new CustomEntityRabbit(location);
	}



	/*
	 * =========================================================================================
	 * ==========================[Check instance of CustomEntity]===============================
	 * =========================================================================================
	 */

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntityIronGolem(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityIronGolem");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntitySheep(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySheep");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntitySkeleton(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySkeleton");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntityVillager(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityVillager");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntityZombie(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityZombie");
	}
	
	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityCreeper(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityCreeper");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntitySpider(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySpider");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityGiantZombie(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityGiantZombie");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntitySlime(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySlime");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityGhast(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityGhast");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityPigZombie(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityPigZombie");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityEnderman(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityEnderman");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityCaveSpider(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityCaveSpider");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntitySilverfish(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySilverfish");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityBlaze(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityBlaze");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityMagmaCube(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityMagmaCube");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityEnderDragon(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityEnderDragon");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityWither(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityWither");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityBat(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityBat");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityWitch(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityWitch");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityEndermite(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityEndermite");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityGuardian(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityGuardian");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityPig(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityPig");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityCow(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityCow");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityChicken(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityChicken");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntitySquid(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySquid");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityWolf(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityWolf");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityMushroomCow(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityMushroomCow");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntitySnowman(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySnowman");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityOcelot(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityOcelot");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityHorse(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityHorse");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is made by CustomEntitiesAPI
	*/
	public static boolean isCustomEntityRabbit(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityRabbit");
	}



	/*
	 * =========================================================================================
	 * ==========================[Check instance of Normal Entity]==============================
	 * =========================================================================================
	 */

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntityIronGolem(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityIronGolem");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntitySheep(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySheep");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntitySkeleton(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySkeleton");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntityVillager(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityVillager");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntityZombie(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityZombie");
	}
	
	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityCreeper(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityCreeper");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntitySpider(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySpider");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityGiantZombie(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityGiantZombie");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntitySlime(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySlime");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityGhast(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityGhast");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityPigZombie(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityPigZombie");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityEnderman(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityEnderman");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityCaveSpider(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityCaveSpider");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntitySilverfish(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySilverfish");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityBlaze(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityBlaze");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityMagmaCube(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityMagmaCube");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityEnderDragon(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityEnderDragon");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityWither(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityWither");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityBat(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityBat");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityWitch(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityWitch");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityEndermite(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityEndermite");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityGuardian(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityGuardian");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityPig(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityPig");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityCow(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityCow");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityChicken(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityChicken");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntitySquid(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySquid");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityWolf(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityWolf");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityMushroomCow(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityMushroomCow");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntitySnowman(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySnowman");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityOcelot(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityOcelot");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityHorse(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityHorse");
	}

	/**
	*
	* @param e Bukkit Entity
	* @return If the Entity is a Minecraft Entity
	*/
	public static boolean isNormalEntityRabbit(Entity e){
	return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityRabbit");
	}
}
