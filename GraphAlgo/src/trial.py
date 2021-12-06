def read_input():
    n = int(input())
    graph = {}
    for i in range(n):
        line = input().split(' ')
        graph[line[0]] = [[line[j], int(line[j + 1])] for j in range(2, (2*int(line[1])) + 2, 2)]
    op = int(input())
    
    return graph, op

class queue:
    arr = []
    
    def enq(self, ele):
        self.arr.append(ele)
    
    def deq(self):
        x = self.arr[0]
        del self.arr[0]
        return x
    
    def printQ():
        print(self.arr)

def bfs(graph):
    bfsQ = queue()
    seen = list()
    root = 'A'
    seen.append(root)
    
    bfsQ.enq(graph[root])
    levels = {root:0}
    for i in bfsQ.arr[-1]:
        levels[i[0]] = levels[root] + 1
    
    while bfsQ.arr:
        curV = bfsQ.deq()
        
        for j in curV:
            if j[0] not in seen:
                seen.append(j[0])
                bfsQ.enq(graph[j[0]])     
                
                for i in bfsQ.arr[-1]:
                    if i[0] not in levels.keys():
                        levels[i[0]] = levels[j[0]] + 1                     
        
    return levels

def mst(graph):
    included = list()
    keyVals = [['A', 0]]
    for i in graph.keys() :
        if i != 'A':
            keyVals.append([i, float('inf')])
    
    while len(included) < len(graph):
        minNum = float('inf')
        minNode = 'None'
        
        for i in keyVals:
            if i[1] < minNum and i[0] not in included:
                minNum = i[1]
                minNode = i[0]
                
        included.append(minNode)

        adjacents = graph[minNode]
        for i in adjacents:
            if i[0] not in included:
                for j in keyVals:
                    if j[0] not in included:
                        if j[0] == i[0]:
                            j[1] = i[1]
                            
    print(included)
    return keyVals, included
    
          
graph, op = read_input()
bfsLevels = bfs(graph)
keyVals, included = mst(graph)

def solution(op):
    if op == 1:
        levels = list(bfsLevels.values())
        print(max(levels), end = ' ')
        temp = []
        for i in levels:
            if i > 0 and i not in temp:
                print(levels.count(i), end = ' ')
                temp.append(i)
                
    if op == 2:
        ans = []
        for i in bfsLevels.keys():
            if bfsLevels[i] == max(bfsLevels.values()):
                ans.append(i)
        ans.sort()
        print(' '.join(ans))
        
    
    if op == 3:
        tsum = 0
        tnum = 0
        for i in graph.values():
            for j in i:
                tsum += j[1]
                tnum += 1
        
        tnum = int((tnum / 2) + 1)
        tsum = int(tsum / 2)
        
        usum = 0
        unum = 0
        for i in keyVals:
            usum += i[1]
            unum += 1
        
        print(tnum - unum, end = ' ')
        print(tsum - usum, end = ' ')
        
    if op == 4:
        costs = []
        for i in graph.keys():
            if i != 'A':
                c = 0
                
                costs.append(c)
                
            
        
        
        
    
        
solution(op)