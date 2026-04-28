package br.com.studio.beautymanager.controller;

import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {

    protected Long getStudioId() {
        return (Long) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
