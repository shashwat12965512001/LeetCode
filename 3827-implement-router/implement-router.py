class Router(object):

    def __init__(self, memoryLimit):
        """
        :type memoryLimit: int
        """
        self.memoryLimit = memoryLimit
        self.queue = deque()  # stores packets in FIFO order
        self.packetSet = set()  # for duplicate detection
        self.destMap = defaultdict(list)  # destination -> sorted timestamps list

    def addPacket(self, source, destination, timestamp):
        """
        :type source: int
        :type destination: int
        :type timestamp: int
        :rtype: bool
        """
        key = (source, destination, timestamp)
        if key in self.packetSet:  # duplicate
            return False

        # If memory full, evict oldest packet
        if len(self.queue) >= self.memoryLimit:
            old_src, old_dst, old_time = self.queue.popleft()
            self.packetSet.remove((old_src, old_dst, old_time))
            # remove old_time from destMap[old_dst]
            idx = bisect.bisect_left(self.destMap[old_dst], old_time)
            if idx < len(self.destMap[old_dst]) and self.destMap[old_dst][idx] == old_time:
                self.destMap[old_dst].pop(idx)

        # Add new packet
        self.queue.append((source, destination, timestamp))
        self.packetSet.add(key)
        bisect.insort(self.destMap[destination], timestamp)
        return True

    def forwardPacket(self):
        """
        :rtype: List[int]
        """
        if not self.queue:
            return []
        src, dst, time = self.queue.popleft()
        self.packetSet.remove((src, dst, time))
        # remove time from destMap[dst]
        idx = bisect.bisect_left(self.destMap[dst], time)
        if idx < len(self.destMap[dst]) and self.destMap[dst][idx] == time:
            self.destMap[dst].pop(idx)
        return [src, dst, time]

    def getCount(self, destination, startTime, endTime):
        """
        :type destination: int
        :type startTime: int
        :type endTime: int
        :rtype: int
        """
        times = self.destMap[destination]
        left = bisect.bisect_left(times, startTime)
        right = bisect.bisect_right(times, endTime)
        return right - left


# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)