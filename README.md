# Require4Testing

Require4Testing ist eine Webanwendung zur Organisation manueller Anwendungstests.

## Funktionen

- Anforderungen anlegen und verwalten
- Testfälle anlegen und Anforderungen zuordnen
- Tester anlegen
- Testläufe anlegen
- Tester einem Testlauf zuordnen
- Testfälle einem Testlauf zuordnen
- Testergebnisse erfassen (OFFEN, BESTANDEN, FEHLGESCHLAGEN)

## Technologien

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven

## Voraussetzungen

- Java
- MySQL

## Datenbank

Vor dem Start muss in MySQL folgende Datenbank angelegt werden:

CREATE DATABASE require4testing;

Die Anwendung verwendet standardmäßig:

- Datenbank: require4testing
- Benutzer: root
- Port: 3306
### MySQL-Passwort setzen

Unter Windows PowerShell muss vor dem Start das eigene MySQL-Passwort gesetzt werden:

$env:DB_PASSWORD="DEIN_MYSQL_PASSWORT"

## Anwendung starten

Unter Windows im Projektordner:

.\mvnw.cmd spring-boot:run

Anschließend ist die Anwendung erreichbar unter:

http://localhost:8080/anforderungen
