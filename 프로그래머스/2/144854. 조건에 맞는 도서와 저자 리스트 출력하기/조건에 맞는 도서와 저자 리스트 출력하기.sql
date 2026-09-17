-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, b.PUBLISHED_DATE
from Book b join Author a on b.AUTHOR_ID = a.AUTHOR_ID
where b.category = '경제'
order by b.PUBLISHED_DATE;
