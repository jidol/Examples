from typing import Any


class SingleNode:
    value: Any = None
    next = None


class LinkedList:
    myHead: SingleNode = None
    myTail: SingleNode = None

    def add(self, value) -> None:
        """
        Add element to end of list
        :param value:  Value to add
        :return:  None
        """
        if None is self.myHead:
            self.myHead = SingleNode()
            self.myHead.value = value
            self.myTail = self.myHead
        else:
            update = SingleNode()
            update.value = value
            self.myTail.next = update
            self.myTail = update

    def push(self, value) -> None:
        """
        Prepend to the beginning
        :param value:  Value for node
        :return:  None
        """
        if None is self.myHead:
            self.myHead = SingleNode()
            self.myHead.value = value
            self.myTail = self.myHead
        else:
            update = SingleNode()
            update.value = value
            update.next = self.myHead
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
        if self.myTail:
            result = self.myTail.value
            self.myTail = self._find_tail(self.myHead, self.myTail)
            if not self.myTail:
                self.myTail = self.myHead
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

    def has_next(self) -> bool:
        """
        Check to see if we have a value
        :return:
        """
        return None is not self.myHead

    def _find_tail(self, startPos: SingleNode, endPos: SingleNode) -> SingleNode:
        """
        Find last element
        :param startPos:  Starting Node
        :return:  Last node
        """
        while None is not startPos.next and startPos.next != endPos:
            startPos = startPos.next
        return startPos
