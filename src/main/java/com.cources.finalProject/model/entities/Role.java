package com.cources.finalProject.model.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains all possible user roles
 */
public enum Role {
    UNKNOWN(0), CUSTOMER(1), MASTER(2), MANAGER(3), ADMIN(4);

    private int value;
    private static Map<Integer, Role> map = new HashMap<>();

    static {
        for (Role r : Role.values()) {
            map.put(r.value, r);
        }
    }

    Role(int value) {
        this.value = value;
    }

    public static Role valueOf(int value) {
        return map.get(value);
    }
}
