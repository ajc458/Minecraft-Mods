package net.minecraft.src;

import java.util.Random;

public class BlockSilverOre extends Block
{
    
	public BlockSilverOre(int i, int j)
    {
        super(i, j, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return blockID;
    }
    
}