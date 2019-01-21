/*
 * Name: Zyra De Los Reyes
 * Course: CmpSci 2261 - 001
 * Instructor: Dr. Dhou
 * Project_6: Write a simple chain code program using the Freeman chain code concept
 * Date: 12/12/2017
 *
 */
public class ImageProcessing
{
    public static void main(String[] args)
    {
        System.out.println("\t\tFirst Testing Image");
        //Creates 2d array with specified initial values.
        //This represents binary images consisting of zeros and ones
        int [][]first_testing_image =
                {
                        {0,1,0,0,0,0,0,0},
                        {0,1,0,0,0,1,0,0},
                        {0,1,1,1,0,0,1,0},
                        {0,0,0,1,1,0,0,1},
                        {0,0,0,0,1,0,0,1},
                        {0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,1,0}
                };
        print_array(first_testing_image);
        System.out.println("\nOutput: ");
        image_ranger(first_testing_image);
        System.out.println();

        System.out.println("\t\tSecond Testing Image");
        int [][]second_testing_image =
                {
                        {0,0,0,0,0,0,0,0},
                        {0,1,1,1,1,0,1,0},
                        {0,0,0,0,1,0,1,0},
                        {0,0,1,1,1,0,1,0},
                        {0,0,1,0,0,0,1,0},
                        {0,0,1,0,0,0,1,0},
                        {0,0,0,0,0,0,1,1},
                        {0,0,0,0,0,0,0,0}
                };
        print_array(second_testing_image);
        System.out.println("\nOutput: ");
        image_ranger(second_testing_image);
    }
    //print_array function simply prints the given 2d array
    public static void print_array(int[][] pixel){
        for (int[] aPixel : pixel) {
            for (int anAPixel : aPixel) {
                System.out.print("\t" + anAPixel + " ");
            }
            System.out.println();
        }
    }

    /*
        The image_ranger searches for the first occurrence of '1' in the 2d array.
        While the first digit '1' is found, then this function will then look for the final chain.
        And if the final chain is found, this function will continue to find where '1' occurs based from
        its location from the 8 cardinal direction.
        321
        4x0
        567
        Once all occurrences of '1' are found, every '1' digit in this array will now become '0'
     */
    public static void image_ranger (int [][] pixel)
    {
        int x, y;

        //Loops through the entire array
        //for every index in each row
        for(int row = 0; row < 7; row++)
        {   //and for each column
            for(int col = 0; col < 8;col++)
            {
                x = row;
                y = col;

                //looks for '1' until the final chain is located
                while(pixel[x][y] == 1)
                {
                    int index = 0;

                    //8 possible directions in the Freeman chain code are used here
                    //counterclockwise starting from the 4 main direction then the diagonals
                    //the first statement for each conditions checks the array bounds

                    if((x+1) != 7 && pixel[x+1][y] == 1)
                    {
                        System.out.print("6 ");  //down
                        pixel[x][y] = 0;
                        x++;
                        index++;

                    }
                    else if ((y+1) != 8 && pixel[x][y+1] == 1)
                    {
                        System.out.print("0 ");
                        pixel[x][y] = 0;
                        y++;
                        index++;
                    }

                    else if ((x-1) != -1 && pixel[x-1][y] == 1)
                    {
                        System.out.print("2 ");
                        pixel[x][y] = 0;
                        x--;
                        index++;
                    }

                    else if ((y-1) != -1 && pixel[x][y-1] == 1)
                    {
                        System.out.print("4 ");
                        pixel[x][y] = 0;
                        y--;
                        index++;
                    }
                    else if (((x+1) != 7 && (y-1) != -1) && pixel[x+1][y-1] == 1)
                    {
                        System.out.print("5 ");
                        pixel[x][y] = 0;
                        y--;
                        x++;
                        index++;
                    }
                    else if (((x+1) != 7 && (y+1) != 8) && pixel[x+1][y+1] == 1)
                    {
                        System.out.print("7 ");
                        pixel[x][y] = 0;
                        y++;
                        x++;
                        index++;
                    }
                    else if (((x-1) != -1 && (y-1) != -1) && pixel[x-1][y-1] == 1)
                    {
                        System.out.print("3 ");
                        pixel[x][y] = 0;
                        y--;
                        x--;
                        index++;
                    }
                    else if (((x-1) != -1 && (y+1) != 8) && pixel[x-1][y+1] == 1)
                    {
                        System.out.print("1 ");
                        pixel[x][y] = 0;
                        y++;
                        x--;
                        index++;
                    }

                    //indicates that the final chain was found
                    if (index == 0)
                    {
                        pixel[x][y] = 0;
                        System.out.println();
                    }
                }
            //end of col loop
            }
        //end of row loop
        }
    //end of image_ranger
    }
}
