-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, concat(u.CITY ,' ', u.STREET_ADDRESS1, ' ', u.STREET_ADDRESS2) as '전체주소', concat(substring(u.TLNO, 1, 3),'-', substring(u.TLNO, 4, 4), '-', substring(u.TLNO, 8, 4)) as '전화번호'
FROM USED_GOODS_BOARD b join USED_GOODS_USER u on b.WRITER_ID = u.USER_ID
GROUP BY u.USER_ID, u.NICKNAME
HAVING count(*) >= 3
ORDER BY u.USER_ID desc;
