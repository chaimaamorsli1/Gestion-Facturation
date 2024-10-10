package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.Repositories.NotificationRepository;
import com.example.gestionFacturation.entities.Facture;
import com.example.gestionFacturation.entities.Notification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getNotificationistory() {
        return notificationRepository.findAll();
    }

    public void addNotification(Notification n) {
        notificationRepository.save(n);
    }

    public void deleteNotificaion(long id) {
        notificationRepository.deleteById(id);
    }

    public void updateNotification(Notification n, long id) {
       Notification notif = notificationRepository.findById(id).orElseThrow(()->new EntityNotFoundException("not found"));
       notif.setMessage(n.getMessage());
       notif.setDate(n.getDate());
       notif.setSender(n.getSender());
       notif.setReceiver(n.getReceiver());
       notificationRepository.save(notif);
    }
}
