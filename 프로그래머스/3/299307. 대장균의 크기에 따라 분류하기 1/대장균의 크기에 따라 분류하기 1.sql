-- 코드를 작성해주세요
select id, 
    case 
        when SIZE_OF_COLONY <= 100 then 'LOW'
        when 100 < SIZE_OF_COLONY and SIZE_OF_COLONY <= 1000 then 'MEDIUM'
        when 1000 < SIZE_OF_COLONY then 'HIGH'
        end as 'SIZE'
from ECOLI_DATA
order by id;