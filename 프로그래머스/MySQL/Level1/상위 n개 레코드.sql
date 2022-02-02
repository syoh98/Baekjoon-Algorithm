-- 가장 먼저 들어온 동물의 이름을 조회
-- limit2, 5: 위를 기준으로 2부터 5까지의 정보 추출
-- limit5: 위에서 5개의 정보 추출

SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;
