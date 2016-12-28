package com.rti.bugtracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by gschuell on 12/27/16.
 */
@Entity
@Table(name = "DC_DEVELOPER_NAMES", schema = "BUGSADMIN", catalog = "")
public class DCDeveloperNamesEntity {

    @Id
    @Column(name = "NAME", nullable = false, length=40)
    private String name;

    @Column(name = "EMAIL_ADDRESS", nullable = false, length=80)
    private String emailAddress;

    @Column(name = "WINDOWS_LOGIN", nullable = true, length=20)
    private String windowsLogin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWindowsLogin() {
        return windowsLogin;
    }

    public void setWindowsLogin(String windowsLogin) {
        this.windowsLogin = windowsLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DCDeveloperNamesEntity that = (DCDeveloperNamesEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        return windowsLogin != null ? windowsLogin.equals(that.windowsLogin) : that.windowsLogin == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (windowsLogin != null ? windowsLogin.hashCode() : 0);
        return result;
    }
}
