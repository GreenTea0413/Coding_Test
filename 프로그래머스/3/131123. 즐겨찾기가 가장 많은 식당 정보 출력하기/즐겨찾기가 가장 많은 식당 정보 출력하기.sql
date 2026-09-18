-- 코드를 입력하세요
SELECT i.FOOD_TYPE, i.REST_ID, i.REST_NAME, i.FAVORITES
from REST_INFO i join (
    select FOOD_TYPE, REST_ID, max(FAVORITES) as total
    from REST_INFO
    group by FOOD_TYPE
) m on i.FOOD_TYPE = m.FOOD_TYPE and i.FAVORITES = m.total
order by FOOD_TYPE desc;