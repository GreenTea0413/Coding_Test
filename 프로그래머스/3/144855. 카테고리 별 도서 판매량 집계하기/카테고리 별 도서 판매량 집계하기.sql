-- 코드를 입력하세요
SELECT b.CATEGORY, sum(s.sales) as TOTAL_SALES
from BOOK b
join BOOK_SALES s on b.book_id = s.book_id
where s.SALES_DATE LIKE '2022-01%' 
group by b.category 
order by b.category ASC;
