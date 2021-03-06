-- 보호소에 들어올 당시에는 중성화 되지 않았지만,
-- 보호소를 나갈 당시(입양이 되었을 때)에는 중성화된 동물의 아이디와 생물 종, 이름을 조회
-- 아이디 순으로 조회

SELECT OUTS.ANIMAL_ID, OUTS.ANIMAL_TYPE, OUTS.NAME
FROM ANIMAL_OUTS AS OUTS
     LEFT JOIN
     ANIMAL_INS AS INS
     ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE OUTS.SEX_UPON_OUTCOME != INS.SEX_UPON_INTAKE
ORDER BY OUTS.ANIMAL_ID
