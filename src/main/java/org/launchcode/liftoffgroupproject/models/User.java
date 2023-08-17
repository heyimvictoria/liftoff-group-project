package org.launchcode.liftoffgroupproject.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotBlank
    private String firstName;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private String profilePicture;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private boolean darkTheme;

    public User() {}

    public User(String username, String password, String firstName, String profilePicture) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.firstName = firstName;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public boolean isDarkTheme() {
        return darkTheme;
    }

    public void setDarkTheme(boolean darkTheme) {
        this.darkTheme = darkTheme;
    }

    public String getFirstName() { return firstName; }

    public String getProfilePicture() { return profilePicture;
    }

    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture;
    }
}
