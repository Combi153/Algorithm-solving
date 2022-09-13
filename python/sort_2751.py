import sys

n = int(sys.stdin.readline())
numbers = []

for i in range(0, n):
  num = int(sys.stdin.readline())
  numbers.append(num)

def merge_sort(a):
  key = len(a)
  if key <= 1:
    return a

  mid = key // 2
  group1 = a[:mid]
  group2 = a[mid:]

  merge_sort(group1)
  merge_sort(group2)

  idx1, idx2, idxA = 0, 0, 0

  while (idx1 < len(group1)) & (idx2 < len(group2)):
    if group1[idx1] < group2[idx2]:
      a[idxA] = group1[idx1]
      idx1 += 1
      idxA += 1

    else:
      a[idxA] = group2[idx2]
      idx2 += 1
      idxA += 1

  while idx1 < len(group1):
    a[idxA] = group1[idx1]
    idx1 += 1
    idxA += 1

  while idx2 < len(group2):
    a[idxA] = group2[idx2]
    idx2 += 1
    idxA += 1

merge_sort(numbers)
print(*numbers ,sep = '\n')