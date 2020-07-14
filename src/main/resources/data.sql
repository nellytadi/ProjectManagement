-- INSERT EMPLOYEES			
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'John Warton', 'warton@gmail.com',30);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Mike Lanister', 'lanister@gmail.com',24);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Steve Reeves', 'Reeves@gmail.com',67);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Ronald Connor', 'connor@gmail.com',52);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Jim Salvator', 'Sal@gmail.com',18);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Peter Henley', 'henley@gmail.com', 23);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Richard Carson', 'carson@gmail.com', 28);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Honor Miles', 'miles@gmail.com',45);
insert into employee (employee_id, full_name, email, age) values (nextval('employee_seq'), 'Tony Roggers', 'roggers@gmail.com', 19);

-- INSERT PROJECTS			
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='John Warton' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='Jim Salvator' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='Honor Miles' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='Richard Carson' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='Tony Roggers' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='Richard Carson' AND p.name = 'Improve Intranet Security');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='Richard Carson' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.full_name ='Tony Roggers' AND p.name = 'Improve Intranet Security');															