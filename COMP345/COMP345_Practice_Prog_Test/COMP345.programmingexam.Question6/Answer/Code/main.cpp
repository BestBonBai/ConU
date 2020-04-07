#include "main.h"

//Default constructor
MyArray::MyArray() {
    theArray = new int[0];
    size = 0;
}

//Passing a static array
MyArray::MyArray(int array[], int size) {
    theArray = new int[0];
    int counter = 0;
    for (int i = 0; i < size; ++i) {
        if(!isInArray(array[i])) {
           *(theArray+counter) = array[i]; 
           counter += 1;
        }
    } 
}

//Copy constructor
MyArray::MyArray(MyArray& another) {
    this->size = another.getSize();
    theArray = new int[size];
    for(int i = 0; i< size; ++i) {
        this->theArray[i] = another.getArray()[i];
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
    int temp[] = {3, 5, 2, 14, 2, 2};
    int sizeTemp = sizeof(temp);
    MyArray* obj = new MyArray(temp, sizeTemp);

    MyArray* copiedArray = new MyArray(*obj);
    std::cout << "Obj's array: " << std::endl;
    std::cout << *obj << std::endl;
    std::cout << "Copied array: " << std::endl;
    std::cout << *copiedArray << std::endl;
}
