-- 입양을 간 동물 중, 보호기간이 가장 길었던 동물 두마리의 아이디와 이름을 조회
-- 보호 기간이 긴 순으로 조회

SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS A, ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY B.DATETIME - A.DATETIME DESC
LIMIT 2
