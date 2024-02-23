import random

for round in range(100):
    m = 0
    n = 0
    reslist = []
    for i in range(10000):
        #print(i)
        res = random.randint(1,6)
        #print(res)
        if(res == 6):
            m+=1
            #print("caugh1")
        reslist.append(res)

    i = 9999
    for i in range(1000):
        #print(i)
        choose = random.randint(0,i)
        #print(choose)
        if(reslist[choose] == 4):
            n+=1 
            #print("caugh2")
        reslist.pop(choose)
        i-=1


    print("m = ", m)
    print("m/10000 = ", m/10000)
    print("n = ", n)
    print("n/1000 = ", n/1000)

