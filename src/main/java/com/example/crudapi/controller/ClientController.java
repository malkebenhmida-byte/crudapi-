
package com.example.crudapi.controller;

import com.example.crudapi.entity.Client;
import org.springframework.web.bind.annotation.*;

//import java.util.List;
import com.example.crudapi.repository.ClientRepository;
import com.example.crudapi.service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/clients")
public class ClientController 
{
     @Autowired
    private  ClientService clientServ;
     
     // ajout 
      @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        return clientServ.createClient(client);
    }
    
    //lire tout 
    @GetMapping
    public List<Client> getAllClients() {
        return clientServ.getAllClients();
    }
    
    //lire un 
    @GetMapping("/{identifiant}")
    public ResponseEntity<?> getClientByIdentifiant(
            @PathVariable String identifiant) {
        return clientServ.getClientById(identifiant);
    }
    
    //modifier 
    @PutMapping("/{identifiant}")
    public ResponseEntity<?> updateClient(
            @PathVariable String identifiant,
            @RequestBody Client clientDetails) {
        return clientServ.updateClient(identifiant, clientDetails);
    }
    
    //effacer 
     @DeleteMapping("/{identifiant}")
    public ResponseEntity<?> deleteClient(
            @PathVariable String identifiant) {
        return clientServ.deleteClient(identifiant);
    }
    
    
    
     
    // ajouter client avec erreur (sans service)
    /* @PostMapping
     public ResponseEntity<?> createClient(@RequestBody Client client) 
    {
        Optional<Client> existingClient = clientRep.findById(client.getIdentifiant());

        if (existingClient.isPresent()) 
        {
            return ResponseEntity.badRequest().body("Erreur : un client avec ce CIN existe déjà !");
        }

        Client savedClient = clientRep.save(client);
        return ResponseEntity.ok(savedClient);
    }  
     // lire client 
        @GetMapping("/{identifiant}")
        public ResponseEntity<?> getClientByIdentifiant(@PathVariable String identifiant)
        {
             Optional<Client> client = clientRep.findById(identifiant);
             if (client.isEmpty()) 
                { 
                    return ResponseEntity.status(404).body("Client avec le CIN " +identifiant+ " introuvable");
                }

        return ResponseEntity.ok(client.get());
        
        }


     // update 
        @PutMapping("/{identifiant}")
        public ResponseEntity<?> updateClient(@PathVariable String identifiant,
        @RequestBody Client clientDetails) 
        {
             Optional<Client> existingClient1 = clientRep.findById(identifiant);
             if (existingClient1.isEmpty()) 
             {
                return ResponseEntity.status(404).body("Client introuvable, mise à jour impossible");
             }
             
              Client existingClient = existingClient1.get();
              
              if (clientDetails.getNom() != null)
                existingClient.setNom(clientDetails.getNom());
              
              if (clientDetails.getPrenom() != null)
                existingClient.setPrenom(clientDetails.getPrenom());
              
              if (clientDetails.getDate_naiss() != null)
                existingClient.setDate_naiss(clientDetails.getDate_naiss());
              
              if (clientDetails.getGenre() != null)
                existingClient.setGenre(clientDetails.getGenre());
              
              if (clientDetails.getAdresse() != null)
                existingClient.setAdresse(clientDetails.getAdresse());
              
              if (clientDetails.getNum_tel() != null)
                existingClient.setNum_tel(clientDetails.getNum_tel());
              
              if (clientDetails.getAdresse_mail() != null)
                existingClient.setAdresse_mail(clientDetails.getAdresse_mail());
              
               Client updatedClient = clientRep.save(existingClient);
               return ResponseEntity.ok(updatedClient); 
        }
        
        //delete 
        @DeleteMapping("/{identifiant}")
        public void deleteClient(@PathVariable String identifiant) 
        {
            clientRep.deleteById(identifiant);
        }*/
          
}
