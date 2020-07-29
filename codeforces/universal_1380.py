t=int(input())
for _ in range(t):
    # n=int(input())
    a=input()
    d={'R':0,'S':0,'P':0}
    for i in a:
        d[i]+=1 
    if ((d['R']>=d['S'] and d['S']>=d['P']) or d['R']>=d['P'] and d['P']>=d['S']):
        d['R']=len(a)
        while(d['R']>0):
            print("P",end='')
            d['R']-=1
    elif ((d['P']>=d['R'] and d['R']>=d['S']) or d['P']>=d['S'] and d['S']>=d['R']):
        d['P']=len(a)
        while(d['P']>0):
            print("S",end='')
            d['P']-=1
    elif ((d['S']>=d['R'] and d['R']>=d['P']) or d['S']>=d['P'] and d['P']>=d['R']):
        d['S']=len(a)
        while(d['S']>0):
            print("R",end='')
            d['S']-=1
    print()