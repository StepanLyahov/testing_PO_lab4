package com.stepan.todoistback.web.dto.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum StatusTask {
    IN_PROGRESS("В процессе"),
    READY("Готово"),
    EXPIRED("Просроченный");

    final String name;
}
