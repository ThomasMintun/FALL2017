//Thomas Mintun
#include <stdio.h>
#include <stdlib.h>

void print_current(int iterator, FILE *filePtr){
	iterator++;
	fseek(filePtr, iterator, SEEK_CUR);
	printf("%02x", iterator);
}

void PrintStrings(int len, unsigned char *ret){
	int a;
	for (a = 0; a < len; a++){
		printf("%02x", a); //print byte position of first byte
		if (a < 16){
			printf("%02x ", ret[a]); //print first 16 bytes as hex numbers
		}
		printf(" ");
		//printASCII(1, ret[a])
		for (int x = 0; x < 16; x++){ //print the ASCII of the first 16 characters
			printf("%c", ret[a]);
		}
		printf("/n");
	}
}

/*void printASCII(int len, unsigned char *ret){
	int j
	printf(" ");
	for (j = 0; j < 16; j++){
		if(ret[j] < 0X20 || ret[j] > 0x7e){ //print ascii char if in range
			printf("%c", ret[j]);
		}
		else{ //print "." if not in range
			printf(".", ret[j]);
		}
	}
}*/

int main(int argc, char* argv[]) {
    FILE *filePointer = fopen("input.txt", "rb"); //b opens file and reads in binary
    fseek(filePointer, 0, SEEK_END); //filePointer is pointer to file that is open, 0 is start pos to read from; seek_end runs to end of file. Essentill getting length of file
    long len = ftell(filePointer); //ftell gets length from fsek and setting length for bytes read
    unsigned char *ret = malloc(len); //this is buffer holding everything; malloc based on file
    fseek(filePointer, 0, SEEK_SET); //puts pointer at beginnning of file
    fread(ret, 1, len, filePointer); //fread goes to buffer (ret), 1 characer at a time, for length of file, from the file being pointed by filePointer
    PrintStrings(len, ret);
    PrintStrings(len-1, ret-1);
    PrintStrings(len-2, ret-2);
    PrintStrings(len-3, ret-3);
    PrintStrings(len-4, ret-4);
    PrintStrings(len-5, ret-5);
    PrintStrings(len-6, ret-6);
    PrintStrings(len-7, ret-7); //assuming not more than 8 lines to process
    fclose(filePointer);
    free(ret);
    return 0;
}