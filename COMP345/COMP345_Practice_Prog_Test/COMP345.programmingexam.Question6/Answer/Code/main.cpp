#include "main.h"

//Default constructor
MyArray::MyArray() {
    theArray = new int[0];
    size = 0;
}

//Passing a static array
MyArray::MyArray(const int array[], int size) {
    theArray = new int[size];
    this->size = 0;
    for (int i = 0; i < size; ++i) {
        if(!isInArray(array[i])) {
            theArray[this->size++] = array[i];
        }
    } 
}

//Copy constructor
MyArray::MyArray(const MyArray& another) {
    this->size = another.size;
    if(another.theArray) {
        this->theArray = new int[this->size];
        for(int i = 0; i< size; ++i) {
            this->theArray[i] = another.theArray[i];
        }
    } else {
        this->theArray = 0;
    }
}

bool MyArray::isInArray(int check) {
    for(int i = 0; i<size; ++i) {
        if(theArray[i] == check){
            return true;
        }
    }
    return false;
}

MyArray::~MyArray() {
    std::cout << "Deallocating pointer" << std::endl;
    delete[] theArray;
    theArray = nullptr;
}

int main() {
  int arr[] = { 1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,8,9,9 };
	MyArray* myArray = new MyArray(arr, 19);
  std::cout << *myArray << std::endl;

	MyArray* copiedArray = new MyArray(*myArray);
	int* copied = copiedArray->getArray();
	int size = copiedArray->getSize();

	for (int i = 0; i < size; i++) {
		std::cout << copied[i] << '\t';
	}
  std::cout << std::endl;

	delete myArray;
	delete copiedArray;

}
