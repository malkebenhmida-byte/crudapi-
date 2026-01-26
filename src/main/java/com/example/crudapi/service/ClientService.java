
package com.example.crudapi.service;

import com.example.crudapi.entity.Client;
import com.example.crudapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@Service
public class ClientService 
{
    
    @Autowired
    private ClientRepository clientRep;

    // ajouter client 
    public ResponseEntity<?> createClient(Client client) 
    {
        if (clientRep.existsById(client.getIdentifiant())) {
            return ResponseEntity.badRequest().body("ce client existe déjà");
        }
        
        Client saved = clientRep.save(client);
        return ResponseEntity.ok(saved);  
    }

    // lire tout les client (pour affichage )
    public List<Client> getAllClients() {
        return clientRep.findAll();
    }

    // lire un client 
    public ResponseEntity<?> getClientById(String id) 
    {
        Optional<Client> client = clientRep.findById(id);
         if (client.isEmpty())
         {
            return ResponseEntity.status(404).body("Client avec ID " + id + " introuvable");
        }
        return  ResponseEntity.ok(client.get());
    }

    // modifier un client 
    public  ResponseEntity<?> updateClient(String id, Client clientDetails)
    {
        
        Optional<Client> clientOp = clientRep.findById(id);

        if (clientOp.isEmpty()) {
            return ResponseEntity.status(404).body("Impossible de modifier ce client : ID introuvable");
        }

          Client clientExiste = clientOp.get();
          
           if (clientDetails.getNom() != null)
            clientExiste.setNom(clientDetails.getNom());

        if (clientDetails.getPrenom() != null)
            clientExiste.setPrenom(clientDetails.getPrenom());

        if (clientDetails.getDate_naiss() != null)
           clientExiste.setDate_naiss(clientDetails.getDate_naiss());

        if (clientDetails.getGenre() != null)
            clientExiste.setGenre(clientDetails.getGenre());

        if (clientDetails.getAdresse() != null)
            clientExiste.setAdresse(clientDetails.getAdresse());

        if (clientDetails.getNum_tel() != null)
            clientExiste.setNum_tel(clientDetails.getNum_tel());

        if (clientDetails.getAdresse_mail() != null)
            clientExiste.setAdresse_mail(clientDetails.getAdresse_mail());

        Client clientModif = clientRep.save(clientExiste);
        return ResponseEntity.ok(clientModif);
          
    }

    // effacer un client
    public ResponseEntity<?> deleteClient(String id) {
        if (!clientRep.existsById(id)) {
            return ResponseEntity.status(404).body("Ce client n'existe pas ");
            
        }
        clientRep.deleteById(id);
        return ResponseEntity.ok("Client supprimé avec succès");
    }
    
    
}
