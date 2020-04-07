// Original code from the web: 
// https://github.com/kamal-choudhary/singly-linked-list
// https://www.codementor.io/codementorteam/a-comprehensive-guide-to-implementation-of-singly-linked-list-using-c_plus_plus-ondlm5azr

#include<iostream>
#include<string>

using namespace std;

struct Node {
	int data;
	Node *next;	
};

class List {
private:
	Node *head, *tail;
  int size;
public:
	List() {
		head=NULL;
		tail=NULL;
    size=0; 
	}

	void createnode(int value){
		Node *temp=new Node;
		temp->data=value;
		temp->next=NULL;
		if(head==NULL){
			head=temp;
			tail=temp;
			temp=NULL;
		}
		else{	
			tail->next=temp;
			tail=temp;
		}
    size+=1;
	}

	void display(){
		Node *temp=new Node;
		temp=head;
		while(temp!=NULL){
			cout<<temp->data<<"\t";
			temp=temp->next;
		}
	}

	void insert_start(int value){
		Node *temp=new Node;
		temp->data=value;
		temp->next=head;
		head=temp;
    size += 1;
	}

	void insert_position(int pos, int value){
		Node *pre=new Node;
		Node *cur=new Node;
		Node *temp=new Node;
		cur=head;
		for(int i=1;i<pos;i++){
			pre=cur;
			cur=cur->next;
		}
		temp->data=value;
		pre->next=temp;	
		temp->next=cur;
    size += 1;
	}

	void delete_first(){
		Node *temp=new Node;
		temp=head;
		head=head->next;
		delete temp;
    size -= 1;
	}

	void delete_last(){
		Node *current=new Node;
		Node *previous=new Node;
		current=head;
		while(current->next!=NULL){
			previous=current;
			current=current->next;	
		}
		tail=previous;
		previous->next=NULL;
		delete current;
    size -= 1;
	}

	void delete_position(int pos){
		Node *current=new Node;
		Node *previous=new Node;
		current=head;
		for(int i=1;i<pos;i++){
			previous=current;
			current=current->next;
		}
		previous->next=current->next;
		delete current; 
    size -= 1;
	}

// Add on functions:
// Part 1:
  friend ostream& operator<<(ostream& output, const List &ls) {
		Node *temp=new Node;
		temp = ls.head;
		while(temp!=NULL){
			output <<temp->data<<"\t";
			temp=temp->next;
		}
    return output;
    }

// Part 2:
  friend istream& operator>>(istream& input, List& ls) {
    int newValue;
    input >> newValue;
    ls.createnode(newValue);
    return input;
  }

// Part 3:
  friend const List operator+(List& a, List& b) {
    List result;
    int sizeResult = (a.size < b.size) ? a.size : b.size;

    Node* indexA = new Node;
    indexA = a.head;
    Node* indexB = new Node;
    indexB = b.head;
    
    for(int i = 0; i< sizeResult; ++i) {
        result.createnode(indexA->data + indexB->data);
        indexA = indexA->next;
        indexB = indexB->next;
    }

    return result;
  }

// Part 4:
    inline  bool isEmpty() {
      return (size == 0);
    }

    void deleteAll() {
        if(isEmpty()) {
            return;
        }
        Node* temp = new Node;
        temp = this->head;
        while(temp != NULL) {
            Node* remove = new Node;
            remove = temp;
            temp = temp->next;
            head = head->next;
            delete remove;
        }
        tail = NULL;
    }

    const List& operator=(const List& another) {
        if(&another != this) {
            deleteAll();
            Node* temp = new Node;
            temp = another.head;
            while (temp != NULL) {
                this->createnode(temp->data);
                temp = temp->next;
            }
        }
        return *this;
    }

// Part 5
    List(const List& another) {
        Node* temp = new Node;
        temp = another.head;
        while(temp != NULL) {
            this->createnode(temp->data);
            temp = temp->next;
        }
    }

};

void part1() {
	List obj;
	obj.createnode(25);
	obj.createnode(50);
	obj.createnode(90);
	obj.createnode(40);
  cout << "Displaying all nodes using override operator" << endl;
  cout << obj;
}

void part2() {
	List obj;
	obj.createnode(25);
	obj.createnode(50);
	obj.createnode(90);
	obj.createnode(40);
  cout << "\nInput a new value to add to the list" << endl;
  cin >> obj;
  cout << "\nDisplaying the list" << endl;
  cout << obj;
}

void part3() {
  List result;

  List a;
  a.createnode(17);
  a.createnode(23);
  a.createnode(99);
  a.createnode(54);
  cout << "List a:" << a << endl;

  List b;
  b.createnode(12);
  b.createnode(48);
  cout << "List b:" << b << endl;
  
  result = a + b;

  cout << "Result of a + b: " << result << endl;
}

void part4() {
  List a;
  a.createnode(17);
  a.createnode(23);
  a.createnode(99);
  a.createnode(54);
  cout << "List a:" << a << endl;

  List b;
  b.createnode(12);
  b.createnode(48);
  cout << "List b:" << b << endl;

  b = a;
  cout << "After assigning a to b. Content of List b:" << b << endl;
  a = a;
  cout << "After assigning a to a. Content of List a:" << b << endl;
}

void part5() {
  List a;
  a.createnode(17);
  a.createnode(23);
  a.createnode(99);
  a.createnode(54);
  cout << "List a:" << a << endl;

  List b(a);
  cout << "List b after being constructed using List a:" << b << endl;
}

int main(){
// Individual tests can be called
//   part1();
//   part2();
//   part3();
//   part4();
//   part5();

List obj;
obj.createnode(25);
obj.createnode(50);
obj.createnode(90);
obj.createnode(40);
cout << "\n--------------------------------------------------\n";
cout << "---------------Displaying All nodes---------------";
cout << "\n--------------------------------------------------\n";
obj.display();
cout << "\n--------------------------------------------------\n";
cout << "-----------------Inserting At End-----------------";
cout << "\n--------------------------------------------------\n";
obj.createnode(55);
obj.display();
cout << "\n--------------------------------------------------\n";
cout << "----------------Inserting At Start----------------";
cout << "\n--------------------------------------------------\n";
obj.insert_start(50);
obj.display();
cout << "\n--------------------------------------------------\n";
cout << "-------------Inserting At Particular--------------";
cout << "\n--------------------------------------------------\n";
obj.insert_position(5, 60);
obj.display();
cout << "\n--------------------------------------------------\n";
cout << "----------------Deleting At Start-----------------";
cout << "\n--------------------------------------------------\n";
obj.delete_first();
obj.display();
cout << "\n--------------------------------------------------\n";
cout << "-----------------Deleting At End-------------------";
cout << "\n--------------------------------------------------\n";
obj.delete_last();
obj.display();
cout << "\n--------------------------------------------------\n";
cout << "--------------Deleting At Particular--------------";
cout << "\n--------------------------------------------------\n";
obj.delete_position(4);
obj.display();

cout << "\n--------------------------------------------------\n";
cout << "--------------Using answer code-----------------";
cout << "\n--------------------------------------------------\n";

cout << "\n--------------------------------------------------\n";
cout << "--------------Using copy constructor-----------------";
cout << "\n--------------------------------------------------\n";
List obj1(obj);
cout << obj1 << endl;

cout << "\n--------------------------------------------------\n";
cout << "--------------Using assignment operator-----------------";
cout << "\n--------------------------------------------------\n";
List obj2;
obj2 = obj1;
cout << obj1 << endl;

cout << "\n--------------------------------------------------\n";
cout << "--------------Using stream input------------------";
cout << "\n--------------------------------------------------\n";
cin >> obj1 >> obj1;
cout << obj1 << endl;

cout << "\n--------------------------------------------------\n";
cout << "--------------Using operator+------------------";
cout << "\n--------------------------------------------------\n";
List obj3, obj4;
obj3.createnode(1);
obj3.createnode(2);
obj3.createnode(3);
obj3.createnode(3);
obj4.createnode(4);
obj4.createnode(5);
obj4.createnode(6);
cout << "obj3 List: " << endl << obj3 << endl;
cout << "obj4 List: " << endl << obj4 << endl;
cout << "obj3 + obj4: " << endl << obj3 + obj4 << endl;

int x; cin >> x;
return 0;
}
