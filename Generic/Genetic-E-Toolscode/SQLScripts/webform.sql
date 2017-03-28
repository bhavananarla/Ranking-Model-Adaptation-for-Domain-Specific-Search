create table listmaster (listno number(4) primary key,listname varchar2(15));
/
create table listdetails(listno number(4) references listmaster(listno) on delete cascade, line_id number(5), email varchar2(20), name varchar2(20));
/
create table form (formid number(4) primary key, formname varchar2(20),no_of_fields number(4));
/
create table formdetails(formid number(4) references form(formid) on delete cascade, lineid number(4),field varchar2(20),field_length number(4));

/
create table message (messageid number(4), content varchar2(200),status number(2),listname varchar2(20));
/     
