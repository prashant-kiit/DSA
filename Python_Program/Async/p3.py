from concurrent.futures import ThreadPoolExecutor
from time import sleep

def func1(name):
    sleep(6)
    print("Function 1 " + name)
    return 1

def func2(name):
    sleep(3)
    print("Function 2 " + name)
    return 2

def func3(name):
    sleep(1)
    print("Function 3 " + name)
    return 3
    
with ThreadPoolExecutor(max_workers=3) as executor:
    future1 = executor.submit(func1, "Ram")
    print(future1.result())
    future2 = executor.submit(func2, "Shyam")
    future3 = executor.submit(func3, "Lakshman")
    print(future2.result())
    print(future3.result())
