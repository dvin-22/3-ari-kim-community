package kr.adapterz.ari_community.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User updateUser(Integer user_id, String nickname, String profile_url) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() ->
                        new IllegalArgumentException("user not found"));
        user.setNickname(nickname);
        user.setProfile_url(profile_url);
        return user;
    }

    @Transactional
    public User updatePassword(Integer user_id, String password) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() ->
                        new IllegalArgumentException("user not found"));
        user.setPassword(password);
        return user;
    }

    @Transactional
    public void deleteUser(Integer user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() ->
                        new IllegalArgumentException("user not found"));
        userRepository.delete(user);
    }

}

