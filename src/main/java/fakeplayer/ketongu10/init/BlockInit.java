package fakeplayer.ketongu10.init;

import java.util.ArrayList;
import java.util.List;

import fakeplayer.ketongu10.objects.blocks.BlockSilverPressurePlate;
import fakeplayer.ketongu10.objects.blocks.fluids.BlockWhiteWaterFluid;
import fakeplayer.ketongu10.objects.blocks.silver_chest_na.SilverChestNA;
import fakeplayer.ketongu10.objects.blocks.silver_furnace.SilverFurnace;
import fakeplayer.ketongu10.objects.blocks.slab.BlockDoubleSlabBase;
import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.energy.BlockGlowstoneGenerator;
import fakeplayer.ketongu10.objects.blocks.BlockBase;
import fakeplayer.ketongu10.objects.blocks.BlockHoney;
import fakeplayer.ketongu10.objects.blocks.BlockSilverButton;
import fakeplayer.ketongu10.objects.blocks.BlockSilverFence;
import fakeplayer.ketongu10.objects.blocks.BlockStairBase;
import fakeplayer.ketongu10.objects.blocks.CandyCane;
import fakeplayer.ketongu10.objects.blocks.GlassDoor;
import fakeplayer.ketongu10.objects.blocks.RandomBlock;
import fakeplayer.ketongu10.objects.blocks.crops.BlockLemonPlant;
import fakeplayer.ketongu10.objects.blocks.silver_chest.SilverChest;
import fakeplayer.ketongu10.objects.blocks.slab.BlockHalfSlabBase;
import fakeplayer.ketongu10.objects.blocks.world.BlockTestDirt;
import fakeplayer.ketongu10.objects.blocks.world.BlockTestFarmland;
import fakeplayer.ketongu10.objects.blocks.world.BlockTestGrass;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block SILVER_BLOCK = new BlockBase("silver_block", Material.IRON);
	public static final Block RANDOM_BLOCK = new RandomBlock("random_block", Material.ROCK);
	public static final Block CANDY_CANE = new CandyCane("candy_cane", Material.GOURD);
	public static final Block GLASS_DOOR = new GlassDoor("glass_door");
	public static final Block SILVER_CHEST = new SilverChest("silver_chest", Material.WOOD);
	public static final Block SILVER_CHEST_NA = new SilverChestNA("silver_chest_na", Material.WOOD);
	public static final Block SILVER_FURNACE_OFF = new SilverFurnace("silver_furnace_off", false).setCreativeTab(FakePlayer.fakeplayerTAB);
	public static final Block SILVER_FURNACE_ON = new SilverFurnace("silver_furnace_on", true);
	public static final BlockSlab SILVER_SLAB_DOUBLE = new BlockDoubleSlabBase("silver_slab_double", Material.IRON, FakePlayer.fakeplayerTAB, BlockInit.SILVER_SLAB_HALF);
	public static final BlockSlab SILVER_SLAB_HALF = new BlockHalfSlabBase("silver_slab_half", Material.IRON, FakePlayer.fakeplayerTAB, BlockInit.SILVER_SLAB_HALF, BlockInit.SILVER_SLAB_DOUBLE);
	public static final Block SILVER_STAIRS = new BlockStairBase("silver_stairs", BlockInit.SILVER_BLOCK.getDefaultState(), FakePlayer.fakeplayerTAB, 15.0f, 30.0f, SoundType.METAL, "pickaxe", 1);
	public static final Block SILVER_FENCE = new BlockSilverFence("silver_fence");
	public static final Block SILVER_PRESSURE_PLATE = new BlockSilverPressurePlate("silver_pressure_plate");
	public static final Block SILVER_BUTTON = new BlockSilverButton("silver_button");
	public static final Block LEMON_PLANT = new BlockLemonPlant("lemon_plant");
	public static final Block TEST_GRASS = new BlockTestGrass("test_grass");
	public static final Block TEST_DIRT = new BlockTestDirt("test_dirt");
	public static final Block TEST_FARMLAND = new BlockTestFarmland("test_farmland");
	//public static final Block TEST_GRASS_PATH = new BlockTestGrassPath("test_grass_path");
	public static final Block HONEY_BLOCK = new BlockHoney("honey_block");
	public static final Block GLOWSTONE_GENERATOR = new BlockGlowstoneGenerator("candy_cane_generator").setCreativeTab(FakePlayer.fakeplayerTAB);
	
	//Fluids
	public static final Block WHITE_WATER_FLUID = new BlockWhiteWaterFluid("white_water", FluidInit.WHITE_WATER_FLUID, Material.WATER);

	/*public static List<Block> getBlocks() 
	{
		Field[] declaredFields = BlockInit.class.getDeclaredFields();
		List<Field> staticFields = new ArrayList<Field>();
		List<Block> blocks = new ArrayList<Block>();
		for (Field field : declaredFields) 
		{
		    if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) 
		    {
		        staticFields.add(field);
		    }
		}
		staticFields.remove(0);
		for(String str : staticFields.toString().split("public static final net.minecraft.block.Block com.fakeplayer.turtywurty.init.BlockInit."))
		{
			str.replace(", ,", ",").replace("[[", "").replace("]]", "").replace("public static final net.minecraft.block.BlockSlab com.fakeplayer.turtywurty.init.BlockInit.", "");
			for(Field f : staticFields)
			{
				try {
					System.out.println(str);
					blocks.add((Block) f.get(str.split(",")[0]));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					
				}
			}
		}
		//System.out.println(blocks);
		return blocks;
	}*/
}