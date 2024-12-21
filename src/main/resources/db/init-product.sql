begin
   execute immediate 'DROP TABLE user';
exception
   when others then
      if sqlcode != -942 then -- Error code -942: "table or view does not exist"
         raise;
      end if;
end;
/

-- Create the sequence for auto-increment
create sequence user_seq
   start with 15 -- Set the start value to align with MySQL's AUTO_INCREMENT=15
   increment by 1
   nocache;

-- Create the table
create TABLE user (
   id NUMBER(11) NOT NULL,
   username VARCHAR2(50 CHAR),
   password VARCHAR2(50 CHAR),
   first_name VARCHAR2(50 CHAR),
   last_name VARCHAR2(50 CHAR),
   date_of_birth DATE,
   activity VARCHAR2(100 CHAR),
   gender VARCHAR2(50 CHAR),
   PRIMARY KEY (id)
);

-- Create a trigger for auto-increment functionality
create or replace trigger user_autoinc_trg
before insert on user
for each row
begin
   if :new.id is null then
      select user_seq.nextval into :NEW.id from DUAL;
   end if;
end;
/

insert all
   into user (id, username, password, first_name, last_name, date_of_birth, activity, gender)
       VALUES (1, 'admin', 'admin', 'admin', 'admin', TO_DATE('2000-01-03', 'YYYY-MM-DD'), 'gym', 'MALE')
   INTO user (id, username, password, first_name, last_name, date_of_birth, activity, gender)
       VALUES (2, 'admin1', 'admin1', 'admin1', 'admin1', TO_DATE('1985-08-23', 'YYYY-MM-DD'), 'sport', 'FEMALE')
select 1 from DUAL;
