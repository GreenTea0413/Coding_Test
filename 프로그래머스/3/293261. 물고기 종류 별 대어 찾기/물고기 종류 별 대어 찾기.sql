-- 코드를 작성해주세요
select f.id as id, n.fish_name as fish_name, f.length as length
from FISH_INFO f
left join FISH_NAME_INFO n on f.fish_type = n.fish_type
where f.length = (
    select max(length)
    from fish_info 
    where f.fish_type = fish_type
)
order by f.id;