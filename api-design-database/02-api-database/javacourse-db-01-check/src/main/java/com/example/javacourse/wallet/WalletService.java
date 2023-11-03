package com.example.javacourse.wallet;

import com.example.javacourse.exception.BadRequestException;
import com.example.javacourse.exception.NotFoundException;
import com.example.javacourse.mail.MailService;
import com.example.javacourse.profile.Profile;
import com.example.javacourse.profile.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final MailService mailService;

    private final WalletRepository walletRepository;

    private final ProfileRepository profileRepository;

    public WalletService(MailService mailService, WalletRepository walletRepository, ProfileRepository profileRepository) {
        this.mailService = mailService;
        this.walletRepository = walletRepository;
        this.profileRepository = profileRepository;
    }

    public List<Wallet> getWalletList() {
        return walletRepository.findAll();
    }


    @Transactional
    public Wallet createWallet(WalletRequestDto requestDto) throws Exception {
        Optional<Profile> optionalProfile = profileRepository.findByEmail(requestDto.getEmail());
        Profile profile;
        if (optionalProfile.isPresent()) {
            profile = optionalProfile.get();
        } else {
            profile = new Profile();
            profile.setName("Someone");
            profile.setEmail(requestDto.getEmail());
            profileRepository.save(profile);
        }


        Wallet wallet = new Wallet();
        wallet.setWalletName(requestDto.getName());
        wallet.setActive(true);
        wallet.setProfile(profile);
        walletRepository.save(wallet);
        return wallet;
    }


    public Wallet getWalletById(Integer id) {
//        return walletList.stream()
//                .filter(wallet -> wallet.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new NotFoundException("Wallet " + id +" not found"));
        return null;
    }

    public Wallet editWalletById(Integer id, WalletRequestDto requestDto) {
        Optional<Wallet> optionalWallet = walletRepository.findById(Long.valueOf(id));
        if (optionalWallet.isEmpty()) {
            throw new BadRequestException("Invalid wallet id");
        }

        Wallet wallet = optionalWallet.get();
        wallet.setWalletName(requestDto.getName());
        walletRepository.save(wallet);

        return wallet;
    }

    public void deleteWalletById(Integer id) {
        walletRepository.deleteById(Long.valueOf(id));
//        activeAllWallet();
//        walletRepository.deleteWalletsByIdBelow3();
    }

//    public void activeAllWallet() {
//        walletRepository.setAllWaletAcitve();
//    }

}
