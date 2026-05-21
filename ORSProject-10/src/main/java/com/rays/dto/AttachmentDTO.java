package com.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * AttachmentDTO is a Data Transfer Object (DTO) class
 * that represents attachment details such as file name,
 * type, description, and binary document data.
 * 
 * This class is mapped to the database table ST_ATTACHMENT.
 * 
 * It is used to store and retrieve file-related information.
 * 
 * @author Akbar Mansuri
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

    /** Name of the file */
    @Column(name = "NAME", length = 100)
    protected String name = null;

    /** MIME type of the file */
    @Column(name = "TYPE", length = 100)
    protected String type = null;

    /** Description of the file */
    @Column(name = "DESCRIPTION", length = 500)
    protected String description = null;

    /** ID of the user who uploaded the file */
    @Column(name = "USER_ID")
    protected Long userId = null;

    /** Binary content of the file */
    @Lob
    @Column(name = "DOC")
    private byte[] doc;

    /**
     * Default constructor
     */
    public AttachmentDTO() {

    }

    /**
     * Parameterized constructor to initialize AttachmentDTO using MultipartFile
     * 
     * @param file MultipartFile object containing file data
     */
    public AttachmentDTO(MultipartFile file) {
        name = file.getOriginalFilename();
        type = file.getContentType();

        try {
            doc = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets file name
     * @return file name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets file name
     * @param name file name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets file type
     * @return file type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets file type
     * @param type file type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * @param description file description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets user ID
     * @return user ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user ID
     * @param userId user ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets file content
     * @return byte array of file
     */
    public byte[] getDoc() {
        return doc;
    }

    /**
     * Sets file content
     * @param doc byte array of file
     */
    public void setDoc(byte[] doc) {
        this.doc = doc;
    }

    /**
     * Returns value (not implemented)
     */
    public String getValue() {
        return null;
    }

    /**
     * Returns unique key (not implemented)
     */
    @Override
    public String getUniqueKey() {
        return null;
    }

    /**
     * Returns unique value (not implemented)
     */
    @Override
    public String getUniqueValue() {
        return null;
    }

    /**
     * Returns label (not implemented)
     */
    @Override
    public String getLabel() {
        return null;
    }

    /**
     * Returns table name (not implemented)
     */
    @Override
    public String getTableName() {
        return null;
    }
}