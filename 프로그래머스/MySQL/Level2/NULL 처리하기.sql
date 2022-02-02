-- ~을 아이디 순으로 조회(이름이 없는 동물의 이름은 No name으로 표시)

SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name'), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
