package com.project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.Exercici0.Manager;
import com.project.Exercici0.Ciutat;
import com.project.Exercici0.Ciutada;

public class CiutatCiutadaTest {
    
    private Manager manager0;
    private com.project.Exercici1.Manager manager1;

    @BeforeEach
    void setUp() {
        // Initialize both managers
        Manager.init();
        com.project.Exercici1.Manager.init();
    }

    @AfterEach
    void tearDown() {
        // Close both managers
        Manager.close();
        com.project.Exercici1.Manager.close();
    }

    @Test
    void testExercici0BasicCRUD() {
        // Test adding a ciutat
        Ciutat ciutat = Manager.addCiutat("Barcelona", "Spain", "08001");
        assertNotNull(ciutat);
        assertTrue(ciutat.getCiutatId() > 0);
        assertEquals("Barcelona", ciutat.getNom());
        
        // Test adding a ciutada
        Ciutada ciutada = Manager.addCiutada("John", "Doe", 30);
        assertNotNull(ciutada);
        assertTrue(ciutada.getCiutadaId() > 0);
        assertEquals("John", ciutada.getNom());
        
        // Test updating ciutat
        Set<Ciutada> ciutadans = new HashSet<>();
        ciutadans.add(ciutada);
        Manager.updateCiutat(ciutat.getCiutatId(), "New Barcelona", "Spain", ciutadans);
        
        // Verify update
        Collection<Ciutat> ciutats = Manager.listCollection(Ciutat.class, null);
        boolean found = ciutats.stream()
            .anyMatch(c -> c.getNom().equals("New Barcelona"));
        assertTrue(found);
        
        // Test delete
        Manager.delete(Ciutat.class, ciutat.getCiutatId());
        Manager.delete(Ciutada.class, ciutada.getCiutadaId());
        
        // Verify deletion
        ciutats = Manager.listCollection(Ciutat.class, null);
        found = ciutats.stream()
            .anyMatch(c -> c.getCiutatId() == ciutat.getCiutatId());
        assertFalse(found);
    }

    @Test
    void testExercici1BasicCRUD() {
        // Test adding a ciutat
        com.project.Exercici1.Ciutat ciutat = 
            com.project.Exercici1.Manager.addCiutat("Madrid", "Spain", "28001");
        assertNotNull(ciutat);
        assertTrue(ciutat.getCiutatId() > 0);
        assertEquals("Madrid", ciutat.getNom());
        
        // Test adding a ciutada
        com.project.Exercici1.Ciutada ciutada = 
            com.project.Exercici1.Manager.addCiutada("Jane", "Smith", 25);
        assertNotNull(ciutada);
        assertTrue(ciutada.getCiutadaId() > 0);
        assertEquals("Jane", ciutada.getNom());
        
        // Test updating ciutat
        Set<com.project.Exercici1.Ciutada> ciutadans = new HashSet<>();
        ciutadans.add(ciutada);
        com.project.Exercici1.Manager.updateCiutat(
            ciutat.getCiutatId(), "New Madrid", "Spain", ciutadans);
        
        // Verify update
        Collection<com.project.Exercici1.Ciutat> ciutats = 
            com.project.Exercici1.Manager.listCollection(com.project.Exercici1.Ciutat.class, null);
        boolean found = ciutats.stream()
            .anyMatch(c -> c.getNom().equals("New Madrid"));
        assertTrue(found);
        
        // Test delete
        com.project.Exercici1.Manager.delete(com.project.Exercici1.Ciutat.class, ciutat.getCiutatId());
        com.project.Exercici1.Manager.delete(com.project.Exercici1.Ciutada.class, ciutada.getCiutadaId());
        
        // Verify deletion
        ciutats = com.project.Exercici1.Manager.listCollection(com.project.Exercici1.Ciutat.class, null);
        found = ciutats.stream()
            .anyMatch(c -> c.getCiutatId() == ciutat.getCiutatId());
        assertFalse(found);
    }

    @Test
    void testCiutatWithCiutadans() {
        // Test for Exercici0
        Ciutat ciutat0 = Manager.addCiutat("Valencia", "Spain", "46001");
        Ciutada ciutada0 = Manager.addCiutada("Alice", "Johnson", 28);
        
        Set<Ciutada> ciutadans0 = new HashSet<>();
        ciutadans0.add(ciutada0);
        Manager.updateCiutat(ciutat0.getCiutatId(), ciutat0.getNom(), ciutat0.getPais(), ciutadans0);
        
        Ciutat retrievedCiutat0 = Manager.getCiutatWithCiutadans(ciutat0.getCiutatId());
        assertNotNull(retrievedCiutat0);
        assertFalse(retrievedCiutat0.getCiutadans().isEmpty());
        
        // Test for Exercici1
        com.project.Exercici1.Ciutat ciutat1 = 
            com.project.Exercici1.Manager.addCiutat("Sevilla", "Spain", "41001");
        com.project.Exercici1.Ciutada ciutada1 = 
            com.project.Exercici1.Manager.addCiutada("Bob", "Wilson", 35);
        
        Set<com.project.Exercici1.Ciutada> ciutadans1 = new HashSet<>();
        ciutadans1.add(ciutada1);
        com.project.Exercici1.Manager.updateCiutat(
            ciutat1.getCiutatId(), ciutat1.getNom(), ciutat1.getPais(), ciutadans1);
        
        com.project.Exercici1.Ciutat retrievedCiutat1 = 
            com.project.Exercici1.Manager.getCiutatWithCiutadans(ciutat1.getCiutatId());
        assertNotNull(retrievedCiutat1);
        assertFalse(retrievedCiutat1.getCiutadans().isEmpty());
    }

    @Test
    void testCollectionToString() {
        // Test for Exercici0
        Ciutat ciutat0 = Manager.addCiutat("Bilbao", "Spain", "48001");
        Collection<Ciutat> ciutats0 = Manager.listCollection(Ciutat.class, null);
        String result0 = Manager.collectionToString(Ciutat.class, ciutats0);
        assertNotNull(result0);
        assertFalse(result0.isEmpty());
        
        // Test for Exercici1
        com.project.Exercici1.Ciutat ciutat1 = 
            com.project.Exercici1.Manager.addCiutat("Malaga", "Spain", "29001");
        Collection<com.project.Exercici1.Ciutat> ciutats1 = 
            com.project.Exercici1.Manager.listCollection(com.project.Exercici1.Ciutat.class, null);
        String result1 = com.project.Exercici1.Manager.collectionToString(
            com.project.Exercici1.Ciutat.class, ciutats1);
        assertNotNull(result1);
        assertFalse(result1.isEmpty());
    }
}
