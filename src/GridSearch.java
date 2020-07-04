import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GridSearch {
	
	
	private static void print(Set<Block> blocks) {
		
		for(Block b:blocks) {
			System.out.println(b.toString());
		}
		
		System.out.println("Largest block size"+blocks.size());
	}

	public static void main(String[] args) {
	
		 Map<BlockLocation, Block> blockMap =new HashMap<>();
		 BlockLocation bl1 = new BlockLocation(0, 0);
		 Block blk1 = new Block(0, 0, Color.GREEN);
		 blockMap.put(bl1, blk1);
		 
		 BlockLocation bl2 = new BlockLocation(0, 1);
		 Block blk2 = new Block(0, 1, Color.GREEN);
		 blockMap.put(bl2, blk2);	 
		 
		 BlockLocation bl3 = new BlockLocation(0, 2);
		 Block blk3 = new Block(0, 2, Color.GREEN);
		 blockMap.put(bl3, blk3);	 
		 
		 
		 BlockLocation bl4 = new BlockLocation(1, 0);
		 Block blk4= new Block(1, 0, Color.RED);
		 blockMap.put(bl4, blk4);	 
		 
		 BlockLocation bl5 = new BlockLocation(1, 1);
		 Block blk5= new Block(1, 1, Color.RED);
		 blockMap.put(bl5, blk5);	
		 
		 
		 BlockLocation bl6 = new BlockLocation(1, 2);
		 Block blk6=new Block(1, 2, Color.RED);
		 blockMap.put(bl6, blk6);	
		 
		 
		 
		 BlockLocation bl7 = new BlockLocation(2, 0);
		 Block blk7=new Block(2, 0, Color.RED);
		 blockMap.put(bl7, blk7);
		 
		 
		 BlockLocation bl8 = new BlockLocation(2, 1);		 
		 Block blk8=new Block(2, 1, Color.RED);
		 blockMap.put(bl8, blk8);
		 
		 BlockLocation bl9 = new BlockLocation(2, 2);
		 Block blk9=new Block(2, 2, Color.GREEN);
		 blockMap.put(bl9, blk9);
		 
		 
		 Grid grid = new Grid(blockMap);
		 Set<Block> largestBlock = grid.getLargestBlock();
		 
		 print(largestBlock);
		 
	}

}
