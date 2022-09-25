import sys

examinee, winner = map(int, sys.stdin.readline().split())
scores = list(map(int, sys.stdin.readline().split()))

# 병합 정렬
def merge_sort(a):
    n = len(a)

    if n <= 1:
        return a

    mid = n // 2
    group1 = a[:mid]
    group2 = a[mid:]
    merge_sort(group1)
    merge_sort(group2)

    i1, i2, ia = 0, 0, 0

    while (i1 < len(group1) and i2 < len(group2)):
        if (group1[i1] > group2[i2]):
            a[ia] = group1[i1]
            i1 += 1
            ia += 1

        else:
            a[ia] = group2[i2]
            i2 += 1
            ia += 1
    
    while i1 < len(group1):
        a[ia] = group1[i1]
        i1 += 1
        ia += 1

    while i2 < len(group2):
        a[ia] = group2[i2]
        i2 += 1
        ia += 1

merge_sort(scores)
print(scores[winner - 1])