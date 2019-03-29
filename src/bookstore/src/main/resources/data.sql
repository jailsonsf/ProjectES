insert into person(id, person_type, name, age, nationaly) values(1, 'author', 'Davi', 29, 'Brasileiro')
insert into book_publisher(id, name, cnpj) values(1, 'Sarau', '123345')

insert into book(id, title, description, author_id, bookpublisher_id) values(1, 'teste', 'descrição generico 1', 1, 1)
insert into book(id, title, description, author_id, bookpublisher_id) values(2, 'teste 2', 'descrição generico 2', 1, 1)

insert into person(id, person_type, name, age) values(2, 'employee', 'Carlos', 25)
insert into person(id, person_type, name, age) values(3, 'user', 'Enzo', 21)