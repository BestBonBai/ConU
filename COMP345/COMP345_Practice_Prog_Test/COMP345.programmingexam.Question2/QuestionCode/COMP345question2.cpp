// Original code from the web: 
// https://github.com/kamal-choudhary/singly-linked-list
// https://www.codementor.io/codementorteam/a-comprehensive-guide-to-implementation-of-singly-linked-list-using-c_plus_plus-ondlm5azr

#include<iostream>
using namespace std;
struct Node {
	int data;
	Node *next;	
};

class List {
private:
	Node *head, *tail;
public:
	List() {
		head=NULL;
		tail=NULL;
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
	}
	void delete_first(){
		Node *temp=new Node;
		temp=head;
		head=head->next;
		delete temp;
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
	}
};
int main(){
	List obj;
	obj.createnode(25);
	obj.createnode(50);
	obj.createnode(90);
	obj.createnode(40);
	cout<<"\n--------------------------------------------------\n";
	cout<<"---------------Displaying All nodes---------------";
	cout<<"\n--------------------------------------------------\n";
	obj.display();
	cout<<"\n--------------------------------------------------\n";
	cout<<"-----------------Inserting At End-----------------";
	cout<<"\n--------------------------------------------------\n";
	obj.createnode(55);
	obj.display();
	cout<<"\n--------------------------------------------------\n";
	cout<<"----------------Inserting At Start----------------";
	cout<<"\n--------------------------------------------------\n";
	obj.insert_start(50);
	obj.display();
	cout<<"\n--------------------------------------------------\n";
	cout<<"-------------Inserting At Particular--------------";
	cout<<"\n--------------------------------------------------\n";
	obj.insert_position(5,60);
	obj.display();
	cout<<"\n--------------------------------------------------\n";
	cout<<"----------------Deleting At Start-----------------";
	cout<<"\n--------------------------------------------------\n";
	obj.delete_first();
	obj.display();
	cout<<"\n--------------------------------------------------\n";
	cout<<"-----------------Deleting At End-------------------";
	cout<<"\n--------------------------------------------------\n";
	obj.delete_last();
	obj.display();
	cout<<"\n--------------------------------------------------\n";
	cout<<"--------------Deleting At Particular--------------";
	cout<<"\n--------------------------------------------------\n";
	obj.delete_position(4);
	obj.display();
	int x; cin >> x;
	return 0;
}