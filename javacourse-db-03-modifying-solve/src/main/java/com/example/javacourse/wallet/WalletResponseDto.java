package com.example.javacourse.wallet;

import com.example.javacourse.profile.Profile;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class WalletResponseDto {

    private String walletName;
    private Boolean active;

    private Profile profile;

    public WalletResponseDto(String walletName, Boolean active, Profile profile) {
        this.walletName = walletName;
        this.active = active;
        this.profile = profile;
    }

    public String getWalletName() {
        return walletName;
    }

    public Boolean getActive() {
        return active;
    }

    public Profile getProfile() {
        return profile;
    }
}
