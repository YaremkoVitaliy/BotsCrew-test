USE `university`;

INSERT INTO 
	lector (name, degree, salary)
VALUES
	("Ivan Petrenko", "assistant", 3650.01),
    ("Petro Ivanov", "assistant", 3333.33),
    ("Taras Shevchenko", "professor", 9999.99),
    ("Ivan Franko", "associate professor", 6740.00),
    ("Grygorii Skovoroda", "associate professor", 5810.25),
    ("Viktor Oleksiuk", "associate professor", 6177.89),
    ("Ostap Vyshnia", "associate professor", 5113.42),
    ("Mykhailo Grushevskyi", "professor", 10570.17),
    ("Pavlo Tychyna", "associate professor", 7255.67);

INSERT INTO 
	department (name, head) 
VALUES 
	("History", "Mykhailo Grushevskyi"),
    ("Math", "Grygorii Skovoroda"),
    ("Literature", "Taras Shevchenko"),
    ("Computer Science", "Viktor Oleksiuk");

INSERT INTO 
	department_lector (department_id, lector_id)
VALUES
	(1, 1),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 7),
    (1, 8),
    (2, 2),
    (2, 5),
    (2, 6),
    (2, 7),
    (3, 3),
    (3, 4),
    (3, 5),
    (3, 7),
    (3, 8),
    (3, 9),
    (4, 1),
    (4, 2),
    (4, 6);