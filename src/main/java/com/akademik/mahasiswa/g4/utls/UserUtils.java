package com.akademik.mahasiswa.g4.utls;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.function.Predicate;

public class UserUtils {

    public static final String ROLE_MAHASISWA = "ROLE_MAHASISWA";
    public static final String ROLE_SEKRETARIAT = "ROLE_SEKRETARIAT";

    /**
     * Get currently username of user login
     * @return username
     */
    public static String getUsername(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public static boolean userRoleIs(String role){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().stream().anyMatch((Predicate<GrantedAuthority>) grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }

}
