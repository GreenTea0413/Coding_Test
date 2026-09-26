-- 코드를 작성해주세요
select ID
from ECOLI_DATA
where parent_id in (
    select id
    from ECOLI_DATA
    where parent_id in (
        select id 
        from ECOLI_DATA
        where parent_id is null
    )
)
order by ID;