CREATE SCHEMA IF NOT EXISTS myburger;
CREATE USER 'myburger'@'%' IDENTIFIED BY 'Xpt@89=23asdW5';
GRANT ALL PRIVILEGES ON myburger.* TO 'myburger'@'%';