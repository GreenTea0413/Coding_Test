-- 코드를 작성해주세요
select 
    case
        when month(DIFFERENTIATION_DATE) >= 10 && month(DIFFERENTIATION_DATE) < 13 then '4Q'
        when month(DIFFERENTIATION_DATE) >= 07 && month(DIFFERENTIATION_DATE) < 10 then '3Q'
        when month(DIFFERENTIATION_DATE) >= 04 && month(DIFFERENTIATION_DATE) < 07 then '2Q'
        when month(DIFFERENTIATION_DATE) < 04 then '1Q'
    end as QUARTER, 
    count(*) as ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
order by QUARTER;