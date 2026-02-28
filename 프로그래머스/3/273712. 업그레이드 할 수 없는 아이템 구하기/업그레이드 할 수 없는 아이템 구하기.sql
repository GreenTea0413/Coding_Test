-- 코드를 작성해주세요
select f.item_id, f.item_name, f.rarity
from ITEM_INFO f
join ITEM_TREE t
    on f.item_id = t.item_id
where t.item_id not in (
    SELECT parent_item_id
    FROM ITEM_TREE
    WHERE parent_item_id IS NOT NULL
    )
order by item_id DESC;