package me.dablakbandit.customentitiesapi.entities;

public class EntityName {

	public static final EntityName ENTITY = new EntityName("Entity");
	public static final EntityAgeableName ENTITYAGEABLE = new EntityAgeableName("EntityAgeable");
	public static final EntityAmbientName ENTITYAMBIENT = new EntityAmbientName("EntityAmbients");
	public static final EntityAnimalName ENTITYANIMAL = new EntityAnimalName("EntityAnimal");
	public static final EntityName ENTITYARROW = new EntityName("EntityArrow");
	public static final EntityAmbientName ENTITYBAT = new EntityAmbientName("EntityBat");
	public static final EntityMonsterName ENTITYBLAZE = new EntityMonsterName("EntityBlaze");
	public static final EntityName ENTITYBOAT = new EntityName("EntityBoat");
	public static final EntityMonsterName ENTITYCAVESPIDER = new EntityMonsterName("EntityCaveSpider");
	public static final EntityAnimalName ENTITYCHICKEN = new EntityAnimalName("EntityChicken");
	public static final EntityAnimalName ENTITYCOW = new EntityAnimalName("EntityCow");
	public static final EntityMonsterName ENTITYCREEPER = new EntityMonsterName("EntityCreeper");
	public static final EntityProjectileName ENTITYEGG = new EntityProjectileName("EntityEgg");
	public static final EntityName ENTITYENDERCRYSTAL = new EntityName("EntityEnderCrystal");
	public static final EntityInsentientName ENTITYENDERDRAGON = new EntityInsentientName("EntityEnderDragon");
	public static final EntityProjectileName ENTITYENDERPEARL = new EntityProjectileName("EntityEnderPearl");
	public static final EntityName ENTITYENDERSIGNAL = new EntityName("EntityEnderSignal");
	public static final EntityMonsterName ENTITYENDERMAN = new EntityMonsterName("EntityEnderman");
	public static final EntityName ENTITYEXPERIENCEORB = new EntityName("EntityExperienceOrb");
	public static final EntityName ENTITYFALLINGBLOCK = new EntityName("EntityFallingBlock");
	public static final EntityName ENTITYFIREWORKS = new EntityName("EntityFireworks");
	public static final EntityName ENTITYFISHINGHOOK = new EntityName("EntityFishingHook");
	public static final EntityFlyingName ENTITYGHAST = new EntityFlyingName("EntityGhast");
	public static final EntityGolemName ENTITYGOLEM = new EntityGolemName("EntityGolem");
	public static final EntityMonsterName ENTITYGIANTZOMBIE = new EntityMonsterName("EntityGiantZombie");
	public static final EntityAnimalName ENTITYHORSE = new EntityAnimalName("EntityHorse");
	public static final EntityHumanName ENTITYHUMAN = new EntityHumanName("EntityHuman");
	public static final EntityInsentientName ENTITYINSENTIENT = new EntityInsentientName("EntityInsentient");
	public static final EntityGolemName ENTITYIRONGOLEM = new EntityGolemName("EntityIronGolem");
	public static final EntityName ENTITYITEM = new EntityName("EntityItem");
	public static final EntityHangingName ENTITYITEMFRAME = new EntityHangingName("EntityItemFrame");
	public static final EntityFireballName ENTITYLARGEFIRBALL = new EntityFireballName("EntityLargeFireball");
	public static final EntityHangingName ENTITYLEASH = new EntityHangingName("EntityLeash");
	public static final EntityWeatherName ENTITYLIGHTNING = new EntityWeatherName("EntityWeatherLightning");
	public static final EntityLivingName ENTITYLIVING = new EntityLivingName("EntityWeatherLiving");
	public static final EntitySlimeName ENTITYMAGMACUBE = new EntitySlimeName("EntityMagmaCube");
	public static final EntityMinecartContainerName ENTITYMINECARTCHEST = new EntityMinecartContainerName("EntityCartChest");
	public static final EntityMinecartAbstractName ENTITYMINECARTCOMMANDBLOCK = new EntityMinecartAbstractName("EntityMinecartCommandBlock");
	public static final EntityMinecartAbstractName ENTITYMINECARTFURNACE = new EntityMinecartAbstractName("EntityMinecraftFurnace");
	public static final EntityMinecartContainerName ENTITYMINECARTHOPPER = new EntityMinecartContainerName("EntityMinecartHopper");
	public static final EntityMinecartAbstractName ENTITYMINECARTMOBSPAWNER = new EntityMinecartAbstractName("EntityMinecartMobSpawner");
	public static final EntityMinecartAbstractName ENTITYMINECARTRIDEABLE = new EntityMinecartAbstractName("EntityMinecartRideable");
	public static final EntityMinecartAbstractName ENTITYMINECARTTNT = new EntityMinecartAbstractName("EntityMinecartTNT");
	public static final EntityMonsterName ENTITYMONSTER = new EntityMonsterName("EntityMonster");
	public static final EntityAnimalName ENTITYMUSHROOMCOW = new EntityAnimalName("EntityMushroomCow");
	public static final EntityTameableAnimalName ENTITYOCELOT = new EntityTameableAnimalName("EntityOcelot");
	public static final EntityHangingName ENTITYPAINTING = new EntityHangingName("EntityPainting");
	public static final EntityAnimalName ENTITYPIG = new EntityAnimalName("EntityPig");
	public static final EntityMonsterName ENTITYPIGZOMBIE = new EntityMonsterName("EntityPigZombie");
	public static final EntityHumanName ENTITYPLAYER = new EntityHumanName("EntityPlayer");
	public static final EntityProjectileName ENTITYPOTION = new EntityProjectileName("EntityPotion");
	public static final EntityAnimalName ENTITYSHEEP = new EntityAnimalName("EntitySheep");
	public static final EntityMonsterName ENTITYSILVERFISH = new EntityMonsterName("EntitySilverfish");
	public static final EntityMonsterName ENTITYSKELETON = new EntityMonsterName("EntitySkeleton");
	public static final EntitySlimeName ENTITYSLIME = new EntitySlimeName("EntitySlime");
	public static final EntityFireballName ENTITYSMALLFIREBALL = new EntityFireballName("EntitySmallFireball");
	public static final EntityProjectileName ENTITYSNOWBALL = new EntityProjectileName("EntitySnowball");
	public static final EntityGolemName ENTITYSNOWMAN = new EntityGolemName("EntitySnowman");
	public static final EntityMonsterName ENTITYSPIDER = new EntityMonsterName("EntitySpider");
	public static final EntityWaterAnimalName ENTITYSQUID = new EntityWaterAnimalName("EntitySquid");
	public static final EntityName ENTITYTNTPRIMED = new EntityName("EntityTNTPrimed");
	public static final EntityProjectileName ENTITYTHROWNEXPBOTTLE = new EntityProjectileName("EntityThrownExpBottle");
	public static final EntityAgeableName ENTITYVILLAGER = new EntityAgeableName("EntityVillager");
	public static final EntityMonsterName ENTITYWITCH = new EntityMonsterName("EntityWitch");
	public static final EntityMonsterName ENTITYWITHER = new EntityMonsterName("EntityWither");
	public static final EntityFireballName ENTITYWITHERSKULL = new EntityFireballName("EntityWitherSkull");
	public static final EntityTameableAnimalName ENTITYWOLF = new EntityTameableAnimalName("EntityWolf");
	public static final EntityMonsterName ENTITYZOMBIE = new EntityMonsterName("EntityZombie");

	private String name;

	private EntityName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	static class EntityInsentientName extends EntityName{
		public EntityInsentientName(String name){
			super(name);
		}
	}

	static class EntityAmbientName extends EntityInsentientName{
		public EntityAmbientName(String name) {
			super(name);
		}
	}

	static class EntityLivingName extends EntityInsentientName{
		public EntityLivingName(String name){
			super(name);
		}
	}

	static class EntityCreatureName extends EntityInsentientName{
		public EntityCreatureName(String name) {
			super(name);
		}
	}

	static class EntityAgeableName extends EntityCreatureName{
		public EntityAgeableName(String name) {
			super(name);
		}
	}

	static class EntityAnimalName extends EntityAgeableName{
		public EntityAnimalName(String name) {
			super(name);
		}
	}

	static class EntityMonsterName extends EntityCreatureName{
		public EntityMonsterName(String name) {
			super(name);
		}	
	}

	static class EntityProjectileName extends EntityName{
		public EntityProjectileName(String name){
			super(name);
		}
	}

	static class EntityFlyingName extends EntityInsentientName{
		public EntityFlyingName(String name) {
			super(name);
		}
	}

	static class EntityGolemName extends EntityCreatureName{
		public EntityGolemName(String name) {
			super(name);
		}
	}

	static class EntityHangingName extends EntityName{
		public EntityHangingName(String name) {
			super(name);
		}
	}

	static class EntityFireballName extends EntityName{
		public EntityFireballName(String name) {
			super(name);
		}
	}

	static class EntitySlimeName extends EntityInsentientName{
		public EntitySlimeName(String name) {
			super(name);
		}
	}

	static class EntityWeatherName extends EntityName{
		public EntityWeatherName(String name) {
			super(name);
		}
	}

	static class EntityMinecartAbstractName extends EntityName{
		public EntityMinecartAbstractName(String name) {
			super(name);
		}
	}

	static class EntityMinecartContainerName extends EntityMinecartAbstractName{
		public EntityMinecartContainerName(String name) {
			super(name);
		}
	}

	static class EntityTameableAnimalName extends EntityAnimalName{
		public EntityTameableAnimalName(String name) {
			super(name);
		}
	}

	static class EntityHumanName extends EntityLivingName{
		public EntityHumanName(String name) {
			super(name);
		}
	}

	static class EntityWaterAnimalName extends EntityCreatureName{
		public EntityWaterAnimalName(String name) {
			super(name);
		}
	}
}
