# Warehouse / Inventory Management System

Java-Anwendung zur Verwaltung von Lagerbeständen.  
Dieses Projekt ist ein Open-Source-Projekt und zeigt grundlegende Konzepte der Softwareentwicklung mit Java, JDBC und MySQL. Ideal als Referenz für Bewerbungen im Bereich **Fachinformatiker Anwendungsentwicklung**.

---

## 🛠 Technologien
- Java 21
- MySQL
- JDBC
- Maven
- JUnit 5 (Unit-Tests)
- SLF4J (Logging)

---

## 🎯 Ziel
Die Anwendung verwaltet:
- Produkte im Lager
- Kategorien der Produkte
- Lieferanten
- Lagerbewegungen (Ein- und Ausgang)
- Berichte über Lagerbestand und Bewegungen

---

## ✅ Funktionen (MVP)
- Produkte anlegen, bearbeiten und deaktivieren
- Kategorien verwalten und Produkte zuordnen
- Lieferanten verwalten
- Lagerbewegungen: Ein- und Ausgang
- Automatische Kontrolle des Lagerbestands
- Berichtsfunktionen:
    - Produkte mit niedrigem Bestand
    - Historie der Bewegungen
    - Gesamtwert des Lagers

---

## 🗂 Datenbankstruktur
Die Datenbank besteht aus folgenden Tabellen:
1. `categories` – Produktkategorien
2. `products` – Produkte mit SKU, Preis, Menge, minimalem Bestand
3. `suppliers` – Lieferanteninformationen
4. `stock_movements` – Historie der Lagerbewegungen

Alle Tabellen nutzen **Primary Keys**, **Foreign Keys** und **AUTO_INCREMENT** für IDs.

---

## 📁 Projektstruktur

```text
WareHouse/
 ├── src/main/java
 │   └── de/example/warehouse
 │       ├── app          # Main-Klasse / Konsolen-Interface
 │       ├── config       # Datenbank- und Applikationskonfiguration
 │       ├── dao          # CRUD-Operationen
 │       ├── db           # Low-Level Datenbankzugriff
 │       ├── dto          # Datenübertragungsobjekte (Input/Output)
 │       ├── exception    # Eigene Exception-Klassen
 │       ├── model        # Business-Entities (Product, Category, Supplier)
 │       ├── service      # Geschäftslogik
 │       └── util         # Hilfsklassen
 ├── src/test/java        # Unit-Tests
 ├── sql                  # SQL-Skripte für Tabellen und Testdaten
 ├── README.md
 └── pom.xml
