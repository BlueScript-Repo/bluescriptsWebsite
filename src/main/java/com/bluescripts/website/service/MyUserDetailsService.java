package com.bluescripts.website.service;

import com.bluescripts.website.entity.Login;
import com.bluescripts.website.model.UserDetailsImp;
import com.bluescripts.website.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private  final LoginRepository loginRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetailsImp loadUserByUsername(String userName) throws UsernameNotFoundException {

        Login login = loginRepository.findByUserName(userName).orElseThrow(
                () -> new UsernameNotFoundException("not found" + userName));

        return modelMapper.map(login,UserDetailsImp.class);
    }


}
