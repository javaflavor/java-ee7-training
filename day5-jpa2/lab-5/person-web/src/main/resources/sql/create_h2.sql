create table if not exists Person (id integer generated by default as identity, firstName varchar(20) not null, lastName varchar(20) not null, age integer not null, primary key (id))
create table if not exists TraceRecord (id integer generated by default as identity, date timestamp, message varchar(255), primary key (id))
