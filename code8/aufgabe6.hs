import System.Environment

main :: IO()
main = print(len [1..7])

firstListEntry (x:xs) = x

len :: [Int] -> Int
len [] = 0
len (x:xs) = 1 + len xs

fib 0 = 0
fib 1 = 1
fib n = fib (n-2) + fib (n-1)




fac 0 = 0
fac 1 = 1
fac n = n * fac (n-1)