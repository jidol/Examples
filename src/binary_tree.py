from typing import Any


class BinaryTreeNode:
    def __init__(self, value):
        self.value: Any = value
        self.left = None
        self.right = None
        self.height: int = 1


class BinaryTree:

    def __init__(self, value: Any = None):
        self.tree: BinaryTreeNode = None
        if None is not value:
            self.tree: BinaryTreeNode = BinaryTreeNode(value)

    def length(self) -> int:
        count = self._node_count(self.tree)
        return count

    def _node_count(self, node: BinaryTreeNode) -> int:
        count = 0
        if node:
            count += 1
            count += self._node_count(node.left)
            count += self._node_count(node.right)
        return count

    def add_value(self, value: Any) -> None:
        """
        Add new node to tree
        :param value:  Value
        :return:  None
        """
        self.tree = self._add_node(self.tree, value)

    def _add_node(self, node: BinaryTreeNode, value: Any) -> BinaryTreeNode:
        if None is node:
            return BinaryTreeNode(value)
        else:
            if node.value < value:
                node.right = self._add_node(node.right, value)
            elif node.value > value:
                node.left = self._add_node(node.left, value)
            node.height = 1 + max(self.get_height(node.left),
                                  self.get_height(node.right))
        return node

    def find_value(self, value: Any) -> BinaryTreeNode:
        """
        Find the subtree matching the provided value
        :param value:  Value to match
        :return:  None or subtree
        """
        return self._find_in_node(self.tree, value)

    def _find_in_node(self, node: BinaryTreeNode, value) -> BinaryTreeNode:
        if node:
            if node.value == value:
                return node
            elif node.value > value:
                return self._find_in_node(node.left, value)
            elif node.value < value:
                return self._find_in_node(node.right, value)
        return node

    def print(self) -> None:
        """
        Print tree values
        :return:
        """
        result: str = self._print_tree(self.tree)
        print(result)

    def _print_tree(self, tree: BinaryTreeNode) -> str:
        """
        Print Node values
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

    def remove_value(self, value: Any) -> None:
        """
        Remove value from this tree
        :param value:  Value to remove
        :return:  None
        """
        self.tree = self._remove_node(self.tree, value)

    def _remove_node(self, tree: BinaryTreeNode, value: Any) -> BinaryTreeNode:
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
                tree.left = self._remove_node(tree.left, value)
            elif value > tree.value:
                tree.right = self._remove_node(tree.right, value)
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
                tree.right = self._remove_node(tree.right, the_min)
                tree.value = the_min
        return tree

    @classmethod
    def get_height(cls, node: BinaryTreeNode) -> int:
        """
        Find node height
        :param node:  Node to process
        :return: Hight of node
        """
        if not node:
            return 0

        return node.height
