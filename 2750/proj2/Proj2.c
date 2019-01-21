#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define MAXWORDS 10000
#define MAXSTRING 100
typedef int bool;
#define false 0;
#define true 1;

typedef struct Word{ //struct
    char word[MAXSTRING];
}Node; //NODE defined

typedef struct Sorted{ //sorted struct array
    char word[MAXSTRING];
    int numTimes;
}Node2; //NODE2 defined

char modWord(char sChange[MAXSTRING]);
Node2* initialize(Node2* wordArray, int count);// initialize array of structs
int compareStructs(const void* a, const void* b); //compares the structs for qsort
Node2* countOccurrence(Node2* finalArr, Node* wordArr, int count);

Node2* initialize(Node2* wordArray, int count){ //initialize Node2
    for(int i = 0; i < count-1; i++){
        wordArray[i].numTimes = 0;
    }
    return wordArray;
}

char modWord(char sChange[MAXSTRING]){ //modify word
    unsigned long length = strlen(sChange); //define length of word
    for(int i = 0; i < length; i++){ //loop to access string
        sChange[i] = tolower(sChange[i]); //converts all characters to lower case
        if(!(isalnum(sChange[i]))){
            for(int j = i; j < strlen(sChange); j++){
                sChange[j] = sChange[j + 1];
            }
        }
    }
    unsigned long len = strlen(sChange); //defines the length of the sChange
    sChange[len] = '\0'; //appends a null terminator to the end
    return *sChange;
}

int compareStructs(const void* a, const void* b){ //compare structs for qsort
    Node* node1 = (Node*)a; //for comparison in qsort
    Node* node2 = (Node*)b;
    return strcmp(node1->word, node2->word); //strcmp
}

Node2* countOccurrence(Node2* finalArr, Node* wordArr, int count){
    int index = 0;
    int i = 0;
    while(i < count){
        int comp = strcmp(finalArr[i].word, wordArr[index].word);
        if(comp == 0){
            finalArr[i].numTimes++;
            ++index;
        }
        else{
            ++i;
        }
    }
    return finalArr;
}

int main(int argc, char* argv[]){
	Node* wordArr = malloc(1 * sizeof(Node));
	FILE* finput;
	FILE* foutput;
	char sChange[MAXSTRING];
	int count = 0;
	if(argc !=3){
		printf("Enter more arguments!");
		return EXIT_FAILURE;
	}
	finput = fopen(argv[1], "r");
	foutput = fopen(argv[2], "w");
	if(finput == NULL){
		printf("Error.\n");
		return EXIT_FAILURE;
	}

	int k = 0;
	while(fscanf(finput, "%100s", sChange) == 1){
		count++;
		wordArr = realloc(wordArr, 1);
		modWord(sChange);
		strcpy(wordArr[k].word, sChange);
		k++;
	}

	Node2* finalArr = malloc(count * sizeof(Node2));
	initialize(finalArr, count);

	qsort(wordArr, count, sizeof(Node), compareStructs);

	int index = 0;
	for(int i = 0; i < count; i++){
		int compFront = strcmp(wordArr[i].word, wordArr[i+1].word);
        if((compFront != 0)){ //if the strings aren't equal
            strcpy(finalArr[index].word, wordArr[i].word); //then copy it over
            index++; //increment the index of the final array
        }
    }

    finalArr = countOccurrence(finalArr, wordArr, count); //counts the occurrence of words & returns array
    
    for(int x = 0; x < count; x++){
        fprintf(foutput, "%-17s", finalArr[x].word);
        fprintf(foutput, "%64d\n", finalArr[x].numTimes);
    }
    
    fclose(finput);
    fclose(foutput);
    
    return EXIT_SUCCESS;
}