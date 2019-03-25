insert into person(id, person_type, name, age, nationaly) values(1, 'author', 'julio', 29, 'Brasileiro')
insert into book_publisher(id, name, cnpj) values(1, 'teste ae', '123345')

insert into book(id, title, description, author_id, bookpublisher_id) values(1, 'teste', 'agoraa vai', 1, 1)

insert into person(id, person_type, name, age) values(2, 'employee', 'zezinho', 25)
insert into person(id, person_type, name, age) values(3, 'user', 'juquinha', 21)

insert into address(id, name, district, number, user_id) values(1, 'Rua x', 'Centro', 27, 3)
insert into address(id, name, district, number, employee_id) values(2, 'Rua x', 'Centro', 27, 2)