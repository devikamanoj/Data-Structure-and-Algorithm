n = int(input().strip())
adjacencyMat = []

for i in range(n+1):
    r = [0]*(n+1)
    adjacencyMat.append(r)

for _ in range(n):
    line = input().strip().split(" ")
    line = [int(i) for i in line]
    vertNum = line[0]
    j = 2

    while(j < (len(line))):
        adjacencyMat[vertNum][line[j]] = line[j+1]
        adjacencyMat[line[j]][vertNum] = line[j+1]
        j += 2

choice = int(input().strip())

if choice == 1:
    d = 0

    curr_line = input().strip().split(" ")
    curr_line = [int(i) for i in curr_line]
    for j in range(1, curr_line[0]+1):
        for k in range(1, n+1):
            if adjacencyMat[k][curr_line[j]] != 0:
                d += 1
        print(d, end=" ")
        d = 0
elif choice == 2:
    curr_line = input().strip().split(" ")
    curr_line = [int(i) for i in curr_line]

    j = 1

    while j <= len(curr_line)-1:
        print(adjacencyMat[curr_line[j]][curr_line[j+1]], end=" ")
        j += 2

elif choice == 3:
    num = 0
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i >= j:
                if adjacencyMat[i][j] != 0:
                    num += 1

    print(num, end=" ")

elif choice == 4:
    sum = 0
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i >= j:
                if adjacencyMat[i][j] != 0:
                    sum += adjacencyMat[i][j]
    print(sum, end=" ")

elif choice == 5:
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i <= j:
                if adjacencyMat[i][j] != 0:
                    print(i, j, adjacencyMat[i][j], sep=" ", end="\n")
