-- 컬럼에 Neutered, Spayed 들어가면 중성화 된 동물(중성화가 되어있으면 O, 안되어있으면 X 표시)

SELECT 
    ANIMAL_ID, 
    NAME,
    CASE
        WHEN SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%'
            THEN 'O'
        ELSE
            'X'
    END AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
