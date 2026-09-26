-- 코드를 작성해주세요
select distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from DEVELOPERS d join SKILLCODES s ON (d.SKILL_CODE & s.CODE) != 0
WHERE s.CATEGORY = 'Front End'
order by id;
