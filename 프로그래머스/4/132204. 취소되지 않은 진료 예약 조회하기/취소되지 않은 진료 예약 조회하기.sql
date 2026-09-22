-- 코드를 입력하세요
SELECT a.APNT_NO, p.PT_NAME, p.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD
from (Appointment a join patient p on a.PT_NO = p.PT_NO) 
    join doctor d on a.MDDR_ID = d.DR_ID
where date_format(a.APNT_YMD, "%Y-%m-%d") = '2022-04-13' and a.MCDP_CD = 'CS' and a.APNT_CNCL_YN = 'N'
order by a.APNT_YMD;

