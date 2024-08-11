from asyncio import gather, run, sleep

async def func1():
    await sleep(6)
    print("Function 1")

async def func2():
    await sleep(3)
    print("Function 2")
    
async def func3():
    await sleep(1)
    print("Function 3")

async def executor():
    # await func1()
    # await func2()
    # await func3()
    future = await gather(
        func1(),
        func2(),
        func3())
    print(future)

run(executor())