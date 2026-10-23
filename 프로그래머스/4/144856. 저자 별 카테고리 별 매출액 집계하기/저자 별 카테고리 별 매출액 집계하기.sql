-- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(s.SALES * b.PRICE) as TOTAL_SALES
FROM BOOK b 
join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID 
join BOOK_SALES s on b.BOOK_ID = s.BOOK_ID
where date_format(s.SALES_DATE, '%Y-%m') = '2022-01'
Group by a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc;
