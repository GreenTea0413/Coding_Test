-- 코드를 작성해주세요
-- DEVELOPERS 테이블에 포함된 개발자 중 Python 스킬이나 C# 스킬
-- 무슨 말도안되는
select ID,	EMAIL,	FIRST_NAME,	LAST_NAME
from DEVELOPERS
where SKILL_CODE & (Select SUM(CODE)
                    from SKILLCODES
                    where NAME in ('Python', 'C#')
                   ) != 0
order by id;