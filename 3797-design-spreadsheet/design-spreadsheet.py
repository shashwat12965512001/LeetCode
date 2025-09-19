class Spreadsheet(object):

    def __init__(self, rows):
        """
        :type rows: int
        """
        self.rows = rows
        self.cells = {}  # key: (row, col), value: int
        

    def setCell(self, cell, value):
        """
        :type cell: str
        :type value: int
        :rtype: None
        """
        row, col = self._parseCell(cell)
        self.cells[(row, col)] = value
        

    def resetCell(self, cell):
        """
        :type cell: str
        :rtype: None
        """
        row, col = self._parseCell(cell)
        if (row, col) in self.cells:
            self.cells[(row, col)] = 0
        

    def getValue(self, formula):
        """
        :type formula: str
        :rtype: int
        """
        parts = formula[1:].split("+")
        left = self._getVal(parts[0])
        right = self._getVal(parts[1])
        return left + right

    def _getVal(self, token):
        # check if number
        if token.isdigit():
            return int(token)
        # else it's a cell reference
        row, col = self._parseCell(token)
        return self.cells.get((row, col), 0)
    
    def _parseCell(self, cell):
        # Example: A10 -> col = 'A', row = 10
        col = ord(cell[0]) - ord('A')
        row = int(cell[1:]) - 1  # convert to 0-based
        return (row, col)
