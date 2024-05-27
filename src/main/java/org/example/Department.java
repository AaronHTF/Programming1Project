package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentName = null;
        }
    }

    /**
     * checks if a department name is valid. The name can only contain letters and spaces
     * @param departmentName the input department name
     * @return true if the department name is valid and false if not
     */
    public boolean validateDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!validCharacters.contains(c + "")) {
                return false;
            }
        }

        return true;
    }
}
