-- 코드를 입력하세요
-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회

SELECT concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) as file_path
from USED_GOODS_FILE
where board_id = (
    select board_id
    from USED_GOODS_BOARD
    order by views DESC
    limit 1
)
order by file_id desc;