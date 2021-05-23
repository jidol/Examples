from linkedlist import LinkedList, SingleNode


def merge_sort(data: LinkedList) -> LinkedList:
    if None is not data:
        head: SingleNode = data.myHead
        return LinkedList(_merge(head))


def _merge(root) -> SingleNode:
    if not root or not root.next:
        return root

    right = middle(root)
    left = _merge(root)
    right = _merge(right)
    return LinkedList.merge(left, right)


def middle(root: SingleNode):
    answer = root
    prev = root
    movers = root
    count = 0
    while movers:
        if count & 1:
            prev = answer
            answer = answer.next
        count += 1
        movers = movers.next
    prev.next = None  # Break the two apart
    return answer

if __name__ == '__main__':
    count = 50
    startList:LinkedList = LinkedList()
    for index in range(0, 50):
        if index % 2 == 0:
            startList.add(index)

    for index in range(0, 50):
        if index % 2 != 0:
            startList.add(index)

    mover = startList.myHead
    while mover:
        print(f'{mover.value}')
        mover = mover.next

    print("Sorted")
    mover = merge_sort(startList).myHead
    while mover:
        print(f'{mover.value}')
        mover = mover.next



