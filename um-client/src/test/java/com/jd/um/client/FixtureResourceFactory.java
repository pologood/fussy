package com.jd.um.client;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import com.jd.um.persistence.model.Principal;
import com.jd.um.persistence.model.Privilege;
import com.jd.um.persistence.model.Role;
import com.jd.um.web.dto.UserDto;

import com.google.common.collect.Sets;

public class FixtureResourceFactory {

    private FixtureResourceFactory() {
        throw new AssertionError();
    }

    // user DTO

    public static UserDto createNewUser() {
        return createNewUser(randomAlphabetic(8), randomAlphabetic(8), randomAlphabetic(8), randomAlphabetic(8), false, true, randomAlphabetic(8));
    }

    public static UserDto createNewUser(final String firstname, final String lastname, final String email, final String pass, final Boolean enabled, final Boolean tokenExpired, final String cardCode) {
        return new UserDto(firstname, lastname, email, pass, Sets.<Role> newHashSet(), enabled, tokenExpired, cardCode);
    }
    // principal

    public static Principal createNewPrincipal() {
        return createNewPrincipal(randomAlphabetic(8), randomAlphabetic(8));
    }

    public static Principal createNewPrincipal(final String email, final String pass) {
        return new Principal(email, pass, Sets.<Role> newHashSet());
    }

    // role

    public static Role createNewRole() {
        return createNewRole(randomAlphabetic(8));
    }

    public static Role createNewRole(final String name) {
        return new Role(name, Sets.<Privilege> newHashSet());
    }

    // privilege

    public static Privilege createNewPrivilege() {
        return createNewPrivilege(randomAlphabetic(8));
    }

    public static Privilege createNewPrivilege(final String name) {
        return new Privilege(name);
    }

}
