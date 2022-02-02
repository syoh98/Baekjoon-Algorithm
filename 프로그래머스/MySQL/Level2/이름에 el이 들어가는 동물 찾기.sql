-- 이름 중 'el'이 들어가는 개의 아이디와 이름을 조회(단, 대소문자 구분 안함)

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog' AND NAME LIKE '%EL%'
ORDER BY NAME;
