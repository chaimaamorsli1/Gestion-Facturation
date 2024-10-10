package com.example.gestionFacturation.Controllers;

import com.example.gestionFacturation.Services.NotificationService;
import com.example.gestionFacturation.entities.Notification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "notification")
public class NotificationController {
    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @GetMapping
    public List<Notification> getNotificationHistory(){
        return notificationService.getNotificationistory();
    }
    @PostMapping
    public void addNotification(Notification n){
        notificationService.addNotification(n);
    }
    @DeleteMapping
    public void deleteNotification(@RequestParam long id){
        notificationService.deleteNotificaion(id);
    }
    @PutMapping
    public void updateNotification(@RequestBody Notification n , @RequestParam long id){
        notificationService.updateNotification(n,id);
    }
}
