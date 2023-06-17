package com.example.springhw1.Controller;

import com.example.springhw1.Entity.Document;
import com.example.springhw1.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    DocumentService service;

    @RequestMapping(value = "/documents", method = RequestMethod.POST, consumes = "application/json")
    public Document CreateDocument(@RequestBody Document document) {
        return service.CreateDocument(document);
    }

    @GetMapping("/document/{id}")
    public Document GetDocument(@PathVariable Integer id) {
        return service.GetDocument(id);
    }

    @GetMapping("/documents")
    public List<Document> ListDocuments() {
        return service.ListDocuments();
    }

    @PostMapping("/document/{id}")
    public Document UpdateDocument(@PathVariable Integer id, @RequestBody Document document) {
        return service.UpdateDocument(id, document.getContent());
    }

    @DeleteMapping("/document/{id}")
    public void DeleteDocument(@PathVariable Integer id) {
        service.DeleteDocument(id);
    }
}
