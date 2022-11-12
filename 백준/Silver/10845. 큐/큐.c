#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct _node
{
	int data;
	struct _node * next;
}Node;

typedef struct _queue
{
	Node * head;
	Node * tail;
	int size;
}Queue;

void QueueInitialize(Queue * _queue)
{
	Node * newNode = (Node*)malloc(sizeof(Node));
	newNode->next = NULL;

	_queue->head = newNode;
	_queue->tail = _queue->head;
	_queue->size = 0;
}

void Push(Queue * _queue, int data)
{
	Node * newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;
	newNode->next = NULL;
	
	_queue->tail->next = newNode;
	_queue->tail = _queue->tail->next;
	_queue->size++;
}
int Pop(Queue * _queue)
{
	Node * temp;
	int data;
	
	if (_queue->size == 0)
		return -1;
	
	temp = _queue->head->next;
	data = temp->data;

	_queue->head->next = _queue->head->next->next;
	free(temp);
	_queue->size--;
	
	if (_queue->size == 0)
		_queue->tail = _queue->head;

	return data;
}
int Size(Queue * _queue)
{
	return _queue->size;
}
int isEmpty(Queue * _queue)
{
	if (_queue->size == 0)
		return 1;
	else
		return 0;
}

int Front(Queue * _queue)
{
	if (_queue->size == 0)
		return -1;
	else
		return _queue->head->next->data;
}

int Back(Queue * _queue)
{
	if (_queue->size == 0)
		return -1;
	else
		return _queue->tail->data;
}

int main (void)
 {
	int n,data;
	char str[10];
	
	Queue queue;
	
	QueueInitialize(&queue);
	
	scanf("%d", &n);

	while (n--)
	{
		scanf("%s", str);
		
		if (!strcmp(str,"push"))
		{
			scanf("%d", &data);
			Push(&queue, data);
		}
		else if (!strcmp(str, "pop"))
			printf("%d\n", Pop(&queue));
		else if (!strcmp(str, "size"))
			printf("%d\n", Size(&queue));
		else if (!strcmp(str, "empty"))
			printf("%d\n", isEmpty(&queue));
		else if (!strcmp(str, "front"))
			printf("%d\n", Front(&queue));
		else if (!strcmp(str, "back"))
			printf("%d\n", Back(&queue));
	}
}



