from unittest import TestCase

from binary_tree import BinaryTree


class TestBinaryTree(TestCase):
    def test_add_print(self):
        subject: BinaryTree = BinaryTree()
        for index in reversed(range(1, 5)):
            subject.add_value(index)
        for index in range(5, 11):
            subject.add_value(index)
        self.assertEqual(10, subject.length())

    def test_remove(self):
        subject: BinaryTree = BinaryTree()
        for index in reversed(range(1, 6)):
            subject.add_value(index)
        for index in range(5, 11):
            subject.add_value(index)
        for index in range(5, 11):
            if subject:
                subject = subject.remove_value(index)
            else:
                self.fail(f'Subject None at {index}')
        self.assertEqual(5, subject.length())



