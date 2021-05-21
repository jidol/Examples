from typing import Any


class DoubleNode:
    value: Any = None
    next = None
    parent = None


class DoubleLinkedList:
    myHead: DoubleNode = None
    myTail: DoubleNode = None

    def add(self, value) -> None:
        """
        Add element to end of list
        :param value:  Value to add
        :return:  None
        """
        if None is self.myHead:
            self.myHead = DoubleNode()
            self.myHead.value = value
            self.myTail = self.myHead
        else:
            update = DoubleNode()
            update.value = value
            update.parent = self.myTail
            self.myTail.next = update
            self.myTail = update

    def push(self, value) -> None:
        """
        Prepend to the beginning
        :param value:  Value for node
        :return:  None
        """
        if None is self.myHead:
            self.myHead = DoubleNode()
            self.myHead.value = value
            self.myTail = self.myHead
        else:
            update = DoubleNode()
            update.value = value
            update.next = self.myHead
            self.myHead.parent = update
            self.myHead = update

    def pop(self) -> Any:
        """
        Pop the top value returning the value
        :return:  Value or None
        """
        result: Any = None
        if None is not self.myHead:
            if self.myHead.value == self.myTail.value:
                self.myTail = None
            result = self.myHead.value
            self.myHead = self.myHead.next
            if None is not self.myHead:
                self.myHead.parent = None
        return result

    def pop_tail(self):
        """
        Pop Tail element
        :return: Tail value or None
        """
        result: Any = None
        if self.myHead == self.myTail:
            result = self.myHead.value
            self.myTail = None
            self.myHead = None
        elif self.myTail:
            result = self.myTail.value
            self.myTail = self.myTail.parent
        return result

    def peek(self) -> Any:
        """
        Peek at the top value
        :return:  Value at top or None
        """
        result: Any = None
        if None is not self.myHead:
            result = self.myHead.value
        return result

    def hasNext(self) -> bool:
        """
        Check to see if we have a value
        :return:
        """
        return None is not self.myHead
