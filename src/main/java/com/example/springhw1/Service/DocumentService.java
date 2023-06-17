package com.example.springhw1.Service;

import com.example.springhw1.Dao.DocumentDao;
import com.example.springhw1.Entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    DocumentDao documentDao;

    public Document CreateDocument(Document document) {
        try {
            Document newDocument = documentDao.CreateDocument(document);
            return newDocument;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Already Existed"
            );
        }
    }

    public Document GetDocument(Integer id) {
        try {
            Document document = documentDao.GetDocument(id);
            return document;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not existed"
            );
        }
    }

    public List<Document> ListDocuments() {
        return documentDao.ListDocuments();
    }

    public Document UpdateDocument(Integer id, String content) {
        try {
            Document document = documentDao.UpdateDocument(id, content);
            return document;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not existed"
            );
        }
    }

    public void DeleteDocument(Integer id) {
        try {
            documentDao.DeleteDocument(id);
            return;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not existed"
            );
        }
    }
}
