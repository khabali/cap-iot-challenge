drop table message if exists;
create table message (
  id varchar(100) primary key,
  SensorType integer not null,
  creationDate timestamp not null,
  value integer not null
);