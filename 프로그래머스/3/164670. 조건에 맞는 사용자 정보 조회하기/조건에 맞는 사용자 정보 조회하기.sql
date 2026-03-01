-- 코드를 입력하세요
-- 중고 거래 게시물을 3건 이상 등록한
SELECT user_id, nickname, CONCAT(city, ' ', street_address1, ' ', street_address2)  as '전체주소', CONCAT(
    SUBSTRING(TLNO, 1, 3), '-',
    SUBSTRING(TLNO, 4, 4), '-',
    SUBSTRING(TLNO, 8, 4)
)  as '전화번호'
from USED_GOODS_USER
where user_id in (
    select WRITER_ID
    from USED_GOODS_BOARD
    group by WRITER_ID
    having count(*) >= 3
)
order by user_id DESC;