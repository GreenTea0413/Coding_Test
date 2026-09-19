-- 코드를 작성해주세요
select count(*) as FISH_COUNT, Max(LENGTH) as MAX_LENGTH, FISH_TYPE
from FISH_INFO
group by FISH_TYPE
having avg(
    case 
        when LENGTH <= 10 or LENGTH is null then 10
        else LENGTH
    end
) >= 33
order by FISH_TYPE;