import org.junit.Assert;
import org.junit.Test;

public class StackTest {

  private final StackingBlocks stack = new StackingBlocks();

  @Test
  public void stackBlockTest_with3Blocks() {
    int[][] blocks = {{50,45,20},{95,37,53},{45,23,12}};
    int maxHeight = stack.getMaxHeight(blocks);
    Assert.assertEquals(190, maxHeight);
  }

  @Test
  public void stackBlockTest_with2Blocks() {
    int[][] blocks = {{38,25,45},{76,35,3}};
    int maxHeight = stack.getMaxHeight(blocks);
    Assert.assertEquals(76, maxHeight);
  }

  @Test
  public void stackBlockTest_with6Blocks() {
    int[][] blocks = {{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}};
    int maxHeight = stack.getMaxHeight(blocks);
    Assert.assertEquals(102, maxHeight);
  }

  @Test
  public void stackBlockTest_with4Blocks() {
    int[][] blocks = {{7,11,24},{3,25,98},{11,7,25},{2,7,35}};
    int maxHeight = stack.getMaxHeight(blocks);
    Assert.assertEquals(133, maxHeight);
  }

  @Test
  public void stackBlockTest_with3Blocks_custom() {
    int[][] blocks = {{38,25,45},{76,35,30},{97,25,40}};
    int maxHeight = stack.getMaxHeight(blocks);
    Assert.assertEquals(142, maxHeight);
  }
}
