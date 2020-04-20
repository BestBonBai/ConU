//Header
#include <iostream>
using std::ostream;

class MyArray {
        int* theArray;
        int size;

    public:
        MyArray();
        MyArray(const int array[], int size);
        MyArray(const MyArray& array);

        MyArray& operator=(MyArray& array);
        bool isInArray(int check);

        // Getter
        int* getArray();
        int getSize();

        ~MyArray();
};

inline int* MyArray::getArray() {return theArray;}
inline int MyArray::getSize() {return size;}

MyArray& MyArray::operator=(MyArray& another) {
    if(&another != this) {
        delete[] this->getArray();
        size = another.getSize();
        if(another.theArray) {
            theArray = new int[size];
            for(int i = 0; i< this->size; i++) {
                this->theArray[i] = another.theArray[i];
            }
        } else {
            theArray = 0;
        }
    }

    return *this;
}

ostream& operator<<(ostream &output, MyArray& a) {
    int* p = a.getArray();
    for(int i = 0; i<a.getSize(); ++i) {
        output<< "\t" << *(p+i);
    }
    return output;
}

