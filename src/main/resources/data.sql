insert into user values(90001, sysdate(), 'User1', 'test1', '121212-1212111');
insert into user values(90002, sysdate(), 'User2', 'test1', '121212-1212112');
insert into user values(90003, sysdate(), 'User3', 'test1', '121212-1212113');

insert into post values(10001, 'My first post', 90001);
insert into post values(10002, 'My second post', 90001);