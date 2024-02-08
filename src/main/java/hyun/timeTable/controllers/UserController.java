package hyun.timeTable.controllers;

import hyun.timeTable.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    アカウントの作成
    @PostMapping("/user/{userName}")
    private ResponseEntity<String> createUser(@PathVariable String userName) {
        String result = userService.create(userName);
        if (result.equals("success")) {
            return ResponseEntity.ok(userName+"様、ご登録ありがとうございます。");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("既に同じ名前が存在します。");
        }
    }

    @DeleteMapping("/user/{userId}")
    private ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        String result = userService.delete(userId);
        if (result.equals("success")) {
            return ResponseEntity.ok("削除しました。");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("一致するアカウントがございません。");
        }
    }
}
