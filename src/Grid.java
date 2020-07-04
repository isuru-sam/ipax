import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grid {
	private Map<BlockLocation, Block> blockMap;


	private List<Set<Block>> totalIndependantSets = new ArrayList<>();

	public Grid(Map<BlockLocation, Block> blockMap) {		
		this.blockMap = blockMap;
	}

	
	private Set<Block> findSet(Block b) {
		for (Set<Block> s : totalIndependantSets) {

			for (Block bl : s) {

				if (bl.equals(b)) {
					return s;
				}
			}
		}
		return null;
	}

	private void processNeigbours(Block b) {

		Set<Block> ownedSet = null;
		BlockLocation topLocation = new BlockLocation(b.getX(), b.getY() - 1);
		Block top = blockMap.get(topLocation);
		if (top != null && top.getColor().equals(b.getColor())) {
			if (top.isVisited()) {
				ownedSet = findSet(top);
			}
		}
		BlockLocation bottomLocation = new BlockLocation(b.getX(), b.getY() + 1);
		Block bottom = blockMap.get(bottomLocation);
		if (bottom != null && bottom.getColor().equals(b.getColor())) {
			if (bottom.isVisited() && ownedSet == null) {
				ownedSet = findSet(bottom);
			}
		}

		BlockLocation leftLocation = new BlockLocation(b.getX() - 1, b.getY());
		Block left = blockMap.get(leftLocation);
		if (left != null && left.getColor().equals(b.getColor())) {
			if (left.isVisited() && ownedSet == null) {
				ownedSet = findSet(left);
			}
		}

		BlockLocation rightLocation = new BlockLocation(b.getX() + 1, b.getY());

		Block right = blockMap.get(rightLocation);

		if (right != null && right.getColor().equals(b.getColor())) {
			if (right.isVisited() && ownedSet == null) {
				ownedSet = findSet(right);
			}

		}

		if (ownedSet == null) {
			ownedSet = new HashSet<>();
			totalIndependantSets.add(ownedSet);
		}
		if(top!=null && top.getColor().equals(b.getColor())) {
		ownedSet.add(top);
		top.setVisited(true);
		}
		if(bottom!=null && bottom.getColor().equals(b.getColor())) {
		ownedSet.add(bottom);
		bottom.setVisited(true);
		}
		
		if(left!=null && left.getColor().equals(b.getColor())) {
			ownedSet.add(left);
			left.setVisited(true);
		}
		if(right!=null && right.getColor().equals(b.getColor())) {
			ownedSet.add(right);
			right.setVisited(true);
		}
		
	
		ownedSet.add(b);
		
		
		b.setVisited(true);
	}

	private void processBlocks() {
		for (Block b : blockMap.values()) {
			if (!b.isVisited()) {
				processNeigbours(b);
			}
		}

	}

	public Set<Block> getLargestBlock() {
		processBlocks();
		Set<Block> largest = new HashSet<>();

		for (Set<Block> sb : totalIndependantSets) {
			if (sb.size() > largest.size()) {
				largest = sb;
			}
		}

		return largest;

	}

}
