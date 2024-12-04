package ru.alex.service;

public class HttpLoggerConfig {
    private final boolean enabled;
    private final String level;

    public HttpLoggerConfig(boolean enabled, String level) {
        this.enabled = enabled;
        this.level = level;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getLevel() {
        return level;
    }
}
