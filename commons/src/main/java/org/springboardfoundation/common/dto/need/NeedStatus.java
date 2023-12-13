package org.springboardfoundation.common.dto.need;

import lombok.Getter;

@Getter
public enum NeedStatus {
    draft("draft"),
    created("created"),
    published("published"),
    closed("closed");

    private final String status;

    NeedStatus(String status) {
        this.status = status;
    }
}