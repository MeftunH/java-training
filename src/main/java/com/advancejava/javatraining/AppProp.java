package com.advancejava.javatraining;

import lombok.Data;

@Data
@PropFile("app.properties")
public class AppProp {
    String value();
}
