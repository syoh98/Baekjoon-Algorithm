Indexed Tree</br>
=============

## ๐1. TOP-DOWN : Init(left, right, node)
![์บก์ฒ1](https://user-images.githubusercontent.com/76934280/150173387-9700b7be-911c-403b-8257-e70cd79dd79f.PNG)

1. Root๋ถํฐ ์์ init(1, 8, 1)

2. ๋ด๋ถ๋ธ๋ ์ผ ๊ฒฝ์ฐ (left != right)
    - ์ผ์ชฝ์์ init(left, mid, node * 2) ๋ฅผ ํธ์ถ
    - ์ค๋ฅธ์ชฝ์์ init(mid + 1, right, node * 2 + 1) ๋ฅผ ํธ์ถ
    - ๋ธ๋์ ๊ฐ์ ๋ฆฌํด
3. ๋ฆฌํ๋ธํธ ์ผ ๊ฒฝ์ฐ(left == right)
    - ๋ธ๋์ ๋ฐฐ์ด์ ๊ฐ ์ ์ฅ
    - ๋ธ๋์ ๊ฐ์ ๋ฆฌํด

## ๐2. TOP-DOWN : Query(left, right, node, queryLeft, queryRight)
![์บก์ฒ2](https://user-images.githubusercontent.com/76934280/150173548-99d5ae89-00db-450d-a216-a23afe11ff7e.PNG)
1. Root๋ถํฐ ์์ query(1, 8, 1, 3, 7)
2. ๋ธ๋๊ฐ Query ๋ฒ์ ๋ฐ - ์ฐ๊ด์์
    - ๋ฌด์
3. ๋ธ๋๊ฐ Query ๋ฒ์ ์์ ๋ค์ด์ด - ํ๋จ๊ฐ๋ฅ
    - ํ์ฌ ๋ธ๋ ๊ฐ ๋ฆฌํด
4. ๋ธ๋๊ฐ Query ๋ฒ์์ ๊ฑธ์ณ์์ - ํ๋จ๋ถ๊ฐ
    - ์ผ์ชฝ query(I, mid, node * 2, 3, 7)์ ํธ์ถ
    - ์ค๋ฅธ์ชฝ query(mid + 1, r, node * 2 + 1, 3, 7)์ ํธ์ถ
    - ์ผ์ชฝ query + ์ค๋ฅธ์ชฝ query ๊ฐ์ ํฉ์ณ์ ๋ฆฌํด

## ๐3. QUERY
![์บก์ฒ3](https://user-images.githubusercontent.com/76934280/150176191-447bdf90-e7dc-4110-83aa-b23cbb48d0c6.PNG)

## ๐4. TOP-DOWN : Update(left, right, node, target, diff)
![์บก์ฒ4](https://user-images.githubusercontent.com/76934280/150178625-58c8cce0-75b2-4fd3-8dab-115a7ed613a9.PNG)
1. Root๋ถํฐ ์์ update(1, 8, 1, 3, -2)
2. ๋ธ๋๊ฐ Target ๋ฏธํฌํจ - ์ฐ๊ด ์์
3. ๋ชจ๋๊ฐ Target ํฌํจ
    - ํ์ฌ ๋ธ๋์ diff ๋ฐ์
    - ์์์ด ์์ ๊ฒฝ์ฐ ์ผ์ชฝ update(I, mod, node * 2, 3, -2)
    - ์ค๋ฅธ์ชฝ update(mid + 1, r, node * 2 + 1, 3, -2)

## ๐5. BOTTOM-UP(Init)
![์บก์ฒ5](https://user-images.githubusercontent.com/76934280/150179884-8b6fca02-0c02-456d-907c-e14db65fc3d5.PNG)
1. ๋ฆฌํ๋ธํธ ์ํ(index = [S] ~ [S + N -1]) -> ๊ทธ๋ฆผ ์์ผ๋ก 1๋ฒ ๊ณผ์ ์ด [S], 8๋ฒ ๊ณผ์ ์ด [S + N -1]์ ํด๋น
    - ๋ธ๋์ ๋ฐฐ์ด์ ๊ฐ ์ ์ฅ
2. ๋ด๋ถ๋ธ๋ ์ํ(index = [S - 1] ~ [1]) -> ๊ทธ๋ฆผ ์์ผ๋ก 9๋ฒ ๊ณผ์ ์ด [S - 1]์ ํด๋น
    - ์ผ์ชฝ ์์ index * 2
    - ์ค๋ฅธ์ชฝ ์์ index * 2  + 1
    - ์ผ์ชฝ ์์ + ์ค๋ฅธ์ชฝ ์์ ๊ฐ์ ํฉ์ณ์ ๋ธ๋์ ์ ์ฅ

## ๐6. BOTTOM-UP Query(queryLeft, queryRight)
![์บก์ฒ6](https://user-images.githubusercontent.com/76934280/150182313-41e5e7cb-dc9f-499b-9180-984abf64247d.PNG)
1. ๋ฆฌํ ๋ธ๋๋ถํฐ ์์ query[3, 7]
    - nodeLeft = S + queryLeft - 1
    - nodeRight = S + queryRight - 1
2. while(nodeLeft <= nodeRight)
3. leftNode ๋ถ๊ธฐ ์กฐ๊ฑด
    - ์ง์: ๋ถ๋ชจ๊ฐ ์ฌ์ฉ ๊ฐ๋ฅ -> leftNode = leftNode / 2   -> ๊ทธ๋ฆผ ์์ผ๋ก 1๋ฒ ๊ณผ์ ์ ํด๋น
    - ํ์: ํ์ฌ ๋ธ๋ ๊ฐ ์ถ๊ฐ -> leftNode = (leftNode + 1) / 2   -> ๊ทธ๋ฆผ ์์ผ๋ก 3๋ฒ ๊ณผ์ ์ ํด๋น
4. rightNode ๋ถ๊ธฐ ์กฐ๊ฑด
    - ์ง์: ํ์ฌ ๋ธ๋ ๊ฐ ์ถ๊ฐ -> rightNode = (rightNode - 1) / 2   -> ๊ทธ๋ฆผ ์์ผ๋ก 2๋ฒ ๊ณผ์ ์ ํด๋น 
    - ํ์: ๋ถ๋ชจ ๊ฐ ์ฌ์ฉ ๊ฐ๋ฅ -> rightNode = rightNode / 2   -> ๋ง์ฐฌ๊ฐ์ง๋ก, ๊ทธ๋ฆผ ์์ผ๋ก 2๋ฒ ๊ณผ์ ์ ํด๋น

## ๐7. BOTTOM-UP Update(target, value)
![7](https://user-images.githubusercontent.com/76934280/150184431-71f2c69f-d699-4164-804b-74ed213215a1.PNG)
1. ๋ฆฌํ๋ถํฐ ์์ Update(3, 2)
2. node = S + target - 1
3. ๋ธ๋๋ฅผ ใํด๋น ๊ฐ์ผ๋ก ๊ฐฑ์  -> ๊ทธ๋ฆผ ์์ผ๋ก 1๋ฒ ๊ณผ์ ์ ํด๋น
4. ๋ถ๋ชจ๋ก ์ด๋ node /= 2
5. while(node >= 1) -> ๊ทธ๋ฆผ ์์ผ๋ก 2๋ฒ ~ 4๋ฒ ๊ณผ์ ์ ํด๋น
    - ์ข์ธก(node * 2)์ ์ฐ์ธก(node * 2 + 1) ํฉ์ ๋ธ๋์ ์ ์ฅ
    - ๋ถ๋ชจ๋ก ์ด๋ node /= 2
