//Thomas Mintun CS2261 Project6
public class Project6{
	public static void main(String[] args){
	    int row = 0;
	    int col = 0;
int[][] img1 = {{0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0},{0,1,0,0,0,1,0,0,0},
        {0,1,1,1,0,0,1,0,0},{0,0,0,1,1,0,0,1,0},{0,0,0,0,1,0,0,1,0},
        {0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,0,0}};
int[][] img2 = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,1,1,1,1,0,1,0,0},
        {0,0,0,0,1,0,1,0,0},{0,0,1,1,1,0,1,0,0},{0,0,1,0,0,0,1,0,0},
        {0,0,1,0,0,0,1,0,0},{0,0,0,0,0,0,1,1,0},{0,0,0,0,0,0,0,0,0}};

loop:
for (int n = 0; n <= 7; n++){
	for (int m = 0; m <= 8; m++){
		if (img1[n][m] == 1){
			row = n;
			col = m;
			break loop; //breaking out of both loops
		}
	}
}
freeman(img1, row, col);
img1[row][col] = 0;

loop2:
for (int n = 0; n <= 7; n++){
	for (int m = 0; m <= 8; m++){
		if (img2[n][m] == 1){
			row = n;
			col = m;
			break loop2; //breaking out of both loops
		}
	}
}
freeman(img2, row, col);
img2[row][col] = 0;
}

public static void freeman(int[][] img, int row, int col){
if (col != 7 && img[row][col+1] == 1) {
col++;
img [row][col] = 0;
System.out.print("0 ");
freeman(img, row, col);
}
else if (row != 6 && img[row+1][col] == 1) {
row++;
img [row][col] = 0;
System.out.print("6 ");
freeman(img, row, col);
}
else if (col != 0 && img[row][col-1] == 1) {
col--;
img[row][col] = 0;
System.out.print("4 ");
freeman(img, row, col);
}
else if (row != 0 && img[row-1][col] == 1) {
row--;
img [row][col] = 0;
System.out.print("2 ");
freeman(img, row, col);
}
else if (col != 7 && row != 6 && img[row+1][col+1] == 1) {
col++;
row++;
img[row][col] = 0;
System.out.print("7 ");
freeman(img, row, col);
}
else if (col != 0 && row != 6 && img[row+1][col-1] == 1) {
col--;
row++;
img[row][col] = 0;
System.out.print("5 ");
freeman(img, row, col);
}
else if (col != 0 && row != 0 && img[row-1][col-1] == 1) {
col--;
row--;
img[row][col] = 0;
System.out.print("3 ");
freeman(img, row, col);
}
else if (col != 7 && row != 0 &&img[row-1][col+1] == 1) {
col++;
row--;
img[row][col] = 0;
System.out.print("1 ");
freeman(img, row, col);
}
else
System.out.println();
}}