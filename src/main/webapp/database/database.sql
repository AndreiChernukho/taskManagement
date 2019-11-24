DROP DATABASE IF EXISTS task_management;

CREATE DATABASE  task_management;

CREATE TABLE project (
 id          CHAR(36)      NOT NULL,
 name        VARCHAR(255)  NOT NULL,
 description VARCHAR(1000) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE task (
  id          CHAR(36)     NOT NULL,
  status      CHAR(50)     NOT NULL,
  name        VARCHAR(255) NOT NULL,
  project_id  CHAR(36)     NOT NULL,
  employee_id CHAR(36)     NULL,
  PRIMARY KEY (id)
);

CREATE TABLE employee (
  id         CHAR(36)     NOT NULL,
  surname    VARCHAR(255) NOT NULL,
  name       VARCHAR(255) NOT NULL,
  patronymic VARCHAR(255) NOT NULL,
  position   VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
 );

ALTER TABLE task ADD CONSTRAINT task_project FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE task ADD CONSTRAINT task_employee FOREIGN KEY (employee_id) REFERENCES employee (id);
