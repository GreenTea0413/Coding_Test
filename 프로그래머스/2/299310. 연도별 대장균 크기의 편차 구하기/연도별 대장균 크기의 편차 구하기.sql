-- 코드를 작성해주세요
-- 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
select Year(DIFFERENTIATION_DATE) as YEAR, 
    MAX(SIZE_OF_COLONY) OVER(partition by Year(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY 
        as YEAR_DEV, 
    ID
from ECOLI_DATA
order by YEAR, YEAR_DEV;
