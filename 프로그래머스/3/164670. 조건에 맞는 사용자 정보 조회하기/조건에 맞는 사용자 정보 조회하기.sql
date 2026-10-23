-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, concat(u.city, ' ', u.STREET_ADDRESS1, ' ', u.STREET_ADDRESS2) as 전체주소,
concat(substring(TLNO, 1, 3), '-', substring(TLNO, 4, 4), '-' ,substring(TLNO, 8,4)) as 전화번호
from USED_GOODS_USER u 
join USED_GOODS_BOARD b on u.USER_ID = b.WRITER_ID
group by u.USER_ID, u.NICKNAME
having count(*) >= 3
order by u.USER_ID desc;