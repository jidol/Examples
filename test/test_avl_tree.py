from unittest import TestCase

from binary_tree import BinaryTreeNode
from avl_tree import AvlTree


class TestAvlTree(TestCase):
    def test_add_print(self):
        subject: AvlTree = AvlTree(0)
        for index in reversed(range(1, 5)):
            subject.add_value(index)
        for index in range(5, 11):
            subject.add_value(index)
        self.assertEqual(11, subject.length())

        for index in range(0, 11):
            found: BinaryTreeNode = subject.find_value(index)
            self.assertIsNotNone(found, "Should find a node")
            self.assertEqual(index, found.value, "Should be expected value")

    def test_remove(self):
        subject: AvlTree = AvlTree(1)
        first_element = 1
        last_element: int = 10
        last_element_to_keep = 5
        for index in reversed(range(first_element, last_element+1)):
            subject.add_value(index)
        for index in range(last_element_to_keep+1, last_element+1):
            if subject:
                subject.remove_value(index)
                self.assertIsNone(subject.find_value(index), f'Should not have index removed {index}')
            else:
                self.fail(f'Subject None at {index}')
        subject.print()
        self.assertEqual(last_element_to_keep, subject.length())
        for index in range(1, last_element_to_keep+1):
            found: BinaryTreeNode = subject.find_value(index)
            self.assertIsNotNone(found, f'Should find node at {index}')
            self.assertEqual(index, found.value, f'Should have expected value at {index} but was {found.value}')




