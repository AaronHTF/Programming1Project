package org.example;

import lombok.NonNull;

public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        this.departmentId = String.format("D%02d", nextId++);
        this.departmentName = departmentName;
    }

    public boolean validateDepartmentName(String departmentName) {
        return true;
        //TODO complete this method body
    }
}
