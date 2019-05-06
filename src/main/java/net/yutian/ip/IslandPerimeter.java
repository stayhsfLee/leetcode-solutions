package net.yutian.ip;

/**
 * Created by LeeAutumn on 11/21/16.
 * blog: leeautumn.net
 */
public class IslandPerimeter {

    /**
     * 要求这个长方形版格中的连起来的岛的外围长度.
     * 并且无湖,有且只有一个岛
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int width     = grid[0].length;
        int height    = grid.length;
        int perimeter = 0;

        int left = 0;                      //In the same line,whether the left grid is land.
        int last;

        for(int i = 0;i<height;i++){
            last = 0;
            for(int j=0;j<width;j++){
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    if(last == 1){
                        perimeter -= 2;
                    }
                    last = 1;

                    //precess the line between two gridlines.
                    if( i > 0){
                        if(grid[i-1][j] == 1){
                            perimeter -= 2;
                        }
                    }
                }else{
                    last = 0;
                }
            }
        }

        return perimeter;
    }
}
