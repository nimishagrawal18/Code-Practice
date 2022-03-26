
import time


starttime = time.perf_counter()

str = "aaaaa"
str=str*3
print (str)
print (time.perf_counter()-starttime)


