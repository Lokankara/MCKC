-- Drop the table if it exists
begin
   execute immediate 'DROP TABLE "sports"';
exception
   when others then
      if sqlcode != -942 then
         raise;
      end if;
end;
/

-- Create sequence for auto-incrementing the ID
create sequence user_seq
   start with 15
   increment by 1
   nocache;

-- Create table with correct column types
create TABLE "sports" (
   id NUMBER(11) NOT NULL,
   username VARCHAR2(50 CHAR),
   password VARCHAR2(50 CHAR),
   first_name VARCHAR2(50 CHAR),
   last_name VARCHAR2(50 CHAR),
   date_of_birth DATE,
   activity VARCHAR2(100 CHAR),
   gender VARCHAR2(50 CHAR),  -- Ensure this matches the enum type (VARCHAR)
   PRIMARY KEY (id)
);

create or replace trigger user_autoinc_trg
before insert on "sports"
for each row
begin
   if :new.id is null then
      select user_seq.nextval into :NEW.id from DUAL;
   end if;
end;
/

insert all
   into "sports" (id, username, password, first_name, last_name, date_of_birth, activity, gender)
       values (1, 'admin', 'admin', 'admin', 'admin', to_date('2000-01-03', 'YYYY-MM-DD'), 'gym', 'MALE')
   into "sports" (id, username, password, first_name, last_name, date_of_birth, activity, gender)
       values (2, 'admin1', 'admin1', 'admin1', 'admin1', to_date('1985-08-23', 'YYYY-MM-DD'), 'sport', 'FEMALE')
select 1 from DUAL;
