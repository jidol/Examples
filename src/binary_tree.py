from typing import Any


class BinaryTree:
    value: Any = None
    left = None
    right = None
    parent = None

    def length(self) -> int:
        count = self._length(self)
        return count

    def _length(self, tree):
        count = 0
        if tree:
            count += 1
            count += self._length(tree.left)
            count += self._length(tree.right)
        return count

    def add_value(self, value) -> None:
        """
        Add new node to tree
        :param value:  Value
        :return:  None
        """
        if None is self.value:
            print('add root')
            self.value = value
        elif self.value != value:
            if value < self.value:
                if None is self.left:
                    self.left = BinaryTree()
                    self.left.parent = self
                print('add left')
                self.left.add_value(value)
            else:
                if None is self.right:
                    self.right = BinaryTree()
                    self.right.parent = self
                print('add right')
                self.right.add_value(value)

    def find_value(self, value):
        """
        Find the subtree matching the provided value
        :param value:  Value to match
        :return:  None or subtree
        """
        if value == self.value:
            return self
        else:
            if self.value > value and self.left:
                return self.left.find_value(value)
            elif self.value < value and self.right:
                return self.right.find_value(value)
        return None

    def print(self) -> None:
        """
        Print tree values
        :return:
        """
        result: str = self._print_tree(self)
        print(result)

    def _print_tree(self, tree) -> str:
        """
        Print Node vlaues
        :param tree:  Tree to print
        :return: Data as string
        """
        result = None
        if None is not tree:
            if None is not tree.value:
                result = f'[{tree.value}]'
                left: str = self._print_tree(tree.left)
                right: str = self._print_tree(tree.right)
                if left or right:
                    result = f'{result} ('
                    if left:
                        result = f'{result} L{left}'
                    if right:
                        result = f'{result} R{right}'
                    result = f'{result} )'
                else:
                    result = f'{result} (EMPTY)'
        return result

    def remove_value(self, value):
        """
        Remove value from this tree
        :param value:  Value to remove
        :return:  Updated tree
        """
        return self.remove_node(self, value)

    def remove_node(self, tree, value):
        """
        Remove a node from the tree
        :param tree:  Tree to remove from within
        :param value:  Value to remove
        :return: Updated tree
        """
        if None is tree:
            return tree
        else:
            if value < tree.value:
                tree.left = self.remove_node(tree.left, value)
            elif value > tree.value:
                tree.right = self.remove_node(tree.right, value)
            else:
                if None is tree.right:
                    return tree.left
                if None is tree.left:
                    return tree.right
                # Get Min Right Value
                temp_node = tree.right
                the_min = temp_node.value
                while temp_node.left:
                    temp_node = temp_node.left
                    the_min = temp_node.value
                # Now remove it from the right tree
                tree.right = self.remove_node(tree.right, the_min)
        return tree
