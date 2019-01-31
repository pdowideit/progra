main = putStrLn("Aufgabe6")

fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-2) + fib (n-1)

pow :: Int -> Int -> Int
pow a 0 = 1
pow a b = a * pow a (b-1)

isDiv :: Int -> Int -> Bool
isDiv 0 b = True
isDiv a 1 = True
isDiv a b = (divRest a b == 0)

divRest :: Int -> Int -> Int
divRest a b | a > b = divRest (a-b) b
            | a < b = a
            | a == b = 0 

sumUp :: [Int] -> Int
sumUp (xs:x) = xs + sumUp x
sumUp [] = 0

multLists :: [Int] -> [Int] -> [Int]
multLists [] ys = []
multLists xs [] = []
multLists (x:xs) (y:ys) = [x*y] ++ multLists xs ys

binRep :: Int -> (Int,[Int])
binRep a = (getSign a , bin (a*getSign a))

bin :: Int -> [Int]
bin 0 = [0]
bin n = reverse (binHelper n)

binHelper :: Int -> [Int]
binHelper 0 = []
binHelper n | divRest n 2 == 1 = 1 : binHelper (n `div` 2)
         | divRest n 2 == 0 = 0 : binHelper (n `div` 2)

getSign :: Int -> Int
getSign a | a>0 = 1
          | a<0 = -1
          | a==0 = 0