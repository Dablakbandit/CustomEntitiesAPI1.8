package me.dablakbandit.customentitiesapi.entities;

public abstract class CustomEntitySpiderExtender extends CustomEntityMonster {

	public CustomEntitySpiderExtender(String name) {
		super(name);
	}
	
	public void newGoalSelectorPathfinderGoalSpiderMeleeAttack(EntityName en) {
		try {
			helper.getMethod("newGoalSelectorPathfinderSpiderMeleeAttack", Object.class, String.class)
			.invoke(null, entity, en.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMeleeAttack() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderSpiderMeleeAttack",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newGoalSelectorPathfinderGoalLeapAtTargetDefault(){
		newGoalSelectorPathfinderGoalLeapAtTarget(0.4F);
	}
	
	public void newGoalSelectorPathfinderGoalSpiderMeleeAttackDefault() {
		newGoalSelectorPathfinderGoalSpiderMeleeAttack(EntityName.ENTITYHUMAN);
		newGoalSelectorPathfinderGoalSpiderMeleeAttack(EntityName.ENTITYIRONGOLEM);
	}
	
	public void newGoalSelectorPathfinderGoalStrollDefault(){
		newGoalSelectorPathfinderGoalRandomStroll(0.8D); 
	}
	
	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault(){
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYHUMAN, 8.0F);
	}
}
