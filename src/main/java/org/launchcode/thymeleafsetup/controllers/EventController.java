package org.launchcode.thymeleafsetup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
//        List<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        events.add("SpringOne Platform");
//        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create") //lives at /events/create
    public String renderCreateEventForm() {
        return "events/create"; // no file extension here needed, but template in events subfolder
    }

    @PostMapping("create") // can match one above because one is get one is post
    public String createEvent(@RequestParam String eventName) { // grabs data from input text box from form
        events.add(eventName);
        return "redirect:"; // goes to homepage "event" to see list of events after they've added one
    }

}
