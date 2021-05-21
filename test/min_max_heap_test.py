from unittest import TestCase

from min_max_heap import MinMaxHeap


class MinMaxHeapTest(TestCase):
    def testAddMax(self):
        the_range: int = 10
        subject = MinMaxHeap(True)
        for index in range(0, the_range):
            subject.add(index)
        last = the_range
        for index in range(0, subject.size()):
            the_val = subject.poll()
            self.assertGreater(last, the_val,
                               f'Failed poll at index {index} with old value {last} and pull value {the_val}')
            last = the_val

    def testAddLess(self):
        the_range: int = 10
        subject = MinMaxHeap(False)
        for index in range(0, the_range):
            subject.add(index)
        last = -1
        for index in range(0, subject.size()):
            the_val = subject.poll()
            self.assertLess(last, the_val,
                            f'Failed poll at index {index} with old value {last} and pull value {the_val}')
            last = the_val
