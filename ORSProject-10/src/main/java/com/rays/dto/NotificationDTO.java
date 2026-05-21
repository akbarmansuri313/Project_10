package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * NotificationDTO represents a notification entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information about notifications
 * such as title, message, sent date, and read status. It is mapped to the
 * "st_notification" table in the database.
 */
@Entity
@Table(name = "st_notification")
public class NotificationDTO extends BaseDTO {

    /** Unique identifier for the notification */
    @Column(name = "notificationId", length = 50)
    private Long notificationId;

    /** Title of the notification */
    @Column(name = "title", length = 50)
    private String title;

    /** Message content of the notification */
    @Column(name = "message", length = 50)
    private String message;

    /** Date when the notification was sent */
    @Column(name = "sentDate", length = 50)
    private Date sentDate;

    /** Flag indicating whether the notification has been read */
    @Column(name = "isRead", length = 30)
    private Boolean isRead;

    // Getters and setters

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * Returns the unique key field for this DTO.
     *
     * @return "title" as the unique key
     */
    @Override
    public String getUniqueKey() {
        return "title";
    }

    /**
     * Returns the unique value for this DTO based on the unique key.
     *
     * @return title of the notification
     */
    @Override
    public String getUniqueValue() {
        return "title";
    }

    /**
     * Returns a human-readable label for this DTO.
     *
     * @return title of the notification
     */
    @Override
    public String getLabel() {
        return title;
    }

    /**
     * Returns the database table name associated with this DTO.
     *
     * @return "Notification"
     */
    @Override
    public String getTableName() {
        return "Notification";
    }
}