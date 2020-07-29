t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    prev=0
    curr=-1
    next=-1
    for i  in range(1,n):
        if curr==-1:
            if a[i]>a[prev]:
                curr=i 
            else:
                prev=i 
        else:
            if a[i]<a[curr]:
                next=i 
                break
            else:
                curr=i 
    if next==-1:
        print("NO")
    else:
        print("YES")
        print(prev+1,curr+1,next+1)
        