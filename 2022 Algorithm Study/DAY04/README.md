정수론</br>
=============

## 📋1. 유클리드 호제법
![zoqcj1](https://user-images.githubusercontent.com/76934280/150474672-b0afff4a-be90-4507-850b-0b63f8a9f713.PNG)

### a % b = r 면, gcd(a, b) = gcd(b, r) 이다
&nbsp;gcd(a, b) = gcd(b, a % b) (단, a >= b)</br>
&nbsp;&nbsp;&nbsp;&nbsp; gcd(36, 24)</br>
&nbsp;&nbsp;&nbsp; = gcd(24, 12)</br>
&nbsp;&nbsp;&nbsp; = gcd(12,0)</br>

1. 부정 방정식
해가 무수히 많은 방정식
2. 디오판토스 방정식
해가 정수인 경우의 부정 방정식(3x + 2y = 5)
3. 베주 항등식
ax + by = gcd(x, y)의 해가 되는 정수 x, y 짝을 찾아낼 수 있음 => 이걸 베주의 항등식이라함

## 📋2. 확장 유클리드 호제법
### ax + by = a , ax + by = b의 방정식을 만족시키는 정수의 해 s와 반드시 존재한다
![스크린샷(314)](https://user-images.githubusercontent.com/76934280/150480099-65c607c6-06c4-4400-90d0-2c47ba7428dd.png)
