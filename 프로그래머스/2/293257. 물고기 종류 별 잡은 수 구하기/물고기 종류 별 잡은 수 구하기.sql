-- 코드를 작성해주세요
-- 물고기의 종류 별
select count(*) as fish_count, n.fish_name as fish_name
from FISH_INFO f
left join FISH_NAME_INFO n on f.FISH_TYPE = n.FISH_TYPE
group by n.FISH_NAME
order by fish_count desc;