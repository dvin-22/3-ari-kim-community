package kr.adapterz.ari_community.user;

import kr.adapterz.ari_community.user.dto.request.UpdatePasswordRequest;
import kr.adapterz.ari_community.user.dto.request.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PatchMapping("/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer user_id, @RequestBody UpdateUserRequest updateUserRequest) {
        User updatedUser = userService.updateUser(user_id, updateUserRequest.getNickname(), updateUserRequest.getProfile_url());
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{user_id}")
    public ResponseEntity<?> updatePassword(@PathVariable Integer user_id, @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        if (updatePasswordRequest.getPassword() == updatePasswordRequest.getPassword_check()) {
            User updatedPassword = userService.updatePassword(user_id, updatePasswordRequest.getPassword());
            return ResponseEntity.ok(updatedPassword);
        }
        else {
            return ResponseEntity.badRequest().body("비밀번호가 일치하지 않음");
        }
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer user_id) {
        userService.deleteUser(user_id);
        return ResponseEntity.ok("204 삭제 완료");
    }

}
