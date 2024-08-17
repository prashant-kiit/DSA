def getSeries(n):
    # series = []
    for i in range(10):
        print("element ", i)
        yield i
        # series.append(i)
    # return series

series = getSeries(10)
print(series)
print(next(series))
print(next(series))
print(next(series))
print(next(series))
print(next(series))
print(next(series))

