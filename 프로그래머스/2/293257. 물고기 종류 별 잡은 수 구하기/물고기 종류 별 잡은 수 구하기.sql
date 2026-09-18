-- 코드를 작성해주세요
select count(f.fish_type) as FISH_COUNT, n.FISH_NAME
from FISH_INFO f join FISH_NAME_INFO n on f.FISH_TYPE = n.FISH_TYPE
group by f.fish_type
order by FISH_COUNT desc;