package br.com.studio.beautymanager.controller;

import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {

    protected Long getStudioId() {
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return (Long) principal;
    }
}