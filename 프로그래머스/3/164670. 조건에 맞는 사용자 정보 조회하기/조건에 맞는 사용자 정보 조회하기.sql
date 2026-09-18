-- 코드를 입력하세요
SELECT b.WRITER_ID as USER_ID, u.NICKNAME,	
concat(u.CITY,' ',u.STREET_ADDRESS1,' ',u.STREET_ADDRESS2) as 전체주소, 
concat(substring(u.TLNO,1,3),'-',substring(u.TLNO, 4,4),'-',substring(u.TLNO, 8,4)) as 전화번호
from USED_GOODS_BOARD b join USED_GOODS_USER u on b.writer_id = u.user_id
group by b.WRITER_ID
having count(*) >= 3
order by b.WRITER_ID desc;