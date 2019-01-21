/* IIRC The problem was to take the first 10 bytes of a file and move them to the right by 10 bytes. This is Schulte's code from class */ 

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char* argv[]) {

  int fd = open(argv[1], O_RDWR);
  unsigned char buf[10];
  read (fd, buf, 10);
  lseek(fd, 20, SEEK_SET);
  write(fd, buf, 10);
  exit(0);
}