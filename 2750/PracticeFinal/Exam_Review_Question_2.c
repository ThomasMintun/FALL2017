/*
2. [25 pt] I have files whose data is alternating 2-byte integers and 4-byte
floats [IEEE standard]. I want to move these files to another computer
with the opposite endianness; i.e., you need to change the order of the
bytes in the integer and the float to the opposite order. I want you to
write a program which takes 2 command line arguments: an input file
name and an output file name. The program reads data from the first
file and writes the opposite endian data to the second file. [NOTE: you
need know nothing about the structure of IEEE floats!
*/

// At this point we are unsure what the question is asking so here are the two possibilities

/******* Michael's answer ********/ 

#include<stdio.h>
#include <string.h>

int main(int argc, char **argv){

	//open files for read and write
        FILE *fr = fopen(argv[1], "rb");
        FILE *fw = fopen(argv[2], "wb");

		// create arrays
        char i[2];
        char l[4];
        char a[2];
        char b[4];


        while (!feof(fr)){
			// read in the bytes until end of file
                fread(i, sizeof(i[0]), 2, fr);
                fread(l, sizeof(l[0]), 4, fr);
				
				//reverse bytes of int
                int x = 0;
                for(x;x<2;x++)
                        a[x] = i[1-x];
                        
				//write
                fwrite(a, sizeof(a[0]), 2, fw);
                
				// reverse bytes of float
                x=0;
                for(x;x<4;x++)                  
                        b[x] = l[3-x];
                
				//write
                fwrite(b, sizeof(b[0]), 4, fw);
				
				//clear arrays
                memset(&i[0], 0, sizeof(i));
                memset(&l[0], 0, sizeof(l));
        }
        return 0;
}


