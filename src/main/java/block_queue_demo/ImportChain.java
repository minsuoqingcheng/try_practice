package block_queue_demo;

import java.util.ArrayList;
import java.util.List;

public class ImportChain {

    private static List<Block> blockChain = new ArrayList<>();
    private static final int difficulty = 5;

    public static void main(String[] args) {

        System.out.println("正在尝试挖掘block 1... ");
        addBlock(new Block("Hi im the first block", "0"));
        System.out.println("正在尝试挖掘block 2... ");
        addBlock(new Block("Yo im the second block", blockChain.get(blockChain.size()-1).getHash()));
        System.out.println("正在尝试挖掘block 3... ");
        addBlock(new Block("Hey im the third block", blockChain.get(blockChain.size()-1).getHash()));

        System.out.println("\nBlockChain is Valid: " + isValidChain());
        String blockChainJson = StringUtil.getJson(blockChain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockChainJson);
    }


    public static void addBlock(Block block) {
        block.mineBlock(difficulty);
        blockChain.add(block);
    }


    public static boolean isValidChain() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = StringUtil.getDifficultyString(difficulty);
        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }

}
