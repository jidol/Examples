from unittest import TestCase
try:
    from src.linkedlist import LinkedList
except Exception as ex:
    from linkedlist import LinkedList


class TestLinkedList(TestCase):
    def test_add(self):
        subject: LinkedList = LinkedList()
        for index in range(1, 10):
            subject.add(index)
        for index in range(1, 10):
            print(f'Index {index} : Value {subject.pop()}')

    def test_tail(self):
        subject: LinkedList = LinkedList()
        for index in range(1, 10):
            subject.add(index)
        for index in range(1, 10):
            print(f'Index {index} : Value {subject.pop_tail()}')
