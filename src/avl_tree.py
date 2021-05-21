from typing import Any

from binary_tree import BinaryTree, BinaryTreeNode


class AvlTree(BinaryTree):

    def __init__(self, value):
        super(AvlTree, self).__init__(value)
        self.height = 1

    def _left_rotate(self, node: BinaryTreeNode) -> BinaryTreeNode:
        """
        Rotate node left
        :param node: Node to roate
        :return: Updated node
        """
        y: BinaryTreeNode = node.right
        t2: BinaryTreeNode = y.left

        # Perform rotation
        y.left = node
        node.right = t2

        # Update heights
        node.height = 1 + max(self.get_height(node.left),
                              self.get_height(node.right))
        y.height = 1 + max(self.get_height(y.left),
                           self.get_height(y.right))

        # Return the new root
        return y

    def _right_rotate(self, node: BinaryTreeNode) -> BinaryTreeNode:
        """
        Rotate Right
        :param node:  Node to rotate
        :return: Updated Node
        """
        y: BinaryTreeNode = node.left
        t3: BinaryTreeNode = y.right

        # Perform rotation
        y.right = node
        node.left = t3

        # Update heights
        node.height = 1 + max(self.get_height(node.left),
                              self.get_height(node.right))
        y.height = 1 + max(self.get_height(y.left),
                           self.get_height(y.right))

        # Return the new root
        return y

    def _get_balance(self, node: BinaryTreeNode) -> int:
        """
        Get the balance at the node
        :param node:  Node to check
        :return: Balance
        """
        if not node:
            return 0

        return self.get_height(node.left) - self.get_height(node.right)

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

                if tree is None:
                    return tree

                    # Step 2 - Update the height of the
                    # ancestor node
                tree.height = 1 + max(self.get_height(tree.left),
                              self.get_height(tree.right))

                # Step 3 - Get the balance factor
                balance = self._get_balance(tree)

                # Step 4 - If the node is unbalanced,
                # then try out the 4 cases
                # Case 1 - Left Left
                if balance > 1 and self._get_balance(tree.left) >= 0:
                    return self._right_rotate(tree)

                # Case 2 - Right Right
                if balance < -1 and self._get_balance(tree.right) <= 0:
                    return self._left_rotate(tree)

                # Case 3 - Left Right
                if balance > 1 and self.getBalance(tree.left) < 0:
                    tree.left = self._left_rotate(tree.left)
                    return self._right_rotate(tree)

                # Case 4 - Right Left
                if balance < -1 and self._get_balance(tree.right) > 0:
                    tree.right = self._right_rotate(tree.right)
                    return self._left_rotate(tree)
        return tree

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

            # Step 3 - Get the balance factor
            balance = self._get_balance(node)

            # Step 4 - If the node is unbalanced,
            # then try out the 4 cases
            # Case 1 - Left Left
            if balance > 1 and value < node.left.value:
                return self._right_rotate(node)

            # Case 2 - Right Right
            if balance < -1 and value > node.right.value:
                return self._left_rotate(node)

            # Case 3 - Left Right
            if balance > 1 and value > node.left.value:
                node.left = self._left_rotate(node.left)
                return self._right_rotate(node)

            # Case 4 - Right Left
            if balance < -1 and value < node.right.value:
                node.right = self._right_rotate(node.right)
                return self._left_rotate(node)

        return node
