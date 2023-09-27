package fakeplayer.ketongu10.entity.test;

import fakeplayer.ketongu10.util.handlers.LootTableHandler;
import fakeplayer.ketongu10.util.handlers.SoundsHandler;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import electroblob.wizardry.entity.living.EntityEvilWizard;

public class EntityTest extends EntityEvilWizard
{
	public EntityTest(World worldIn) 
	{
		super(worldIn);
		this.setSize(width, height);
	}
	
	@Override
	protected void initEntityAI() 
	{
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 2.0D));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.5D, true));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityMob.class, 4.0F, 2.2D, 2.2D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}





	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundsHandler.TEST_DEATH;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundsHandler.TEST_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundsHandler.TEST_HURT;
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return LootTableHandler.TEST;
	}
	
	@Override
	protected boolean canDropLoot() 
	{
		return true;
	}
}
