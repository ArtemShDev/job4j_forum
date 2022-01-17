package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/edit")
    public String index(@RequestParam(value = "id", required = false) int id, Model model) {
        if (id != 0) {
            model.addAttribute("post", posts.getDyId(id));
        }
        return "edit";
    }

    @GetMapping("/post")
    public String post(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("post", posts.getDyId(id));
        return "post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        posts.save(post);
        return "redirect:/";
    }
}