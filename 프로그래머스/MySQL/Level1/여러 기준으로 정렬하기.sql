-- 아이디와 이름, 보호 시작일을 이름 순으로 조회(단, 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야함)

SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC;
