CREATE TABLE expense (
    id NUMBER PRIMARY KEY,         -- 고유 번호
    title VARCHAR2(100) NOT NULL,  -- 항목명
    amount NUMBER NOT NULL,        -- 금액
    category VARCHAR2(50),         -- 카테고리
    expense_date DATE DEFAULT SYSDATE, -- 지출 날짜
    memo VARCHAR2(200)             -- 메모
);

CREATE SEQUENCE expense_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO expense (id, title, amount, category, expense_date, memo)
VALUES (expense_seq.NEXTVAL, '점심 식사', 8000, '식비', SYSDATE, '회사 근처 식당');

INSERT INTO expense (id, title, amount, category, expense_date, memo)
VALUES (expense_seq.NEXTVAL, '지하철 교통비', 1350, '교통', SYSDATE, '출근길');

INSERT INTO expense (id, title, amount, category, expense_date, memo)
VALUES (expense_seq.NEXTVAL, '커피', 4500, '간식', SYSDATE, '스타벅스 아메리카노');

COMMIT;


SELECT * FROM expense ORDER BY id DESC;

