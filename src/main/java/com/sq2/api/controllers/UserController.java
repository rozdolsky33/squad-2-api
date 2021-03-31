package com.sq2.api.controllers;

import com.sq2.api.requests.UpdateUserListModel;
import com.sq2.api.requests.UserRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?>getUserById(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World this is squad2");
    }

    @PostMapping
    public ResponseEntity<UserRequestModel> createUser(@RequestBody UserRequestModel user){
        return null;
    }

    @PutMapping("/{name}")
    public ResponseEntity<UpdateUserListModel> updateGroceryListByName(@RequestParam String name, @RequestBody UpdateUserListModel list){
        return null;
    }
}
