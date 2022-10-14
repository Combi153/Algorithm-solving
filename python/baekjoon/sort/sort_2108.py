import sys

n = int(sys.stdin.readline())
countDict = dict()
check = 0
minNumber = int(sys.stdin.readline())
maxNumber = minNumber
countDict[minNumber] = 1
summation = minNumber

for i in range(1, n):
    intNumber = int(sys.stdin.readline())
    summation += intNumber

    if (intNumber in countDict):
        value = countDict[intNumber] + 1
        countDict[intNumber] = value

        if (intNumber < minNumber):
            minNumber = intNumber
        
        if (intNumber > maxNumber):
            maxNumber = intNumber

    else:
        countDict[intNumber] = 1

        if (intNumber < minNumber):
            minNumber = intNumber
        
        if (intNumber > maxNumber):
            maxNumber = intNumber


countDict = sorted(countDict.items())
for key, value in countDict:
    check += value
    if (check >= n // 2 + 1):
        median = key
        break

countDict = sorted(countDict, key = lambda item : (-item[1], item[0]))
if (len(countDict) == 1):
    modeKey = countDict[0][0]
else:
    if (countDict[0][1] == countDict[1][1]):
        modeKey = countDict[1][0]
    else:
        modeKey = countDict[0][0]


print(round(summation / n))
print(median)
print(modeKey)
print(maxNumber - minNumber)