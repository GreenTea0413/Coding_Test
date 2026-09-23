-- 코드를 입력하세요
SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, round(avg(r.REVIEW_SCORE), 2) as SCORE
from REST_INFO i join REST_REVIEW r on i.REST_ID = r.REST_ID
where i.ADDRESS Like '서울%'
group by i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS
order by SCORE desc, i.FAVORITES desc;