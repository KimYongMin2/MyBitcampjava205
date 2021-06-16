create table phoneInfo_basic ( idx NUMBER(6),
                              fr_name VARCHAR2(20) NOT NULL,
                              fr_phonenumber VARCHAR2(20) NOT NULL,
                              fr_email VARCHAR2(20),
                              fr_address VARCHAR2(20),
                              fr_regdate DATE DEFAULT SYSDATE,
                         
                              constraint phoneInfo_basic_idx_PK PRIMARY KEY(idx)
                         
                              );
                  
create table phoneInfo_univ ( idx NUMBER(6),
                              fr_u_major VARCHAR2(20)DEFAULT 'N' NOT NULL , 
                              fr_u_year NUMBER(1) DEFAULT 1 CHECK (fr_u_year between 0 and 5) NOT NULL,
                              fr_ref NUMBER(6) NOT NULL,
                              
                              constraint phoneInfo_univ_idx_PK PRIMARY KEY(idx),
                              constraint phoneInfo_univ_fr_ref_FK FOREIGN KEY (fr_ref)REFERENCES phoneInfo_basic(idx)
                              
                              );
                              
create table phoneInfo_com (  idx NUMBER(6),
                              fr_c_company VARCHAR2(20) DEFAULT 'N' NOT NULL, 
                              fr_ref NUMBER(6) NOT NULL,
                              
                              constraint phoneInfo_com_idx_PK PRIMARY KEY(idx),
                              constraint phoneInfo_com_fr_ref_FK FOREIGN KEY (fr_ref) REFERENCES phoneInfo_basic(idx)
                             
                              );                        
                              