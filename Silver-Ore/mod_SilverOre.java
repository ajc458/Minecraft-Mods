package net.minecraft.src;

import java.util.Random;

public class mod_SilverOre extends BaseMod 
{
	
	public static final Block SilverOre = new BlockSilverOre(201, 0).setHardness(1.5F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setBlockName("Silver Ore");
	public static final Block SilverSand = new BlockSilverSand(202, 0).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundSandFootstep).setBlockName("Silver Sand");
	public static final Item SilverBar = (new ItemSilverBar(ModLoader.getUniqueEntityId())).setItemName("Silver Bar");
	
	public mod_SilverOre() 
	{
		ModLoader.RegisterBlock(SilverOre);
		ModLoader.RegisterBlock(SilverSand);
		ModLoader.AddName(SilverOre, "Silver Ore");
		ModLoader.AddName(SilverBar, "Silver Bar");
		ModLoader.AddName(SilverSand, "Silver Sand");
		ModLoader.AddSmelting(SilverOre.blockID, new ItemStack(SilverBar));
		ModLoader.AddRecipe(new ItemStack(SilverSand, 1), new Object[] {"###", "XXX", Character.valueOf('#'), SilverBar, Character.valueOf('X'), Block.sand});
		SilverOre.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "silver.png");
		SilverSand.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "silversand.png");
		SilverBar.iconIndex = ModLoader.addOverride("/gui/items.png", "silverbar.png");
	}
	
	public String getVersion()
	{
		return "1.1";
	}
	
	public void load()
	{
		return;
	}
	
	public void GenerateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        for(int i = 0; i < 35; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(65);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new WorldGenMinable(SilverOre.blockID, 5)).generate(world, rand, randPosX, randPosY, randPosZ); 
        }
    }
	
}