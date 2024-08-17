from concurrent.futures import ThreadPoolExecutor
from time import sleep

def func(time):
    sleep(time)
    print(f"Function {time} ", time)
    return time
    
with ThreadPoolExecutor(max_workers=3) as executor:
    l = [3,2,1]
    results = executor.map(func, l)
    for result in results:
        print(result)
