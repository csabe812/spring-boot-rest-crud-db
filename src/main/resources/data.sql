DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  salary INT NOT NULL
);

INSERT INTO employees (name, salary) VALUES
  ('Jhonny', 10000),
  ('Jane', 20000),
  ('Philip', 30000);