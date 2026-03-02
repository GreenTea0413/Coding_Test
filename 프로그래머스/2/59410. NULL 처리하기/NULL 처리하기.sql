-- 코드를 입력하세요
SELECT animal_type, 
    case 
        when name is null then 'No name'
        else name
    end name
, sex_upon_intake
from ANIMAL_INS;
