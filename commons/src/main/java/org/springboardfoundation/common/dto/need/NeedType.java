package org.springboardfoundation.common.dto.need;

import lombok.Getter;

@Getter
public enum NeedType {
    financial("financial"),
    general("general"),
    info("info");

    private final String type;

    NeedType(String type) {
        this.type = type;
    }
}