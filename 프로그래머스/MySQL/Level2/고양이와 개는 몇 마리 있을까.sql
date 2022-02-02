-- 고양이와 개가 각각 몇 마리인지 조회(단, 고양이를 개보다 먼저 조회)

SELECT ANIMAL_TYPE, count(ANIMAL_TYPE) as count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE
