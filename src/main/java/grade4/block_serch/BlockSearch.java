package grade4.block_serch;


/**
 * Created by imccl on 2017/12/19.
 */
public class BlockSearch {

    private class Block {
        private int start;
        private int maxKey;

        public Block() {
        }

        public Block(int start, int maxKey) {
            this.start = start;
            this.maxKey = maxKey;
        }
    }

    public Block[] createBlocks(int[] data, int blockSize) {
        int totalSize = data.length;
        int blockNumber = totalSize / blockSize;
        int remainder = totalSize % blockSize;
        blockNumber = remainder == 0 ? blockNumber : ++blockNumber;
        Block[] blocks = new Block[blockNumber];
        for (int i = 0; i < blocks.length; i++) {
            Block block = new Block();
            int blockInnerIndex = 0;
            int blockStartIndex = blockSize * i;
            block.start = blockStartIndex;
            block.maxKey = data[blockStartIndex];
            int traverseIndex = blockStartIndex + blockInnerIndex;
            while (blockInnerIndex < blockSize && traverseIndex < totalSize) {
                if (data[traverseIndex] > block.maxKey) {
                    block.maxKey = data[traverseIndex];
                }
            }
            blocks[i] = block;
        }
        Block[] sortedResults = new Block[blockNumber];
        for (int i = 0; i < blocks.length; i++) {
            Block comparedBlock = blocks[i];
            for (int j = i + 1; j < blocks.length; j++) {
                Block toCompareBlock = blocks[j];
                if (comparedBlock.maxKey > toCompareBlock.maxKey) {
                    comparedBlock = toCompareBlock;
                }
            }
            sortedResults[i] = comparedBlock;
        }
        return sortedResults;
    }

    public int search(int[] data) {
        return -1;
    }

}
