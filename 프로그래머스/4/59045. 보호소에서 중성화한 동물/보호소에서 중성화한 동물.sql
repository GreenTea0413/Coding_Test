-- 코드를 입력하세요
-- 중성화 수술을 거친 동물 정보
-- 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된
SELECT i.animal_id, i.animal_type, i.name
from ANIMAL_INS i join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where i.SEX_UPON_INTAKE Like "Intact%" and (o.SEX_UPON_OUTCOME Like "Neutered%" or o.SEX_UPON_OUTCOME Like "Spayed%")
order by i.animal_id;