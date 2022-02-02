-- 아이디와 이름, 들어온 날짜를 조회
-- Y -> y 로 변경시 2018 -> 18로 출력

SELECT 
    ANIMAL_ID,
    NAME, 
    DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
