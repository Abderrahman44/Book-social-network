package com.abderahman.booknetwork.email;

import lombok.Getter;

@Getter
public enum EmailTemplate {
    ACCOUNT_ACTIVATION("account_activation");
    private final String name;
    EmailTemplate(String name) {
        this.name = name;
    }
}
