-- 데이터 베이스에 없는 0 ~ 23의 조건이 포함되어 있음
-- 0 ~ 23의 테이블을 먼저 생성해야함 -> 이후 COUNT 테이블 생성
-- := 은 대입의 의미
-- @HOUR가 HOUR(DATETIME)과 동일할 때 COUNT

SET @HOUR := -1;
SELECT 
    (@HOUR := @HOUR + 1) AS HOUR,
    (SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23
