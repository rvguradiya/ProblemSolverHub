/*

Create Multi Level Doubly Linked List and then fletten it

*/


#include<stdio.h>
#include<stdlib.h>

typedef struct _node
{
int data;
struct _node *next;
struct _node *previous;
struct _node *down;
}Node;

typedef struct _stack_node
{
Node *data;
struct _stack_node *next;
struct _stack_node *previous;
}StackNode;

StackNode *top=NULL;

void push(Node *data)
{
StackNode *t;
t=(StackNode *)malloc(sizeof(StackNode));
t->data=data;
t->next=NULL;
t->previous=NULL;
if(top==NULL)
{
top=t;
}
else
{
top->next=t;
t->previous=top;
top=t;
}
}

Node *pop()
{
StackNode *t;
Node *data;
if(top==NULL) return NULL;
t=top;
top=top->previous;
if(top!=NULL)
top->next=NULL;
data=t->data;
free(t);
return data;
}

int isEmpty()
{
if(top==NULL) return 0;
return 1;
}

Node *head=NULL;
//Node *tail=NULL;
Node * createNode(int data)
{
Node *node;
node=(Node *)malloc(sizeof(Node));
if(node==NULL) return NULL;
node->data=data;
node->next=NULL;
node->previous=NULL;
node->down=NULL;
}

void createMultiLevelDoublyLinkedList(int *arr,int size)
{
if(size<=0) return;
int x,zeroCount;
Node *t;
Node *start,*end;
zeroCount=0;
start=head;
for(x=0;x<size;x++)
{
if(arr[x]!=0)
{
t=createNode(arr[x]);
if(start==NULL)
{
head=start=end=t;
}
else
{
end->next=t;
t->previous=end;
end=t;
}
}
else
{
while(arr[x]==0) 
{
zeroCount++;
x++;
}
while(zeroCount>1)
{
start=start->next;
zeroCount--;
}
t=createNode(arr[x]);
start->down=t;
start=t;
end=t;
zeroCount--;
}
}
}

void flattenMultiLevelDoublyLinkedList()
{
Node *t=head;
while(t)
{
printf("%d ",t->data);
if(t->down!=NULL)
{
push(t);
t=t->down;
}
else
{
t=t->next;
}
}
while(top!=NULL)
{
t=pop();
t=t->next;
while(t)
{
printf("%d ",t->data);
t=t->next;
}
}

}

int main()
{
int arr[]={10,50,5,70,62,93,84,0,0,0,70,50,0,0,67,84,0,32};
createMultiLevelDoublyLinkedList(arr,sizeof(arr)/sizeof(int));
flattenMultiLevelDoublyLinkedList();
return 0;
}