-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 조회
-- ID 순으로 조회
-- LEFT OUTER JOIN: 왼쪽에 있는 데이터는 무조건 가져오지만, 오른쪽에 오는 테이블과 JOIN을 수행하여 조건에 맞는 데이터가 없을 시 NULL로 표시함
-- -> SELECT문 작성 시 왼쪽 테이블 기준으로 작성

SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM 
    ANIMAL_OUTS AS OUTS
    LEFT JOIN
    ANIMAL_INS AS INS
    ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.ANIMAL_ID IS NULL
