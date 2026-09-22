-- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(s.SALES * b.PRICE)as TOTAL_SALES
from (BOOK b join AUTHOR a on a.AUTHOR_ID = b.AUTHOR_ID)
    join BOOK_SALES s on s.BOOK_ID = b.BOOK_ID
where date_format(SALES_DATE, "%Y-%m") = '2022-01'
group by a.author_id, a.author_name, b.category
order by a.AUTHOR_ID, b.CATEGORY desc;