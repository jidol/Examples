import unittest
try:
    from src.doubleLinkedList import DoubleLinkedList
except Exception as ex:
    from doubleLinkedList import DoubleLinkedList

class TestDoubleLinked(unittest.TestCase):
    def test_add(self):
        subject: DoubleLinkedList = DoubleLinkedList()
        for index in range(1, 10):
            subject.add(index)
        for index in range(1, 10):
            print(f'Index {index} : Value {subject.pop()}')

    def test_tail(self):
        subject: DoubleLinkedList = DoubleLinkedList()
        for index in range(1, 10):
            subject.add(index)
        while subject.hasNext():
            print(f'Value {subject.pop_tail()}')

