import java.util.Arrays;
import java.util.Scanner;

class StackingBlocks {
  public int getMaxHeight(int[][] blocks) {
    // sorting each block in ascending order with their values
    for (int[] b : blocks) {
      Arrays.sort(b);
    }

    Arrays.sort(blocks, (a, b) -> {
      if (a[0] != b[0])
        return a[0] - b[0];
      if (a[1] != b[1])
        return a[1] - b[1];
      return a[2] - b[2];
    });

    // maxHeights[i] := max height w/ blocks[i] in the bottom
    int[] maxHeights = new int[blocks.length];

    // get the highest values in maxHeights array
    for (int i = 0; i < blocks.length; ++i) {
      maxHeights[i] = blocks[i][2];
    }

    for (int i = 1; i < blocks.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (blocks[j][0] <= blocks[i][0] &&
                blocks[j][1] <= blocks[i][1] &&
                blocks[j][2] <= blocks[i][2]) {
          maxHeights[i] = Math.max(maxHeights[i], maxHeights[j] + blocks[i][2]);
        }
      }
    }

    return Arrays.stream(maxHeights).max().getAsInt();
  }

  public static void main(String[] args)
  {
    int row, col, i, j;
    Scanner sc=new Scanner(System.in);

    // enter row and column for array.
    System.out.print("Enter row for the array (max 10) : ");
    row = sc.nextInt();
    System.out.print("Enter column for the array (max 10) : ");
    col = sc.nextInt();
    int[][] arr = new int[row][col];
    // enter array elements.
    System.out.println("Enter " + (row * col) + " Array Elements : ");
    for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    StackingBlocks stackingBlocks = new StackingBlocks();
    System.out.println("Max Height is:" + stackingBlocks.getMaxHeight(arr));
  }
}