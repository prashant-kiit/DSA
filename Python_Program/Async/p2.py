from threading import Thread
from time import sleep

def func1(name):
    sleep(6)
    print("Function 1 " + name)

def func2(name):
    sleep(3)
    print("Function 2 " + name)
    
def func3(name):
    sleep(1)
    print("Function 3 " + name)

t1 = Thread(target=func1, args=["Ram"])
t2 = Thread(target=func2, args=["Shyam"])
t3 = Thread(target=func3, args=["Lakshman"])

t1.start()
t2.start()
t3.start()