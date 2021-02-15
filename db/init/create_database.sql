create database if not exists statementdb character set utf8mb4;

create user 'statementdb_user'@'%' identified by 'xxxxxxxx';
grant all privileges ON statementdb.* to 'statementdb_user'@'%' with grant option;
grant select ON performance_schema.user_variables_by_thread to 'statementdb_user'@'%';
flush privileges;
