from typing import Any


class SingleNode:
    value: Any = None
    next = None


class LinkedList:
    def __init__(self, root=None):
        self.myHead: SingleNode = root
        if root:
            self.myTail = root
            while self.myTail.next:
                self.myTail = self.myTail.next

        self.myTail: SingleNode = None

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

    def find_middle(self) -> SingleNode:
        return LinkedList.middle(self.myHead)

    @classmethod
    def middle(cls, root: SingleNode):
        answer = root
        movers = root
        count = 0
        while movers:
            if count & 1:
                answer = answer.next
            count += 1
            movers = movers.next
        return answer

    @classmethod
    def merge(cls, first: SingleNode, second: SingleNode) -> SingleNode:
        dummy = SingleNode()
        dummy.value = -1
        build_list: SingleNode = dummy
        while first and second:
            if first.value < second.value:
                build_list.next = first
                first = first.next
            else:
                build_list.next = second
                second = second.next
            build_list = build_list.next
        if first:
            build_list.next = first
        if second:
            build_list.next = second

        return dummy.next


if __name__ == '__main__':
    num_nodes = 16
    data: LinkedList = LinkedList()
    for index in range(0, num_nodes):
        data.add(index)
    second_list: LinkedList = LinkedList()
    for index in range(num_nodes, num_nodes * 2):
        second_list.add(index)
    nodes = LinkedList.merge(second_list.myHead, data.myHead)
    mover = nodes
    while mover:
        print(f'{mover.value}')
        mover = mover.next
