package com.Gemoire.Gemoire.controllers;

import com.Gemoire.Gemoire.dao.MemoireDao;
import com.Gemoire.Gemoire.entity.Memoire;
import com.Gemoire.Gemoire.services.impl.MemoireResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest/home")
public class HomeController {

    @Autowired
    private MemoireDao memoireDao;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ROOT') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/root")
    @PreAuthorize("hasRole('ROOT')")
    public String moderatorAccess() {
        return "ROOT Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/memoire/lists")
    public ResponseEntity<List<Memoire>> findAllMemoires() {
        return ResponseEntity.ok(memoireDao.findAll());
    }
}
