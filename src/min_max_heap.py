import heapq


class MinMaxHeap:
    def __init__(self, is_max=True):
        self.is_max = is_max
        self.data = []

    def peek(self):
        if self.is_max:
            return -self.data[0]
        else:
            return self.data[0]

    def add(self, val):
        if self.is_max:
            heapq.heappush(self.data, -val)
        else:
            heapq.heappush(self.data, val)

    def poll(self):
        if self.is_max:
            return -heapq.heappop(self.data)
        else:
            return heapq.heappop(self.data)

    def to_list(self):
        if(self.is_max):
            return list(map(lambda item: -item, self.data))
        else:
            return list(map(lambda item: item, self.data))

    def size(self):
        return len(self.data)
