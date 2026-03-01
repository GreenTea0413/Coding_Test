-- 코드를 작성해주세요
-- 33이상 물고기들 종류별로
-- 물고기 종류 오름차순
-- 10cm이하들은 10cm로 취급하여 평균길이
select count(*) as fish_count, max(length) as max_length, fish_type
from FISH_INFO
group by fish_type
having 
    avg (case 
            when length <= 10 then 10
            else length
        end) >= 33
order by fish_type;
