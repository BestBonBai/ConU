//Header
#include <iostream>
using std::ostream;

class MyArray {
        int* theArray;
        int size;

    public:
        MyArray();
        MyArray(int array[], int size);
        MyArray(MyArray& array);

        const MyArray& operator=(MyArray& array);
        bool isInArray(int check);

        // Getter
        int* getArray();
        int getSize();

        ~MyArray();
};

inline int* MyArray::getArray() {return theArray;}
inline int MyArray::getSize() {return size;}

const MyArray& MyArray::operator=(MyArray& another) {
    if(&another != this) {
        delete[] this->getArray();
        size = another.getSize();
        theArray = new int[size];
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

