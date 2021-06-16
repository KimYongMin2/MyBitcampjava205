create table phoneInfo_basic(
    idx NUMBER(6),
    fr_name VARCHAR2(20) NOT NULL,
    fr_phonenumber VARCHAR2(20) NOT NULL,
    fr_email VARCHAR2(20),
    fr_address VARCHAR2(20),
    fr_regdate DATE DEFAULT SYSDATE,
                         
    constraint phoneInfo_basic_idx_PK PRIMARY KEY(idx)
    );