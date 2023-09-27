package fakeplayer.ketongu10.events;

import java.util.List;
import java.util.Random;

import fakeplayer.ketongu10.entity.FakePlayer.EntityFakePlayer;
import fakeplayer.ketongu10.entity.test.EntityTest;
import fakeplayer.ketongu10.init.BlockInit;

import fakeplayer.ketongu10.init.ItemInit;
import fakeplayer.ketongu10.recipes.TestRecipe;
import fakeplayer.ketongu10.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class EventExample 
{
	@SuppressWarnings("unused")
	@SubscribeEvent
	public void exampleEvent(HarvestDropsEvent event)
	{
		World world = event.getWorld();
		EntityPlayer player = event.getHarvester();
		BlockPos pos = event.getPos();
		IBlockState state = event.getState();
		Block block = state.getBlock();
		Item item = Item.getItemFromBlock(block);
		int fortuneLevel = event.getFortuneLevel();
		boolean isSilkTouching = event.isSilkTouching();
		boolean isCancelable = event.isCancelable();
		boolean isCanceled = event.isCanceled();
		EventPriority priority = event.getPhase();
		float dropChance = event.getDropChance();
		List<ItemStack> drops = event.getDrops();
		boolean hasResult = event.hasResult();
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		
		if(block.equals(BlockInit.RANDOM_BLOCK))
		{
			world.setBlockState(pos, BlockInit.SILVER_BLOCK.getDefaultState());
			world.spawnEntity(new EntityLightningBolt(world, x, y, z, true));
		}
	}
	@SubscribeEvent
	public static void entityJump(LivingEvent.LivingJumpEvent event)
	{
		//System.out.println("Event Works");
		EntityLivingBase entity = event.getEntityLiving();
		Block block = event.getEntityLiving().getEntityWorld().getBlockState(new BlockPos(entity.posX, entity.posY, entity.posZ)).getBlock();
		if(block == BlockInit.HONEY_BLOCK)
		{
			//System.out.println("Code Works");
			entity.jumpMovementFactor = 0.005f;
		}
	}
	@SubscribeEvent
	public void customLootTableDrop(LivingDropsEvent event)
	{
		Random rand = new Random();
		if(event.getEntityLiving() instanceof EntityTest)
		{
			if(rand.nextInt(1) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(ItemInit.LIGHTNING_STAFF), 0.0f);
			}

			if(rand.nextInt(20) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(BlockInit.SILVER_FURNACE_OFF), 0.0f);
			}
		}

		if(event.getEntityLiving() instanceof EntitySilverfish)
		{
			if(rand.nextInt(5) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(BlockInit.SILVER_BLOCK), 0.0f);
			}
		}
	}

	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event)
	{
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable)event.getRegistry();
		removeRecipe(modRegistry, new ResourceLocation("minecraft:blue_wool"), Reference.MOD_ID);
	}

	public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe, String modID)
	{
		IRecipe p = (IRecipe)modRegistry.getValue(recipe);
		modRegistry.remove(recipe);
		modRegistry.register(TestRecipe.from(p));
	}

}
