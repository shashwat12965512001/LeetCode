import heapq

class TaskManager(object):

    def __init__(self, tasks):
        """
        :type tasks: List[List[int]]
        """
        self.taskMap = {}   # taskId -> (userId, priority)
        self.heap = []      # max-heap as (-priority, -taskId, taskId)

        for userId, taskId, priority in tasks:
            self.add(userId, taskId, priority)

    def add(self, userId, taskId, priority):
        """
        :type userId: int
        :type taskId: int
        :type priority: int
        :rtype: None
        """
        self.taskMap[taskId] = (userId, priority)
        heapq.heappush(self.heap, (-priority, -taskId, taskId))

    def edit(self, taskId, newPriority):
        """
        :type taskId: int
        :type newPriority: int
        :rtype: None
        """
        userId, _ = self.taskMap[taskId]
        self.taskMap[taskId] = (userId, newPriority)
        heapq.heappush(self.heap, (-newPriority, -taskId, taskId))

    def rmv(self, taskId):
        """
        :type taskId: int
        :rtype: None
        """
        if taskId in self.taskMap:
            del self.taskMap[taskId]

    def execTop(self):
        """
        :rtype: int
        """
        while self.heap:
            priority, negTaskId, taskId = heapq.heappop(self.heap)
            if taskId not in self.taskMap:  # task was removed
                continue
            userId, currPriority = self.taskMap[taskId]
            if currPriority == -priority:   # valid current task
                del self.taskMap[taskId]   # execute & remove
                return userId
        return -1
