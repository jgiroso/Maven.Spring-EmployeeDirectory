

# Persistence Project: Employee Directory Application

In this project you will be creating an employee directory system. You will be able to modify and query the directory and the entries within.

## Description

You have been assigned to the HR Technology Implementation team and will be building a new corporate directory for your company. The first feature needed by this directory is an API that mobile and web apps can query to get the structure of the company's workforce. All employees in the company will be represented by the same object (Employee), but some of them are managers and some report to managers (you may even have middle managers who manage employees but also report to another departmentManager themselves).

The company is also organized into different divisions (Departments), each of which must have a department-wide departmentManager. All employees in that department should eventually report up to the department departmentManager, and assigning an employee a new departmentManager should also place that employee within their departmentManager's department.

## Entities

This application will manage the following entities:

### Employee Entity

* Employee number
* First name
* Last name
* Title
* Phone number
* Email
* Hire date
* Manager 
* Department number(key from Department.dpt_num)

### Department Entity

* Department number
* Department name
* Department Manager (an employee)

## API Endpoints

You should provide a series of API endpoints for interacting with the directory. All endpoints should have a URI that begins with `/API`. These endpoints will provide RESTful access to the application and changes will be persisted to the database.

Provide the following endpoints:

- Create employee (Via POST)
- Create a Department
- Update an employee to set their departmentManager
- Update other employee fields
- Set a new department departmentManager (Update department)
- Change the name of a department
- Get the list of employees under a particular departmentManager
- Get the entire reporting hierarchy for an employee (their departmentManager + departmentManager's departmentManager etc.)
- Get a list of employees with no assigned departmentManager
- Get all employees of a particular department
- Get all employees who report directly or indirectly to a particular departmentManager
  - This should still work for an employee who is not a departmentManager -- they have no direct reports
- Remove a particular employee or list of employees
- Remove all employees from a particular department
- Remove all employees under a particular departmentManager (Including indirect reports)
- Remove all direct reports to a departmentManager. Any employees previously managed by the deleted employees should now be managed by the next departmentManager up the hierarchy.
- Get the department, title, or other attributes of a particular employee.
- Merge departments (given two department names eg: A and B, move the departmentManager of B to report to the departmentManager of A, and update all other employees to be members of department A)
