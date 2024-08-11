from functools import lru_cache
from time import sleep

@lru_cache
def square(n):
    sleep(5)
    return n*n

print(square(10))
print(square(10))

# .pyi
# .py
# Stubs
# Datatypes - Static Typing
# Ellipsis - Implementation Placeholder 

# Decorator Design 
# Access the original function
# Access the decorated function
# Think is terms of Java implementation of Decorated Design Pattern