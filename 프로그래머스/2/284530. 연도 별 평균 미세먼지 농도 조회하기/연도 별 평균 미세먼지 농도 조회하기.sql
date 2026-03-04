-- 코드를 작성해주세요
select year(ym)as YEAR, round(avg(PM_VAL1),2) as PM10, round(avg(PM_VAL2),2) as 'PM2.5'
from AIR_POLLUTION
where LOCATION2 = '수원'
group by year(ym)
order by year(ym);