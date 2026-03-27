select count(*) as FISH_COUNT
from FISH_NAME_INFO n join FISH_INFO i on n.FISH_TYPE = i.FISH_TYPE
where n.fish_name in ('BASS', 'SNAPPER');