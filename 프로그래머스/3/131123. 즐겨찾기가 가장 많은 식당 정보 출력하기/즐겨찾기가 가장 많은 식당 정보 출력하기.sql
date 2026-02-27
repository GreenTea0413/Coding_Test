-- 코드를 입력하세요
-- 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info r1
where favorites = (
    select max(favorites)
    from rest_info r2
    group by food_type
    having r1.food_type = r2.food_type
)
order by food_type desc;