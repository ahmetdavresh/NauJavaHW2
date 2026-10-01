package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee() {
    }

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{fullName='%s', age=%d, department='%s', salary=%.2f}",
                fullName, age, department, salary);
    }
}

public class StreamApiTask {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(20);
        employees.add(new Employee("Иванов Иван Иванович", 35, "IT", 150000.0));
        employees.add(new Employee("Петров Пётр Петрович", 28, "HR", 80000.0));
        employees.add(new Employee("Сидорова Анна Сергеевна", 42, "IT", 200000.0));
        employees.add(new Employee("Кузнецов Дмитрий Алексеевич", 31, "Finance", 120000.0));
        employees.add(new Employee("Смирнова Екатерина Дмитриевна", 26, "IT", 95000.0));
        employees.add(new Employee("Попов Сергей Андреевич", 45, "Marketing", 110000.0));
        employees.add(new Employee("Волкова Ольга Игоревна", 33, "HR", 85000.0));
        employees.add(new Employee("Новиков Алексей Павлович", 29, "Finance", 100000.0));
        employees.add(new Employee("Морозов Павел Викторович", 38, "Marketing", 130000.0));
        employees.add(new Employee("Фёдорова Мария Александровна", 24, "IT", 70000.0));
        employees.add(new Employee("Соколов Андрей Николаевич", 50, "Finance", 180000.0));
        employees.add(new Employee("Лебедева Татьяна Юрьевна", 27, "HR", 78000.0));
        employees.add(new Employee("Козлов Виктор Михайлович", 36, "Marketing", 115000.0));
        employees.add(new Employee("Орлова Светлана Олеговна", 31, "IT", 145000.0));
        employees.add(new Employee("Зайцев Роман Сергеевич", 22, "Finance", 65000.0));
        employees.add(new Employee("Павлова Наталья Геннадьевна", 39, "HR", 92000.0));
        employees.add(new Employee("Громов Игорь Валерьевич", 44, "Marketing", 140000.0));
        employees.add(new Employee("Никитина Алёна Андреевна", 30, "IT", 135000.0));
        employees.add(new Employee("Семёнов Дмитрий Олегович", 41, "Finance", 160000.0));
        employees.add(new Employee("Егова Вера Степановна", 25, "Marketing", 72000.0));

        // Список уникальных департаментов
        List<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .toList();

        System.out.println("Все сотрудники:");
        employees.forEach(System.out::println);

        System.out.println("\nДоступные департаменты:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, departments.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВыберите номер департамента: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > departments.size()) {
            System.out.println("Неверный выбор.");
            scanner.close();
            return;
        }

        String targetDepartment = departments.get(choice - 1);
        System.out.println("\nВыбранный департамент: " + targetDepartment);

        double avgSalary = employees.stream()
                .filter(e -> e.getDepartment().equals(targetDepartment))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.printf("Средняя зарплата: %.2f%n", avgSalary);

        scanner.close();
    }
}