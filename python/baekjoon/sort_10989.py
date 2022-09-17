import sys
n = int(sys.stdin.readline())
count = [0] * 10001 # 문제 최대값
maxNum = 0

for i in range(0, n):
    num = int(sys.stdin.readline())
    count[num] += 1

    #maxNum 구하기
    if num > maxNum:
        maxNum = num

count = count[:maxNum+1]

for j in range(len(count)):
    for k in range(count[j]):
        print(j)