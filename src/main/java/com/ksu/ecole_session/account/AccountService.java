package com.ksu.ecole_session.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class AccountService implements UserDetailsService {

    private final AccountRepopsitory accountRepopsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepopsitory.findByemail(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return account;
    }
}
